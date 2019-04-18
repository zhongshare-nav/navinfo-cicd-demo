#!groovy
pipeline {
    agent any
	
	environment {
	    REPOSITORY="${repo}"
		IMAGE_REPO="${image_repo}"
		IMAGE_NAME="${image_name}"
		IMAGE_TAG="${image_tag}"
		YAML_FILE="${yaml_file}"
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