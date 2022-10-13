package com.mx.poll.service.impl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.mx.poll.model.ClientDto;
import com.mx.poll.model.GenericResponse;
import com.mx.poll.model.entity.Client;
import com.mx.poll.service.PollRepositoryService;
import com.mx.poll.service.PollService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PollServiceImpl implements PollService {

	@Autowired
	private PollRepositoryService pollRepositoryService;

	@Override
	public GenericResponse<ClientDto> getUserPollByDate(Long id, String date) throws ParseException {
		log.info("Start get Client by date :::: {} and id ::: {}", date, id);

		Client client = pollRepositoryService.getPollByClienteAndDate(id, formatDatesearch(date));
		if (client != null) {
			log.info("success get client");
			return new GenericResponse<>(true, HttpStatus.OK.value(), "Success", client.getClientResponse());
		}
		log.error("Error client does not exist or there are no surveys for this client");
		return new GenericResponse<>(false, HttpStatus.BAD_REQUEST.value(),
				"Error client does not exist or does not have surveys", null);
	}

	private Date formatDatesearch(String date) throws ParseException {
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		return formatter.parse(date);
	}

	@Override
	public GenericResponse<String> createUserPoll(ClientDto clientResponse) {
		pollRepositoryService.createPoll(clientResponse.createClientEntity());
		return new GenericResponse<>(true, HttpStatus.OK.value(), "Success", "client created successfully");
	}

	@Override
	public GenericResponse<ClientDto> updateUserPoll(Long id, ClientDto clientDto) {
		Client client = pollRepositoryService.getClientById(id);
		Client clientResponse = pollRepositoryService.createPoll(client.updateClientEntity(clientDto));
		return new GenericResponse<>(true, HttpStatus.OK.value(), "Success update client",
				clientResponse.getClientResponse());

	}

	@Override
	public GenericResponse<String> deleteClientPoll(Long idClient) {
		Client client = pollRepositoryService.getClientById(idClient);
		if (client != null) {
			pollRepositoryService.deleteUSer(client);
			return new GenericResponse<>(true, HttpStatus.OK.value(), "Success delete client", "delete user");
		}
		log.error("Error client does not exist");
		return new GenericResponse<>(false, HttpStatus.BAD_REQUEST.value(), "Error client does not exist", null);
	}

}
