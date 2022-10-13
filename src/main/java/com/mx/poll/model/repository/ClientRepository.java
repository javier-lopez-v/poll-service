package com.mx.poll.model.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.mx.poll.model.entity.Client;

public interface ClientRepository extends CrudRepository<Client, Long> {

	@Query("select c from Client c left join fetch c.polls p where c.idCliente=:id and p.date=:date")
	public Client clientPollByIdDate(@Param("id") Long id, @Param("date") Date date);
}
