package com.mx.poll.model.entity;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.mx.poll.model.ClientDto;
import com.mx.poll.model.ObservationResponse;
import com.mx.poll.model.OptionResponse;
import com.mx.poll.model.PollResponse;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "client")

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_client")
	private Long idCliente;

	@Column(name = "name")
	private String name;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_client")
	private List<Poll> polls;

	public ClientDto getClientResponse() {

		return new ClientDto(this.idCliente, this.name, this.polls.stream()
				.map(poll -> new PollResponse(poll.getTitle(), poll.getDate(), poll.getService(), poll.isStatus(),
						poll.getOptions().stream()
								.map(option -> new OptionResponse(option.getQuestion(), option.getSelection()))
								.collect(Collectors.toList()),
						poll.getObservations().stream()
								.map(observation -> new ObservationResponse(observation.getObservationInfo()))
								.collect(Collectors.toList())))
				.collect(Collectors.toList()));
	}

	public Client updateClientEntity(ClientDto clientDto) {
		this.name = clientDto.name();
		if (this.polls == null) {
			this.polls = Arrays.asList();
		}
		return this;
	}



}
