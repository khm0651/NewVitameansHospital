pipeline {
  agent any
  stages {
    stage('Ktlint') {
      steps {
        sh './gradlew ktlintCheck'
      }
    }

    stage('Unit Test') {
      steps {
        sh './gradlew clean test'
      }
    }

  }
}