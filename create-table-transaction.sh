aws dynamodb create-table --endpoint-url http://localhost:4566  \
--table-name transaction \
--attribute-definitions \
  AttributeName=code,AttributeType=S \
	AttributeName=status,AttributeType=S \
	AttributeName=date_registry,AttributeType=S \
	AttributeName=payment,AttributeType=S \
--key-schema \
	AttributeName=code,KeyType=HASH \
	AttributeName=status,KeyType=RANGE \
--provisioned-throughput \
ReadCapacityUnits=5,WriteCapacityUnits=5 \
--global-secondary-indexes \
'[
    {
      "IndexName": "datastatus-index",
      "KeySchema": [
        {
           "AttributeName": "payment",
           "KeyType": "HASH"
        },
        {
            "AttributeName": "date_registry",
            "KeyType": "RANGE"
        }
      ],
      "Projection": {
        "ProjectionType": "ALL"
      },
      "ProvisionedThroughput": {
        "ReadCapacityUnits": 10,
        "WriteCapacityUnits": 5
      }
    }
]'