pipeline {
    agent any

    tools {
        maven "maven"
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scmGit(
                    branches: [[name: '*/main']],
                    extensions: [],
                    userRemoteConfigs: [[
                        credentialsId: 'githubKey',
                        url: 'git@github.com:Bhaskar-10/honours.git'
                    ]]
                )
            }
        }

        stage('Build') {
            steps {
                withEnv(['PATH+EXTRA=/usr/sbin:/usr/bin:/sbin:/bin']) {
                    sh 'mvn clean install'
                }
            }
        }

        stage('Deploy Artifacts') {
            steps {
                withEnv(['PATH+EXTRA=/usr/sbin:/usr/bin:/sbin:/bin']) {
                    sh 'scp -i "/home/bhaskar/Downloads/Hounors.pem" target/devops-0.0.1-SNAPSHOT.jar ubuntu@ec2-13-234-202-183.ap-south-1.compute.amazonaws.com:/home/ec2-user'
                }
            }
        }
    }
}
