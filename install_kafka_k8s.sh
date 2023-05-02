kubectl create namespace kafka
kubectl config set-context --current --namespace=kafka
helm repo add bitnami https://charts.bitnami.com/bitnami
helm install kafka bitnami/kafka