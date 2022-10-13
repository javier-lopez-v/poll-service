package com.mx.poll.model;

public record GenericResponse<T> (boolean successful, int code, String message, T payload) {

}
