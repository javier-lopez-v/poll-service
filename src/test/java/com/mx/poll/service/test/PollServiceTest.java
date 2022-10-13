package com.mx.poll.service.test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.TestPropertySource;

import com.mx.poll.model.ClientDto;
import com.mx.poll.model.ObservationResponse;
import com.mx.poll.model.OptionResponse;
import com.mx.poll.model.PollResponse;
import com.mx.poll.model.entity.Client;
import com.mx.poll.model.entity.Observation;
import com.mx.poll.model.entity.Option;
import com.mx.poll.model.entity.Poll;
import com.mx.poll.service.PollRepositoryService;
import com.mx.poll.service.PollService;

@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.properties")
@AutoConfigureTestDatabase
class PollServiceTest {

	@Autowired
	private PollService pollService;

	@MockBean
	private PollRepositoryService pollRepositoryService;

	@Test
	void getUserPollByDateErrorNullTest() throws ParseException {

		when(pollRepositoryService.getPollByClienteAndDate(1L, new Date())).thenReturn(null);
		assertNotNull(pollService.getUserPollByDate(1L, "2022-10-10"));
	}

	@Test
	void getUserPollByDateTest() throws ParseException {

		Client client = new Client(1L, "javier", Arrays.asList(new Poll(1L, "Ejemplo 1", new Date(), "service", true,
				Arrays.asList(new Observation(1L, "Ejemplo")), Arrays.asList(new Option(1L, "", "")), null)));

		when(pollRepositoryService.getPollByClienteAndDate(1L, formatDatesearch("2022-10-10"))).thenReturn(client);
		assertNotNull(pollService.getUserPollByDate(1L, "2022-10-10"));
	}

	@Test
	void createUserPollTest() throws ParseException {
		ClientDto clientDto = new ClientDto(1L, "ejemplo", Arrays.asList(new PollResponse("", new Date(), "", false,
				Arrays.asList(new OptionResponse("", "")), Arrays.asList(new ObservationResponse("")))));
		Client client = new Client(1L, "javier", Arrays.asList(new Poll(1L, "Ejemplo 1", new Date(), "service", true,
				Arrays.asList(new Observation(1L, "Ejemplo")), Arrays.asList(new Option(1L, "", "")), null)));

		when(pollRepositoryService.createPoll(client)).thenReturn(client);
		assertNotNull(pollService.createUserPoll(clientDto));
	}

	@Test
	void updateUserPollTest() throws ParseException {
		ClientDto clientDto = new ClientDto(1L, "ejemplo", Arrays.asList(new PollResponse("", new Date(), "", false,
				Arrays.asList(new OptionResponse("", "")), Arrays.asList(new ObservationResponse("")))));
		Client client = new Client(1L, "javier", Arrays.asList(new Poll(1L, "Ejemplo 1", new Date(), "service", true,
				Arrays.asList(new Observation(1L, "Ejemplo")), Arrays.asList(new Option(1L, "", "")), null)));

		when(pollRepositoryService.getClientById(1L)).thenReturn(client);
		when(pollRepositoryService.createPoll(client.updateClientEntity(clientDto))).thenReturn(client);

		assertNotNull(pollService.updateUserPoll(1L, clientDto));
	}

	@Test
	void deleteClientPollTest() throws ParseException {

		Client client = new Client(1L, "javier", Arrays.asList(new Poll(1L, "Ejemplo 1", new Date(), "service", true,
				Arrays.asList(new Observation(1L, "Ejemplo")), Arrays.asList(new Option(1L, "", "")), null)));

		when(pollRepositoryService.getClientById(1L)).thenReturn(client);

		assertNotNull(pollService.deleteClientPoll(1L));
	}

	@Test
	void deleteClientPollErrorNullTest() throws ParseException {

		when(pollRepositoryService.getClientById(1L)).thenReturn(null);

		assertNotNull(pollService.deleteClientPoll(1L));
	}

	private Date formatDatesearch(String date) throws ParseException {
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		return formatter.parse(date);
	}
}
