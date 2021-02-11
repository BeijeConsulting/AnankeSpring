package it.beije.ananke.model;


public class Contatto {
	
	private int id;

	private String name;

	private String surname;

	private String telephone;

	private String email;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getFullname() {
		return name + ' ' + surname;
	}
	
	
	public String toString() {
		StringBuilder builder = new StringBuilder("[")
				.append("id : ").append(id)
				.append(", name : ").append(name)
				.append(", surname : ").append(surname)
				.append(", telephone : ").append(telephone)
				.append(", email : ").append(email).append("]");
		
		return builder.toString();
	}
}
