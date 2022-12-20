def version
def newVersion
def app

pipeline {
    agent {
        kubernetes {
            label "homepage-api"
            yamlFile "jenkins-agent.yml"
        }
    }

    parameters {
        booleanParam(name: 'PUBLISH', defaultValue: false, description: 'If `true`, then it will push to Dockerhub.')
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
            steps {
                container("docker") {
                    script {
                        docker.withRegistry('https://registry.hub.docker.com', 'sepe-dockerhub') {
                            app.push(newVersion)
                            app.push("latest")
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