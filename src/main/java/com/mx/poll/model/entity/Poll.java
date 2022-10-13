package com.mx.poll.model.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "poll")

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Poll {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_poll")
	private Long idPoll;

	@Column(name = "title")
	private String title;

	@Column(name = "date_client")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date date;

	@Column(name = "service")
	private String service;
	
	@Column(name = "status")
	private boolean status;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_poll")
	private List<Observation> observations;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_poll")
	private List<Option> options;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	private Client client;

}
