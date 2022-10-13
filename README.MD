# Table of Contents

- [Introduction](#introduction)
- [Dependencies](#Dependencies)
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
  * PostgreSQL

# Run
  1.- Git clone
  2.- cd poll-service
  3.- mvn spring-boot:run

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
            "selection": "A FAVOR"
          },
          {
            "question": "¿te a servico el credito",
            "selection": "A FAVOR"
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
| ``POST``    | ``/poll``                   | n/a         | ``{"name":"mario","polls":[{"title":"encuesta credito","date":"2022-10-10","service":"service 1","options":[{"question":"¿consideras juata la tasa de interes?","selection":"A FAVOR"},{"question":"¿te a servico el credito","selection":"A FAVOR"}],"observation":[{"observationInfo":"montos mas altos"},{"observationInfo":"plazos mas largos"}]}]}`` |


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
						"selection": "A FAVOR"
					},
					{
						"question": "¿te a servico el credito",
						"selection": "A FAVOR"
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
  "payload": "clien create success"
}
```


### Update a client and poll

| method      | end-point                   | parameters  | body  |
| ----------- | -----------                 | ----------- | ----------- |
| ``POST``    | ``/poll/client/{id}``       | id          | ``{"name":"jose","polls":[{"title":"encuesta credito","date":"2022-10-10","service":"service 1","options":[{"question":"¿consideras juata la tasa de interes?","selection":"A FAVOR"},{"question":"¿te a servico el credito","selection":"A FAVOR"}],"observation":[{"observationInfo":"montos mas altos"},{"observationInfo":"plazos mas largos"}]}]}`` |


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
					"selection": "A FAVOR"
				},
				{
					"question": "¿te a servico el credito",
					"selection": "A FAVOR"
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
            "selection": "A FAVOR"
          },
          {
            "question": "¿te a servico el credito",
            "selection": "A FAVOR"
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
| ``POST``    | ``/poll/{idClient}``        | idClient    | N/A           |


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