package com.sistema.gestao.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty(message = "Nome é obrigatório")
	private String nome;

	@NotEmpty(message = "CPF/CNPJ é obrigatório")
	private String cpfOuCnpj;

	@NotEmpty(message = "Endereço é obrigatório")
	private String endereco;

	@NotEmpty(message = "Telefone é obrigatório")
	private String telefone;

	@Email(message = "Email deve ser válido")
	@NotEmpty(message = "Email é obrigatório")
	private String email;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpfCnpj() {
		return cpfOuCnpj;
	}

	public void setCpfCnpj(String cpfCnpj) {
		this.cpfOuCnpj = cpfCnpj;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
