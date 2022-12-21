def version
def newVersion
def app

pipeline {
    agent {
        kubernetes {
            label "homepage-api-tmp"
            yamlFile "jenkins-agent.yml"
        }
    }

    parameters {
        booleanParam(name: 'PUBLISH', defaultValue: false, description: 'If `true`, then it will push to Dockerhub.')
        booleanParam(name: 'DEPLOY', defaultValue: false, description: 'If `true`, then it will deploy to K8s.')
    }

    environment {
        IMAGE_NAME = "sebastianpet90/homepage-api"
        VERSION_APPENDIX = "${env.BUILD_NUMBER}"
    }

    stages {
        stage('Set Description and version') {
            steps {
                script {
                    if (params.PUBLISH) currentBuild.description = "Build, Publish + Deploy" else currentBuild.description = "Build Only"
                    version = sh returnStdout: true, script: '. ./gradle.properties && echo -n $version'
                    newVersion = "${version}.${env.VERSION_APPENDIX}"
                }
            }
        }

        stage('Build image') {
            when {
                expression {
                    return params.PUBLISH
                }
            }

            steps {
                container('gradle') {
                    sh "sed -i 's/${version}/${newVersion}/' gradle.properties"
                    sh 'chmod +x gradlew'
                    sh './gradlew clean assemble'
                }
                container("docker") {
                    script {
                        def tag = "${env.IMAGE_NAME}:${newVersion}"
                        sh "sed -i 's/homepage-api-1.0.0/homepage-api-${newVersion}/' Deployment/Dockerfile"
                        app = docker.build(tag, '-f Deployment/Dockerfile .')
                    }
                }
            }
        }

        stage('Push image') {
            when {
                expression {
                    return params.PUBLISH
                }
            }

            steps {
                container("docker") {
                    script {
                        docker.withRegistry('https://registry.hub.docker.com', 'jenkins-docker-access') {
                            app.push(newVersion)
                            app.push("latest")
                        }
                    }
                }
            }
        }

        stage('Deploy to K8s') {
            when {
                expression {
                    return params.DEPLOY
                }
            }

            steps {
                script {
                    sh "sed -i 's/homepage-api:latest/homepage-api:${newVersion}/' Deployment/deployment.yml"
                }
                container("kubectl") {
                    withCredentials([string(credentialsId: 'jenkins-k8s-homepage-access', variable: 'token')]) {
                        script {
                            sh 'kubectl --token=${token} apply -f Deployment/deployment.yml'
                        }
                    }
                }
            }
        }
    }
    post {
        unstable {
            script { currentBuild.result = 'UNSTABLE' }
        }
        failure {
            script { currentBuild.result = 'FAILURE' }
        }
    }
}