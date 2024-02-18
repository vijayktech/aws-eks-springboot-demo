FROM openjdk:17
ADD target/aws-eks-springboot-demo.jar aws-eks-springboot-demo.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "aws-eks-springboot-demo.jar"]