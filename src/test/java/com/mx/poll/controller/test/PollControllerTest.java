package com.mx.poll.controller.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.text.ParseException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.TestPropertySource;

import com.mx.poll.controller.PollController;
import com.mx.poll.model.ClientDto;
import com.mx.poll.model.GenericResponse;
import com.mx.poll.model.entity.Client;
import com.mx.poll.service.PollService;

@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.properties")

@AutoConfigureTestDatabase
class PollControllerTest {

	@Autowired
	private PollController pollController;

	@MockBean
	private PollService pollService;

	@Test
	void getPollUserTest() throws ParseException {
		GenericResponse<ClientDto> genericResponse = new GenericResponse<>(true, 200, "", null);

		when(pollService.getUserPollByDate(1L, "2022-10-10")).thenReturn(genericResponse);
		assertEquals(HttpStatus.OK, pollController.getPollUse(1L, "2022-10-10").getStatusCode());
	}

	@Test
	void createUserPollTest() {

		ClientDto client = new ClientDto(1L, null, null);
		GenericResponse<Client> genericResponse = new GenericResponse<>(true, 200, "", null);

		when(pollService.createUserPoll(client)).thenReturn(genericResponse);
		assertEquals(HttpStatus.OK, pollController.createUserPoll(client).getStatusCode());
	}

	@Test
	void updateClientPollTest() {

		ClientDto client = new ClientDto(1L, null, null);
		GenericResponse<ClientDto> genericResponse = new GenericResponse<>(true, 200, "", null);

		when(pollService.updateUserPoll(1L, client)).thenReturn(genericResponse);
		assertEquals(HttpStatus.OK, pollController.updateClientPoll(1L, client).getStatusCode());
	}

	@Test
	void deleteClientPollTest() {

		GenericResponse<String> genericResponse = new GenericResponse<>(true, 200, "", null);

		when(pollService.deleteClientPoll(1L)).thenReturn(genericResponse);
		assertEquals(HttpStatus.OK, pollController.deleteClientPoll(1L).getStatusCode());
	}
}
