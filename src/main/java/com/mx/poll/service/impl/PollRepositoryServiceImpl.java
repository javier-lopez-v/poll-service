package com.mx.poll.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.poll.model.entity.Client;
import com.mx.poll.model.repository.ClientRepository;
import com.mx.poll.service.PollRepositoryService;

@Service
public class PollRepositoryServiceImpl implements PollRepositoryService {

	@Autowired
	private ClientRepository clientRepository;

	@Override
	public Client getPollByClienteAndDate(Long id, Date dataFormateada) {
		return clientRepository.clientPollByIdDate(id, dataFormateada);
	}

	@Override
	public Client createPoll(Client clientEntity) {
		return clientRepository.save(clientEntity);
	}

	@Override
	public Client getClientById(Long id) {
		return clientRepository.findById(id).orElse(null);
	}

	@Override
	public void deleteUSer(Client client) {
		clientRepository.delete(client);
	}

}
