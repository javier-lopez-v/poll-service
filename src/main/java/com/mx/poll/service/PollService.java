package com.mx.poll.service;

import java.text.ParseException;

import com.mx.poll.model.ClientDto;
import com.mx.poll.model.GenericResponse;
import com.mx.poll.model.entity.Client;

public interface PollService {

	public GenericResponse<ClientDto> getUserPollByDate(Long id, String date) throws ParseException;

	public GenericResponse<Client> createUserPoll(ClientDto clientResponse);

	public GenericResponse<ClientDto> updateUserPoll(Long id, ClientDto client);

	public GenericResponse<String> deleteClientPoll(Long idClient);

}
