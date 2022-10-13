package com.mx.poll.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mx.poll.model.Selection;

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
	private String selection;

	@JsonIgnore
	public Selection getSelectionEnum() {

		return switch (this.selection) {
		case "A FAVOR" -> Selection.A_FAVOR;

		case "EN CONTRA" -> Selection.EN_CONTRA;

		case "PREFIERO NO CONTESTAR" -> Selection.PREFIERO_NO_CONTESTAR;

		default -> throw new IllegalArgumentException("Unexpected value: " + this.selection);
		};
	}

}
