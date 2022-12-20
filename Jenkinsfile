def version

pipeline {
    agent {
        kubernetes {
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