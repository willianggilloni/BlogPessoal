package com.generation.blogpessoal.model;

import java.time.LocalDateTime;

import javax.persistence.*;
import javax.validation.constraints.*;

import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_postagens")
public class Postagem {
	/**
	 * A anotação @ID inidica que o atributo é a chave primária da tabela
	 * 
	 * A anotação @GeneratedValue indica que a chave primária será gerada
	 * automaticamente pelo Banco de Dados.
	 * 
	 * O parâmetro strategy indica como a Chave Primária será gerada. 
	 * 
     * A opção GenerationType.IDENTITY indica que será uma sequência numérica iniciando
	 * em 1 e será responsabilidade do Banco de dados gerar esta sequência, ou seja,
	 * a propriedade auto_increment do SQL. 
	 * 
	 * Não confundir o auto-incremento do Banco de Dados que inicia em 1 com o
	 * indice de um Array (Vetor ou Matriz) que inicia em 0.
	 * 
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long id; 

	/**
	 * A anotação @NotNull indica que um atributo não pode ser nulo
	 * 
	 * O parâmtero message insere uma mensagem que será exibida caso o
	 * atributo seja nulo
	 * 
     * A anotação @NotBlank indica que um atributo não pode ser nulo e 
	 * também não pode ser deixado em branco (vazio).
	 * 
	 * A anotação @Size tem a função de definir o tamanho minimo e máximo de
	 * caracteres de um atributo String. Não é obrigatório definir os 2 parâmetros, 
	 * você pode definir apenas um deles de acordo com as necessidades do seu
     * projeto.
	 * 
	 *                            ***IMPORTANTE*** 
	 * 
	 * Para utilizar as anotações acima, não esqueça de inserir a Dependência 
	 * Validation na criação do projeto ou insira manualmente no arquivo pom.xml
	 * 
	 */
	@NotBlank(message = "O atributo título é Obrigatório e não pode utilizar espaços em branco!") 
	@Size(min = 5, max = 100, message = "O atributo título deve conter no mínimo 05 e no máximo 100 caracteres")
	private String titulo; 

	@NotNull(message = "O atributo texto é Obrigatório!")
	@Size(min = 10, max = 1000, message = "O atributo texto deve conter no mínimo 10 e no máximo 500 caracteres")
	private String texto;

	/**
	 * A anotação @UpdateTimestamp Indica se o atributo receberá um Timestamp (Data e hora do sistema)
	 * e sempre que a Postagem for atualizada o atributo também será atualizado.
	 */
	@UpdateTimestamp
	private LocalDateTime data;

	/**
	 *  Anotação @ManyToOne: Anotação que indica que a Classe Postagem terá um relacionamento
	 *  do tipo Many To One (Muitos para Um) com a Classe Tema
	 *  
	 *  Anotação @JsonIgnoreProperties("postagem"): Anotação que desabilita a recursividade
	 *  infinita durante a exibição dos dados no formato JSON (Desserialização).
	 *  
	 *  private Tema tema;: Objeto do tipo Tema que atuará como a "chave estrangeira" da Classe
	 *  Postagem na relação com a Classe Tema, além de exibir o tema da postagem
	 * 
	 *  Não esqueça de criar os métodos getters e setters para o atributo tema.
	 */

	@ManyToOne
	@JsonIgnoreProperties("postagem")
	private Tema tema;

	@ManyToOne
	@JsonIgnoreProperties("postagem")
	private Usuario usuario;
	/**
	 * 
	 * Os Métodos Get e Set obrigatoriamente devem ser criados para todos os atributos
     * da Classe, inclusive os novos atributos que forem adicionados no decorrer do
     * processo de Desenvolvimento.
	 * 
	 */	
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

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	/**
	 * Métodos Get e Set para o atributo tema
	 */
	public Tema getTema() {
		return this.tema;
	}

	public void setTema(Tema tema) {
		this.tema = tema;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	
}
