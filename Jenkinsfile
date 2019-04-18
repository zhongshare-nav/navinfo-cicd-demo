#!groovy
pipeline {
    agent any
	
	environment {
	    REPOSITORY="${GIT_REPO}"
		IMAGE_REPO="${IMAGE_REPO}"
		IMAGE_NAME="${IMAGE_NAME}"
		IMAGE_TAG="${IMAGE_TAG}"
		YAML_FILE="${YAML_FILE}"
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
		stage('开始构建镜像') {
		    steps {
			    echo "starting build iamge..."
				sh "build -t ${IMAGE_REPO}/${IMAGE_NAME}:${IMAGE_TAG}"
				sh "push ${IMAGE_REPO}/${IMAGE_NAME}:${IMAGE_TAG}"
			}
		}
        stage('发布服务') {
		    steps {
			    echo "starting server..."
				sh "kubectl create -f ${YAML_FILE}"
			}
		}		
	}
}