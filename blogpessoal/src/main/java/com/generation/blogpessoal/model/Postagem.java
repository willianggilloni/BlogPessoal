package com.generation.blogpessoal.model;

import java.time.LocalDate;

import javax.persistence.*;
import javax.validation.constraints.*;

import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "tb_postagens")
public class Postagem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "O Atributo é obrigatório e não pode ser vazio!")
	@Size(min = 5,max = 100, message = "O Atributo titulo deve conter no minimo 5 e no maximo 100 caracteres")
	private String titulo;
	
	@NotNull(message = "O Atributo texto é obrigatório!")
	@Size(min = 10, max = 1000, message = "O Atributo texto deve conter no minimo 1-0 e no maximo 1000 caracteres")
	private String texto;
	
	@UpdateTimestamp
	private LocalDate data;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}
	
	
}
