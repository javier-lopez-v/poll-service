package com.mx.poll.controller;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mx.poll.model.ClientDto;
import com.mx.poll.model.GenericResponse;
import com.mx.poll.model.entity.Client;
import com.mx.poll.service.PollService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
public class PollController {

	@Autowired
	private PollService pollService;

	@Operation(summary = "Buscar encuestas por id y fecha")
	@ApiResponse(responseCode = "200", description = "Se buscara el registro correspondiente al id de el cliente y la fecha solicitada", content = {
			@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = GenericResponse.class))) })
	@GetMapping(path = "/poll/id/{id}/date/{date}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<GenericResponse<ClientDto>> getPollUse(
			@Parameter(description = "id cliente a buscar") @PathVariable(value = "id") Long id,
			@Parameter(description = "fecha de busqueda en formato yyyy-MM-dd") @PathVariable(value = "date") String date)
			throws ParseException {
		GenericResponse<ClientDto> genericResponse = pollService.getUserPollByDate(id, date);

		return new ResponseEntity<>(genericResponse, HttpStatus.valueOf(genericResponse.code()));
	}

	@Operation(summary = "Crear un nuevo registro de un cliente")
	@ApiResponse(responseCode = "200", description = "se crea un nuevo registro", content = {
			@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = GenericResponse.class))) })
	@PostMapping(path = "/poll")
	public ResponseEntity<GenericResponse<Client>> createUserPoll(@RequestBody ClientDto client) {
		GenericResponse<Client> genericResponse = pollService.createUserPoll(client);

		return new ResponseEntity<>(genericResponse, HttpStatus.valueOf(genericResponse.code()));
	}

	@Operation(summary = "Actualiza informacion de el cliente")
	@ApiResponse(responseCode = "200", description = "Actualiza informacion de el cliente", content = {
			@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = GenericResponse.class))) })
	@PutMapping(path = "/poll/client/{id}")
	public ResponseEntity<GenericResponse<ClientDto>> updateClientPoll(
			@Parameter(description = "id cliente a buscar") @PathVariable(value = "id") Long id,
			@RequestBody ClientDto client) {
		GenericResponse<ClientDto> genericResponse = pollService.updateUserPoll(id, client);

		return new ResponseEntity<>(genericResponse, HttpStatus.valueOf(genericResponse.code()));

	}

	@Operation(summary = "Eliminacion informacion encuesta cliente")
	@ApiResponse(responseCode = "200", description = "Eliminacion informacion encuesta cliente", content = {
			@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = GenericResponse.class))) })
	@DeleteMapping(path = "/poll/{idClient}")
	public ResponseEntity<GenericResponse<String>> deleteClientPoll(
			@Parameter(description = "id cliente a buscar") @PathVariable(value = "idClient") Long idClient) {
		GenericResponse<String> genericResponse = pollService.deleteClientPoll(idClient);

		return new ResponseEntity<>(genericResponse, HttpStatus.valueOf(genericResponse.code()));

	}

}
