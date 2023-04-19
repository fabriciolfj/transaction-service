aws dynamodb --endpoint-url http://localhost:4566 get-item --consistent-read \
    --table-name transaction \
    --key '{ "code": {"S": "1220f72b-b806-4551-b64d-14253f425a09"}, "status": {"S": "approved"}}'