def version

pipeline {
    agent {
        kubernetes {
            label "homepage-api-${UUID.randomUUID().toString()}"
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
                    if (params.PUBLISH)
                        currentBuild.description = "Build, Publish + Deploy" else
                        currentBuild.description = "Build Only"
                    version = sh returnStdout: true, script: '. ./gradle.properties && echo -n $version'
                }
            }
        }

        stage('Build') {
            steps {
                container('gradle') {
                    sh './gradlew clean assemble'
                }
                container('docker') {
                    script {
                        def tag = "${env.IMAGE_NAME}:${version}.${env.VERSION_APPENDIX}"
                        docker.build(tag, '-f ./Deployment/Dockerfile .')
                    }
                }
            }
        }

        stage('Publish') {
            when {
                expression {
                    return env.PUBLISH
                }
            }
            steps {
                container('docker') {
                    script {
                        def tag = "${env.IMAGE_NAME}:${version}.${env.VERSION_APPENDIX}" as String

                        withCredentials([string(credentialsId: "docker-hub-cred", passwordVariable: 'DOCKER_PASS', usernameVariable: 'DOCKER_USER')]) {
                            sh "docker login -u ${DOCKER_USER} -p ${DOCKER_PASS}"
                            sh "docker push ${DOCKER_USER}/homepage-api:${tag}"
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