# Getting Started

### Docker
Run containers (Zookeper, Kafka y Schema Registry)
```
docker compose up -d
```

### Test
```
curl --request POST \
  --url http://localhost:8080/avro/send \
  --header 'Content-Type: application/json' \
  --data '{
	"id": "3f869c59-4b1d-4cd3-9206-ba9947a056cb",
	"firstName": "Frank",
	"lastName": "Sinatra"
}'
```
