package com.booleanuk.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name="books")
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column
	private String title;

	@Column
	private String genre;


	private int author_id;

	@ManyToOne
	@JoinColumn(name="id") // kolonnen
	@JsonIgnoreProperties(value={"books"})
	@JsonIgnore
	private Author author;

	@ManyToOne
	@JoinColumn(name="id") // kolonnen
	@JsonIgnoreProperties(value={"books"})
	@JsonIgnore
	private Publisher publisher;
}
