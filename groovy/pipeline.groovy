pipeline {
    agent any
    triggers {
        cron('*/15 * * * *')
    }
    libraries {
        lib("zot")
    }
    stages {
        stage('CLeanup Workspace') {
            steps {
                cleanWs()
            }
        }
        stage('Test1') {
            options {
                timeout(time: 30, unit: 'SECONDS')
            }
            parallel {
                stage('Test11') {
                    steps {
                        sh "sleep 5"
                    }
                }
                stage('Test12') {
                    steps {
                        sh "sleep 50"
                    }
                }
            }
            failFast true
        }
    }
    post {
        always {
            catchError {
                sh "sleep 5"
            }
            catchError {
                sh "sleep 5"
            }
            step([$class: "TapPublisher", testResults: "reports/*.tap"])
            step([$class: "JUnitResultArchiver", testResults: "reports/*.xml"])
        }
    }
}

