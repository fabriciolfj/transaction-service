aws dynamodb create-table --endpoint-url http://localhost:4566  \
--table-name customer \
--attribute-definitions \
  AttributeName=code,AttributeType=S \
--key-schema \
	AttributeName=code,KeyType=HASH \
--provisioned-throughput \
ReadCapacityUnits=5,WriteCapacityUnits=5