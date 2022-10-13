CREATE SCHEMA IF NOT EXISTS serv_poll_service;

/*
DROP TABLE IF EXISTS serv_poll_service.option;
DROP TABLE IF EXISTS serv_poll_service.observation;
DROP TABLE IF EXISTS serv_poll_service.poll;
DROP TABLE IF EXISTS serv_poll_service.client;



CREATE TABLE serv_poll_service.client (
	id_client bigserial NOT NULL,
	"name" varchar(255) NULL,
	CONSTRAINT client_pkey PRIMARY KEY (id_client)
);

CREATE TABLE serv_poll_service.poll (
	id_poll bigserial NOT NULL,
	date_client date NULL,
	service varchar(255) NULL,
	status bool NULL,
	title varchar(255) NULL,
	client_id_client int8 NULL,
	id_client int8 NULL,
	CONSTRAINT poll_pkey PRIMARY KEY (id_poll),
	CONSTRAINT fk11p1xhqb68vecr5a49nfgcj9g FOREIGN KEY (client_id_client) REFERENCES serv_poll_service.client(id_client),
	CONSTRAINT fk1q2lcg8ch6ses2kyayxovkmk6 FOREIGN KEY (id_client) REFERENCES serv_poll_service.client(id_client)
);

CREATE TABLE serv_poll_service.option (
	id_option bigserial NOT NULL,
	question varchar(255) NULL,
	selection varchar(255) NULL,
	id_poll int8 NULL,
	CONSTRAINT option_pkey PRIMARY KEY (id_option),
	CONSTRAINT fkt4cxdg8s4saq8tmrp2xhwxwq8 FOREIGN KEY (id_poll) REFERENCES serv_poll_service.poll(id_poll)
);


CREATE TABLE serv_poll_service.observation (
	id_observation bigserial NOT NULL,
	observation_info varchar(255) NULL,
	id_poll int8 NULL,
	CONSTRAINT observation_pkey PRIMARY KEY (id_observation),
	CONSTRAINT fkr1a4a8ij7jex9u78as81uy3n2 FOREIGN KEY (id_poll) REFERENCES serv_poll_service.poll(id_poll)
);


INSERT INTO serv_poll_service.client
(id_client, "name")
VALUES(1, 'jose');

INSERT INTO serv_poll_service.client
(id_client, "name")
VALUES(2, 'javier');


INSERT INTO serv_poll_service.poll
(id_poll, date_client, service, status, title, client_id_client, id_client)
VALUES(1, '2022-10-13', 'credit', false, 'encuesta credito', 1, 1);


INSERT INTO serv_poll_service.poll
(id_poll, date_client, service, status, title, client_id_client, id_client)
VALUES(2, '2022-10-13', 'credit', false, 'encuesta credito', 2, 2);



INSERT INTO serv_poll_service.option
(id_option, question, selection, id_poll)
VALUES(1, '¿consideras juata la tasa de interes?', 'A FAVOR', 1);
INSERT INTO serv_poll_service.option
(id_option, question, selection, id_poll)
VALUES(2, '¿te a servico el credito', 'A FAVOR', 1);
INSERT INTO serv_poll_service.option
(id_option, question, selection, id_poll)
VALUES(3, '¿consideras juata la tasa de interes?', 'A FAVOR', 2);
INSERT INTO serv_poll_service.option
(id_option, question, selection, id_poll)
VALUES(4, '¿te a servico el credito', 'A FAVOR', 2);




INSERT INTO serv_poll_service.observation
(id_observation, observation_info, id_poll)
VALUES(1, 'montos mas altos', 1);
INSERT INTO serv_poll_service.observation
(id_observation, observation_info, id_poll)
VALUES(2, 'plazos mas largos', 1);
INSERT INTO serv_poll_service.observation
(id_observation, observation_info, id_poll)
VALUES(3, 'montos mas altos', 2);
INSERT INTO serv_poll_service.observation
(id_observation, observation_info, id_poll)
VALUES(4, 'plazos mas largos', 2);




*/

