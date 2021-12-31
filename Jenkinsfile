pipeline{
	agent{
	    label 'linux'
	}
	tools{ maven 'MAVEN'}
		stages{
			stage('checkout'){
				steps {
					git 'https://github.com/Leeper07/jenkinsAssign1.git'
				}
			}
			
			stage('build'){
				steps {
					sh 'mvn clean compile'
				}
			}
			
			stage('test'){
			    steps{
			        sh 'mvn test'
			        junit '**/target/surefire-reports/Test-*.xml'
			    }   
			}
		}	
}