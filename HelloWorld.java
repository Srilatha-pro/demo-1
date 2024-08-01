pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                // Assuming you have your code in a Git repository
                git 'https://your-repo-url.git'
            }
        }
        
        stage('Compile') {
            steps {
                script {
                    def javaHome = tool name: 'JDK11', type: 'jdk'
                    env.PATH = "${javaHome}/bin:${env.PATH}"
                }
                sh 'javac HelloWorld.java'
            }
        }
        
        stage('Run') {
            steps {
                script {
                    def javaHome = tool name: 'JDK11', type: 'jdk'
                    env.PATH = "${javaHome}/bin:${env.PATH}"
                }
                sh 'java HelloWorld'
            }
        }
    }
}
