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
				sh "docker build -t ${IMAGE_REPO}/${IMAGE_NAME}:${IMAGE_TAG} ."
				sh "docker push ${IMAGE_REPO}/${IMAGE_NAME}:${IMAGE_TAG}"
			}
		}
        stage('发布服务') {
		    steps {
			    echo "starting server..."
				kubernetesDeploy configs: 'springboot-demo.yaml', kubeConfig: [path: ''], kubeconfigId: 'b6c9e73e-9d43-4030-8ad3-d483f912ae53', secretName: '', ssh: [sshCredentialsId: '*', sshServer: ''], textCredentials: [certificateAuthorityData: '', clientCertificateData: '', clientKeyData: '', serverUrl: 'https://']
			}
		}		
	}
}