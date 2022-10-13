package com.mx.poll.model;

import java.util.Date;
import java.util.List;

public record PollResponse(String title, Date date, String service, boolean status, List<OptionResponse> options,
		List<ObservationResponse> observation) {

}
