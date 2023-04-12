aws dynamodb --endpoint-url http://localhost:4566 get-item --consistent-read \
    --table-name transaction \
    --key '{ "code": {"S": "538092c7-ba4e-421b-ae81-3bca2d50ccb5"}, "status": {"S": "approved"}}'