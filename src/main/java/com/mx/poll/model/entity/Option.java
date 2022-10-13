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
@Table(name = "option")

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Option {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_option")
	private Long idOption;

	@Column(name = "question")
	private String question;

	@Column(name = "selection")
	//@Enumerated(EnumType.STRING)
	private String selection;

}
