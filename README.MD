# Table of Contents

- [Introduction](#introduction)
- [Dependencies](#Dependencies)
- [Run](#Run)
-[OpenAPI](#OpenAPI)
- [Design](#design)
  * [Endpoints definitions](#endpoints-definitions)
    * [Get poll for id client and date](#get-poll-for-id-client-and-date)
    * [Create a client and poll](#Create-a-client-and-poll)
    * [Update a client and poll](#Update-a-client-and-poll)
    * [Delete a client and poll](#Delete-a-client-and-poll)
# Introduction
Service of poll for client

# Dependencies
  * Spring boot 2.7.4
  * Java 17
  * PostgreSQL 12.11
## Application
The application itself can be customized by the next configuration:

A configuration example to run this service from local, : Modify datasource postgres in the file application.properties:
```properties
...

spring.datasource.url=jdbc:postgresql://YOUR_HOST_BD:5432/YOUR_DATA_BASE
spring.datasource.username=YOUR_USER
spring.datasource.password=YOUR_PASSWORD

...
```
# Run
  * git clone https://github.com/javier-lopez-v/poll-service.git
  * cd poll-service 
  * mvn spring-boot:run 

# OpenAPI
  ```bash
    http://localhost:8080/swagger-ui/index.html#/
  ```

# Design
The next information try to expose the application design

## Endpoints definitions
The application declares the following endpoints:

### Get poll for id client and date

| method      | end-point                   | parameters  | body        |
| ----------- | -----------                 | ----------- | ----------- |
| ``GET``     |``poll/id/{id}/date/{date}`` | id, date    | N/A         |


The next example represents a request:

```bash
curl -X 'GET' \
  'http://localhost:8080/poll/id/1/date/2022-10-13' \
  -H 'accept: application/json'
```

With its corresponding response:

```json
{
  "successful": true,
  "code": 200,
  "message": "Success",
  "payload": {
    "idClient": 1,
    "name": "mario",
    "polls": [
      {
        "title": "encuesta credito",
        "date": "2022-10-13",
        "service": "service 1",
        "status": false,
        "options": [
          {
            "question": "¿consideras juata la tasa de interes?",
            "selection": "A_FAVOR"
          },
          {
            "question": "¿te a servico el credito",
            "selection": "A_FAVOR"
          }
        ],
        "observation": [
          {
            "observationInfo": "montos mas altos"
          },
          {
            "observationInfo": "plazos mas largos"
          }
        ]
      }
    ]
  }
}
```

### Create a client and poll

| method      | end-point                   | parameters  | body  |
| ----------- | -----------                 | ----------- | ----------- |
| ``POST``    | ``/poll``                   | n/a         | ``{"name":"mario","polls":[{"title":"encuesta credito","date":"2022-10-10","service":"service 1","options":[{"question":"¿consideras juata la tasa de interes?","selection":"A_FAVOR"},{"question":"¿te a servico el credito","selection":"A_FAVOR"}],"observation":[{"observationInfo":"montos mas altos"},{"observationInfo":"plazos mas largos"}]}]}`` |


The next example represents a request:

```bash
curl -X 'POST' \
  'http://localhost:8080/poll' \
  -H 'accept: application/json' \
  -H 'Content-Type: application/json' \
  -d '{
		"name": "mario",
		"polls": [
			{
				"title": "encuesta credito",
				"date": "2022-10-10",
				"service": "service 1",
				"options": [
					{
						"question": "¿consideras juata la tasa de interes?",
						"selection": "A_FAVOR"
					},
					{
						"question": "¿te a servico el credito",
						"selection": "A_FAVOR"
					}
				],
				"observation": [
					{
						"observationInfo": "montos mas altos"
					},
					{
						"observationInfo": "plazos mas largos"
					}
				]
			}
		]
	}'
```

With its corresponding response:

```json
{
	"successful": true,
	"code": 200,
	"message": "Success",
	"payload": {
		"idCliente": 3,
		"name": "pepe",
		"polls": [
			{
				"idPoll": 3,
				"title": "encuesta credito",
				"date": "2022-10-13T20:32:15.768+00:00",
				"service": "credit",
				"status": false,
				"observations": [
					{
						"idObservation": 5,
						"observationInfo": "montos mas altos"
					},
					{
						"idObservation": 6,
						"observationInfo": "plazos mas largos"
					}
				],
				"options": [
					{
						"idOption": 5,
						"question": "¿consideras juata la tasa de interes?",
						"selection": "A_FAVOR",
						"selectionE": "A_FAVOR"
					},
					{
						"idOption": 6,
						"question": "¿te a servico el credito",
						"selection": "A_FAVOR",
						"selectionE": "A_FAVOR"
					}
				]
			}
		]
	}
}
```


### Update a client and poll

| method      | end-point                   | parameters  | body  |
| ----------- | -----------                 | ----------- | ----------- |
| ``PUT``     | ``/poll/client/{id}``       | id          | ``{"name":"jose","polls":[{"title":"encuesta credito","date":"2022-10-10","service":"service 1","options":[{"question":"¿consideras juata la tasa de interes?","selection":"A_FAVOR"},{"question":"¿te a servico el credito","selection":"A_FAVOR"}],"observation":[{"observationInfo":"montos mas altos"},{"observationInfo":"plazos mas largos"}]}]}`` |


The next example represents a request:

```bash
curl -X 'PUT' \
  'http://localhost:8080/poll/client/1' \
  -H 'accept: application/json' \
  -H 'Content-Type: application/json' \
  -d '{
	"name": "jose",
	"polls": [
		{
			"title": "encuesta credito",
			"date": "2022-10-10",
			"service": "service 1",
			"options": [
				{
					"question": "¿consideras juata la tasa de interes?",
					"selection": "A_FAVOR"
				},
				{
					"question": "¿te a servico el credito",
					"selection": "A_FAVOR"
				}
			],
			"observation": [
				{
					"observationInfo": "montos mas altos"
				},
				{
					"observationInfo": "plazos mas largos"
				}
			]
		}
	]
}'
```

With its corresponding response:

```json
{
  "successful": true,
  "code": 200,
  "message": "Success update client",
  "payload": {
    "idClient": 1,
    "name": "jose",
    "polls": [
      {
        "title": "encuesta credito",
        "date": "2022-10-13",
        "service": "service 1",
        "status": false,
        "options": [
          {
            "question": "¿consideras juata la tasa de interes?",
            "selection": "A_FAVOR"
          },
          {
            "question": "¿te a servico el credito",
            "selection": "A_FAVOR"
          }
        ],
        "observation": [
          {
            "observationInfo": "montos mas altos"
          },
          {
            "observationInfo": "plazos mas largos"
          }
        ]
      }
    ]
  }
}
```


### Delete a client and poll

| method      | end-point                   | parameters  | body          |
| ----------- | -----------                 | ----------- | -----------   |
| ``DELETE``  | ``/poll/{idClient}``        | idClient    | N/A           |


The next example represents a request:

```bash
curl -X 'DELETE' \
  'http://localhost:8080/poll/2' \
  -H 'accept: application/json'
```

With its corresponding response:

```json
{
  "successful": true,
  "code": 200,
  "message": "Success delete client",
  "payload": "delete user"
}
```