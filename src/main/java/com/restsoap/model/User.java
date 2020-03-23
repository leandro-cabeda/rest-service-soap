package com.restsoap.model;


public class User {
	
	private int id;
	private String nome;
	private String email;
	private String telefone;
	
	public User() {
		
	}

	
	
	public User(int id, String nome, String email, String telefone) {

		this.id = id;
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (id != other.id)
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Users [id=" + id + ", nome=" + nome + ", email=" + email + ", telefone=" + telefone + "]";
	}
	
	

}
