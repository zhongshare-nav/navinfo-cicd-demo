#!groovy
pipeline {
    agent any
	
	environment {
	    REPOSITORY="ssh://git@gitlab01:2222/zhongxiang/zhongxiang01.git"
	}
	
	stages {
	    stage('获取代码') {
		    steps {
			    echo "starting fetch code from git:${REPOSITORY}"
				deleteDir()
				git "${REPOSITORY}"
			}
		}
		stage('代码编译+打包') {
		    steps {
			    echo "starting compiling..."
				sh "mvn clean package"
			}
		}
		stage('构建镜像') {
		    steps {
			    echo "starting build iamge..."
				sh "echo '构建镜像...'"
			}
		}		
	}
}