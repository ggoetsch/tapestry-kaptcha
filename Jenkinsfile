pipeline {
	agent any
  
	tools { 
	      maven 'maven-3.9.9'
	}
  
  	options {
		timestamps()
    	ansiColor("xterm")
    	buildDiscarder(logRotator(numToKeepStr: '20'))
    	disableConcurrentBuilds()
  	}
  	
  	stages {
    
	    stage("Maven Build") {
			steps {
		        withMaven {
		          sh "mvn clean compile"
		        }
		    }
	    }
	    
  
		stage("Maven Deploy") {
      		steps {
		        withMaven {
		          	sh "mvn -P github deploy"
		        }
		   	}
    	}
    

	}
}