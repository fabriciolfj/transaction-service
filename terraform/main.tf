resource "aws_dynamodb_table" "customer" {
  name           = "customer"
  billing_mode   = "PROVISIONED"
  read_capacity  = 20
  write_capacity = 20
  hash_key       = "code"

  attribute {
    name = "code"
    type = "S"
  }
}

resource "aws_dynamodb_table" "transaction" {
  name           = "transaction"
  billing_mode   = "PROVISIONED"
  read_capacity  = 20
  write_capacity = 20
  hash_key       = "code"
  range_key      = "status"

  attribute {
    name = "code"
    type = "S"
  }

  attribute {
    name = "status"
    type = "S"
  }

  attribute {
    name = "payment"
    type = "S"
  }

  attribute {
    name = "date_registry"
    type = "S"
  }

  global_secondary_index {
    name               = "datastatus-index"
    hash_key           = "payment"
    range_key           = "date_registry"
    write_capacity     = 5
    read_capacity      = 10
    projection_type    = "ALL"
  }
}