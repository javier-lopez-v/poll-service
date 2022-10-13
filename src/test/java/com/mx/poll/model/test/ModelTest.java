package com.mx.poll.model.test;

import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.web.HttpRequestMethodNotSupportedException;

import com.mx.poll.PollServiceApplication;
import com.mx.poll.exception.CustomException;
import com.mx.poll.exception.RestResponseEntityExceptionHandler;
import com.mx.poll.model.ClientDto;
import com.mx.poll.model.GenericResponse;
import com.mx.poll.model.PollResponse;
import com.mx.poll.model.entity.Client;
import com.mx.poll.model.entity.Observation;
import com.mx.poll.model.entity.Option;
import com.mx.poll.model.entity.Poll;
import com.mx.poll.util.UtilData;

@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.properties")
@AutoConfigureTestDatabase
class ModelTest {

	@Autowired
	private RestResponseEntityExceptionHandler entityExceptionHandler;

	@Autowired
	private UtilData data;

	@Test
	public void main() {
		PollServiceApplication.main(new String[] {});
	}

	@Test
	void GenericResponseTest() {
		data.objectToJsonString(new Object());
		GenericResponse<String> genericResponse = new GenericResponse<>(false, 0, null, null);
		genericResponse.code();
		genericResponse.message();
		genericResponse.payload();
		genericResponse.successful();
		assertNotNull(genericResponse);

	}

	@Test
	void PollResponseTest() {
		PollResponse pollResponse = new PollResponse("", null, null, false, null, null);
		pollResponse.date();
		pollResponse.observation();
		pollResponse.options();
		pollResponse.service();
		pollResponse.status();
		pollResponse.title();

		assertNotNull(pollResponse);

	}

	@Test
	void ClientDtoTest() {
		ClientDto clientDto = new ClientDto(1L, "", null);
		clientDto.idClient();
		clientDto.name();
		clientDto.polls();
		assertNotNull(clientDto);

	}

	@Test
	void ClientTest() {
		Client client = new Client();

		client.setIdCliente(null);
		client.setName(null);
		client.setPolls(null);
		client.getIdCliente();
		client.getName();
		client.getPolls();
		client.updateClientEntity(new ClientDto(1L, "sdfsdf", null));
		assertNotNull(client);

	}

	@Test
	void OptionTest() {
		Option option = new Option();

		option.setIdOption(null);
		option.setQuestion(null);
		option.getIdOption();
		option.getQuestion();
		option.getSelection();

		option.setSelection("EN CONTRA");
		option.getSelectionEnum();
		option.setSelection("PREFIERO NO CONTESTAR");
		option.getSelectionEnum();

		option.setSelection("PREFIERO NO sdf");

		assertThrows(IllegalArgumentException.class, () -> {
			option.getSelectionEnum();
		});
		assertNotNull(option);

	}

	@Test
	void ObservationTest() {
		Observation observation = new Observation();

		observation.setIdObservation(null);
		observation.setObservationInfo(null);
		observation.getIdObservation();
		observation.getObservationInfo();

		assertNotNull(observation);

	}

	@Test
	void PollTest() {
		Poll poll = new Poll();

		poll.setClient(null);
		poll.setDate(null);
		poll.setIdPoll(null);
		poll.setObservations(null);
		poll.setOptions(null);
		poll.setService(null);
		poll.setService(null);
		poll.setStatus(false);
		poll.setTitle(null);
		poll.getClient();
		poll.getDate();
		poll.getIdPoll();
		poll.getObservations();
		poll.getOptions();
		poll.getService();
		poll.getTitle();

		assertNotNull(poll);

	}

	@Test
	void entityExceptionHandlerTest() {

		CustomException customException = new CustomException(null, null, null);
		customException.getLevel();
		customException.getMessage();
		customException.getStatus();

		ParseException parseException = new ParseException("Error", 400);
		HttpRequestMethodNotSupportedException httpRequestMethodNotSupportedException = new HttpRequestMethodNotSupportedException(
				"ERROR");

		entityExceptionHandler.handleAccessDeniedException(parseException);
		entityExceptionHandler.handleHttpRequestMethodNotSupported(httpRequestMethodNotSupportedException, null, null,
				null);
		assertNotNull(parseException);

	}

}
