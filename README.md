# aws-eks-springboot-demo
Demo for EKS deployment for SpringBoot

## EKS CLI installation 
Software download - https://eksctl.io/installation/

**Eksctl installed in the location**
	• C:\Users\Admin\eksctl_Windows_amd64

Add to PATH in env variables. 

## ECR Seup
Create a repository in ECR with Private visibility and default settings.

**To get commands to push the image to ECR**
>Step : Go to Repositories --> select the repository which created above --> click View Push Commands

**Authenticate local docker client to ECR**
```
aws ecr get-login-password --region ap-south-1 | docker login --username AWS --password-stdin 969380626180.dkr.ecr.ap-south-1.amazonaws.com
```

**Build Image**
```
docker build -t springboot-eks
```
		
**Create Image tag**
```
docker tag springboot-eks:latest 969380626180.dkr.ecr.ap-south-1.amazonaws.com/springboot-eks:latest
```
	
**Push the image to ECR**
```
docker push 969380626180.dkr.ecr.ap-south-1.amazonaws.com/springboot-eks:latest
```

**Create EKS Cluster**
```
eksctl create cluster --name javatechie-cluster --version 1.28 --nodes=1 --node-type=t2.small --region ap-south-1
```

`Note : Here version which Kubernetes version is using as part of EKS`

**Update the local Kubernetes config file which (C:\Users\Admin\.kube\config)**
```
 aws eks --region ap-south-1 update-kubeconfig --name <eks-cluster-name>
```
	Eg: 
	Ø aws eks --region ap-south-1 update-kubeconfig --name javatechie-cluster

**Create Deployment and Service in Kubernates using YAML file using kubectl**
```
 Kubectl apply -f k8s.yaml
 ```

**Get application URL**
	• Get External IP from Kubernetes Service
```
kubectl get svc
```
Here
```
C:\Users\Admin\vijay-repo\aws\aws-eks-springboot>kubectl get svc
NAME            TYPE           CLUSTER-IP      EXTERNAL-IP                                                                PORT(S)        AGE
kubernetes      ClusterIP      10.100.0.1      <none>                                                                     443/TCP        33m
myapp-service   LoadBalancer   10.100.34.172   a6f3a3bc9af694e6489581904108197d-1979258220.ap-south-1.elb.amazonaws.com   80:30753/TCP   6m44s
```
**Host: a6f3a3bc9af694e6489581904108197d-1979258220.ap-south-1.elb.amazonaws.com**

Url 
`a6f3a3bc9af694e6489581904108197d-1979258220.ap-south-1.elb.amazonaws.com/welcome`

**Delete AWS EKS and related resource**
```
eksctl delete cluster <cluster-name>
```
Eg: 
	`eksctl delete cluster javatechie-cluster`
