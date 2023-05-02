eval $(minikube -p minikube docker-env)
kubectl create namespace transaction
mvn clean package -Dquarkus.kubernetes.deploy=true