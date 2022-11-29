pipeline {
   
    agent {
        label 'jenkins_agent'
    }

    stages {
        stage('Clean Compile') {
            steps {
                sh "mvn clean compile"

            }
        }
        
        stage('Install') {
            steps {
                
                sh "mvn install"

            }
        }
        /*
        stage('SonarQube Analysis') {
            steps {
                // Analyzing code.
                withSonarQubeEnv('sonar'){
                    sh "mvn sonar:sonar"
                    }
            }
        }
        */
        
        stage('Versioning artifact'){
            steps{
                sh '''mkdir -p versions
                      #cp target/mvc_1.war versions/mvc_1:$BUILD_ID.war
                      cp target/mvc_1.war versions/mvc_1:$VERSION.war

                   '''
                }
            }
            
        
        stage('Artifact'){
            steps{
                    archiveArtifacts 'target/*.war'
                }
            }
        /*    
        stage ('Artifactory Configuration') {
            steps {
                rtServer (
                    id: "artifactory", 
                    url: "http://192.168.56.103:8081/artifactory",

                )

                rtMavenResolver (
                    id: 'maven-resolver',
                    serverId: 'artifactory',
                    releaseRepo: 'libs-release',
                    snapshotRepo: 'libs-snapshot'
                )  
                 
                rtMavenDeployer (
                    id: 'maven-deployer',
                    serverId: 'artifactory',
                    releaseRepo: 'libs-release-local',
                    snapshotRepo: 'libs-snapshot-local'
                )
            }
        }
        
        stage('upload') {
           steps {
              script { 
                 def server = Artifactory.server 'artifactory'
                 def uploadSpec = """{
                    "files": [{
                       "pattern": "/var/lib/jenkins/workspace/com.nagarro.pipeline.maven/target/mvc_1.war",
                       "target": "libs-snapshot-local"
                    }]
                 }"""

                 server.upload(uploadSpec) 
               }
            }
        }

        stage ('Publish build info') {
            steps {
                rtPublishBuildInfo (
                    serverId: "artifactory"
                )
            }
        }
        
        
        /*
        stage('Build Docker Image') {
            steps {
                 // Docker Image build.
                sh "sudo -n docker build -t java-webapp:${BUILD_ID} ."

            }
        }
        */
        
        /*
         stage ('Publish to ECR') {
              steps {
                
                 withEnv(["AWS_ACCESS_KEY_ID=${env.AWS_ACCESS_KEY_ID}", "AWS_SECRET_ACCESS_KEY=${env.AWS_SECRET_ACCESS_KEY}", "AWS_DEFAULT_REGION=${env.AWS_DEFAULT_REGION}"]) 
                 {
                  sh 'aws ecr get-login-password --region ap-northeast-1 | docker login --username AWS --password-stdin 876724398547.dkr.ecr.ap-northeast-1.amazonaws.com'
                  
                  sh "sudo -n docker build -t java-webapp:${BUILD_ID} ."
                  
                  sh 'docker tag java-webapp:${BUILD_ID} 876724398547.dkr.ecr.ap-northeast-1.amazonaws.com/aws_assignment:${BUILD_ID}'
                  
                  sh 'docker push 876724398547.dkr.ecr.ap-northeast-1.amazonaws.com/aws_assignment:${BUILD_ID}'
                 }
            }
        }
        
        
        stage('Run the EC2 Instance') {
            steps {
                 withAWS(credentials: 'ed0cacd2-1903-4cda-be74-eda4593e819a', endpointUrl: 'ec2-18-183-32-231.ap-northeast-1.compute.amazonaws.com', region: 'ap-northeast-1') 
                 {
                 sh 'aws ec2 start-instances --instance-ids   i-04c1f5d406db0d189'                
                 sh 'echo Instance   i-04c1f5d406db0d189 Started'
                 
                 }

            }
        }
        stage('Test for jenkins to connect') {
            steps {
               
               withEnv(["AWS_ACCESS_KEY_ID=${env.AWS_ACCESS_KEY_ID}", "AWS_SECRET_ACCESS_KEY=${env.AWS_SECRET_ACCESS_KEY}", "AWS_DEFAULT_REGION=${env.AWS_DEFAULT_REGION}"])
               {
               
                //sh 'ssh "-o StrictHostKeyChecking=no" -i "/opt/newkey/aws-pem.pem" ec2-user@54.250.199.24 mkdir testingconn1'
               
                sh 'ssh "-o StrictHostKeyChecking=no" -i "/opt/newkey/aws-pem.pem" ec2-user@13.114.213.208 sudo chmod 777 /var/run/docker.sock'
                
                sh 'ssh "-o StrictHostKeyChecking=no" -i "/opt/newkey/aws-pem.pem" ec2-user@13.114.213.208 aws ecr get-login-password --region ap-northeast-1 | docker login --username AWS --password-stdin 876724398547.dkr.ecr.ap-northeast-1.amazonaws.com '
                
                sh 'ssh "-o StrictHostKeyChecking=no" -i "/opt/newkey/aws-pem.pem" ec2-user@13.114.213.208 sudo docker pull 876724398547.dkr.ecr.ap-northeast-1.amazonaws.com/aws_assignment:${BUILD_ID} '
                
                sh 'ssh "-o StrictHostKeyChecking=no" -i "/opt/newkey/aws-pem.pem" ec2-user@13.114.213.208 sudo docker run -d -p 8087:8080 876724398547.dkr.ecr.ap-northeast-1.amazonaws.com/aws_assignment:${BUILD_ID} '
               }
            }
        }
        
        
        */
    }
}
