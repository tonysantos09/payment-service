### POST
curl -X POST \
  http://localhost:8080/payment \
  -H 'Content-Type: application/json' \
  -H 'Postman-Token: 66513894-2b74-48d1-9e28-9d89a6a9b879' \
  -H 'cache-control: no-cache' \
  -d '{
    "id": 0,
    "cartao": 70707070,
    "validade": "10/10/2019",
    "valor": 500.00,
    "bandeira": "Master Card"
}'

### GET
curl -X GET \
  http://localhost:8080/payment/0 \
  -H 'Content-Type: application/json' \
  -H 'Postman-Token: f11c740d-a27c-493a-9527-c560c86f39c6' \
  -H 'cache-control: no-cache'

### PUT
curl -X PUT \
  http://localhost:8080/payment/0 \
  -H 'Content-Type: application/json' \
  -H 'Postman-Token: a8b0a30f-e889-4eb0-86f7-1c1a33427e7b' \
  -H 'cache-control: no-cache' \
  -d '{
    "id": 0,
    "cartao": 80808080,
    "validade": "10/10/2019",
    "valor": 500.00,
    "bandeira": "Master Card"
}'

### DELETE
curl -X DELETE \
  http://localhost:8080/payment/0 \
  -H 'Content-Type: application/json' \
  -H 'Postman-Token: b04cef39-b60d-419b-bc77-f259e9ba93c2' \
  -H 'cache-control: no-cache'