def call() {
    stage('User Approval') {
        steps {
            input message: 'Please approve the execution', submitter: 'user@example.com'
        }
    }
}
