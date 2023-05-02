helm repo add localstack https://helm.localstack.cloud/
helm repo update
helm install localstack localstack/localstack --values localstack-values.yaml
