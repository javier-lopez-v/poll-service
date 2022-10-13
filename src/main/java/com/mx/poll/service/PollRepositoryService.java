package com.mx.poll.service;

import java.util.Date;

import com.mx.poll.model.entity.Client;

public interface PollRepositoryService {

	public Client getPollByClienteAndDate(Long id, Date date);

	public Client createPoll(Client clientEntity);

	public Client getClientById(Long id);

	public void deleteUSer(Client client);

}
