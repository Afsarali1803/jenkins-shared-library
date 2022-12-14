def call() {
    node {
        env.APPTYPE="python"
        common.lintChecks()
        env.ARGS="-Dsonar.sources=."
        common.sonarChecks()   
        common.testCases()
        env.SONARURL = "172.31.10.167"
        env.NEXUSURL = "172.31.4.161"
        if(env.TAG_NAME != null ) {
            common.artifacts()
        }
    }
}

// def lintChecks() {
//     sh "echo list checks started for payment * * * * ......"
//     sh "echo Lint Checks Completed for $COMPONENT"
// }

// // function call will be called by default, when you call the fileName
// def call() {
//     pipeline{ 
//         agent any
//         environment {
//             SONAR    = credentials('SONAR')
//             SONARURL = "172.31.10.167"
//         }
//         stages {
//             stage('Lint Checks') {
//                 steps {
//                     script {
//                         lintChecks()                  // Use script { when you're using groovy based conventions }
//                     }
//                 }
//             }   
//             stage('Sonar Checks') {
//                 steps {
//                     script {
//                         env.ARGS="-Dsonar.sources=."
//                         common.sonarChecks()                  // Use script { when you're using groovy based conventions }
//                     }
//                 }
//             } 
//             stage('Test Cases') {
//                 parallel {
//                     stage('Unit Testing') {                 
//                         steps {
//                             sh "echo Unit Testing Completed"   
//                                 }
//                             }
//                     stage('Integration Testing') {                 
//                         steps {
//                             sh "echo Integration Testing Completed"   
//                                 }
//                             }
//                     stage('Function Testing') {                 
//                         steps {
//                             sh "echo Function Testing Completed"   
//                                 }
//                             }
//                         }         
//                     }
                    
//                     stage('ABC Checks') {
//                         steps {
//                             sh "echo Performing XYZ Checks"
//                             sh "echo this takes 30 mins"
//                         }
//                     }
//         }
//    // end of stages 
//     }  // end of pipelines
// } // end of call