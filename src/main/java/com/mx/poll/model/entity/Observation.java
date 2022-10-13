package com.mx.poll.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "observation")

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Observation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_observation")
	private Long idObservation;

	@Column(name = "observation_info")
	private String observationInfo;

}
