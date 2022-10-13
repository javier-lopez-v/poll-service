package com.mx.poll.service.test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.Date;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.TestPropertySource;

import com.mx.poll.model.entity.Client;
import com.mx.poll.model.repository.ClientRepository;
import com.mx.poll.service.PollRepositoryService;

@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.properties")
@AutoConfigureTestDatabase
class PollRepositoryServiceTest {

	@MockBean
	private ClientRepository clientRepository;

	@Autowired
	private PollRepositoryService pollRepositoryService;

	@Test
	void getPollByClienteAndDateTest() {
		Date date = new Date();
		when(clientRepository.clientPollByIdDate(1L, date)).thenReturn(new Client());
		assertNotNull(pollRepositoryService.getPollByClienteAndDate(1L, date));
	}

	@Test
	void createPollTest() {
		Client clientEntity = new Client();
		when(clientRepository.save(clientEntity)).thenReturn(new Client());
		assertNotNull(pollRepositoryService.createPoll(clientEntity));
	}

	@Test
	void getClientByIdTest() {
		Optional<Client> optional = Optional.of(new Client());
		when(clientRepository.findById(1L)).thenReturn(optional);
		pollRepositoryService.deleteUSer(null);
		assertNotNull(pollRepositoryService.getClientById(1L));
	}

}
