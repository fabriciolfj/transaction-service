aws dynamodb --endpoint-url http://localhost:4566 get-item --consistent-read \
    --table-name transaction \
    --key '{ "code": {"S": "77105048-a196-46d0-bb77-4231dbb20c2f"}, "status": {"S": "pending"}}'