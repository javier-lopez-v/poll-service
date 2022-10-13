package com.mx.poll.model;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.mx.poll.model.entity.Client;
import com.mx.poll.model.entity.Observation;
import com.mx.poll.model.entity.Option;
import com.mx.poll.model.entity.Poll;

public record ClientDto(Long idClient, String name, List<PollResponse> polls) {

	public Client createClientEntity() {

		Client client =  new Client(null, this.name, this.polls.stream().map(poll -> new Poll(null, poll.title(), new Date(),
				poll.service(), poll.status(),
				poll.observation().stream().map(observation -> new Observation(null, observation.observationInfo()))
						.collect(Collectors.toList()),
				poll.options().stream().map(option -> new Option(null, option.question(), option.selection()))
						.collect(Collectors.toList()),
				null)).collect(Collectors.toList()));
		
		client.getPolls().stream().forEach(poll -> poll.setClient(client));
		
		return client;
	}

}
