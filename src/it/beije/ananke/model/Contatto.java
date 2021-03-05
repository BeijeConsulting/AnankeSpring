package it.beije.ananke.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;


@JsonInclude(Include.NON_NULL)
@Entity
@Table(name="contatti")
public class Contatto {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;

	@Column(name="name")
	private String name;

	@Column(name="surname")
	private String surname;

//	@Column(name="telephone")
//	private String telephone;

	@Column(name="email")
	private String email;
	
	/*
	@JsonProperty("numeri_telefono")
	// @OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name="id_contatto")
	private Set<Telefono> numeriTelefono;
	*/
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
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
	
//	public String getTelephone() {
//		return telephone;
//	}
//	public void setTelephone(String telephone) {
//		this.telephone = telephone;
//	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	/*
	public Set<Telefono> getNumeriTelefono() {
		return numeriTelefono;
	}
	public void setNumeriTelefono(Set<Telefono> numeriTelefono) {
		this.numeriTelefono = numeriTelefono;
	}
	*/
	
	
	
	@JsonProperty("data_nascita")
	@Transient
	private LocalDate dataNascita = LocalDate.now();
	
	public LocalDate getDataNascita() {
		return dataNascita;
	}
	public void setDataNascita(LocalDate dataNascita) {
		this.dataNascita = dataNascita;
	}

	@JsonGetter("data_nascita")
	public String getDataNascitaAsString() {
		return dataNascita.format(DateTimeFormatter.ISO_LOCAL_DATE);
	}

	@JsonSetter("data_nascita")
	public void setDataNascita(String dataNascita) {
		this.dataNascita = dataNascita != null ?
				LocalDate.parse(dataNascita, DateTimeFormatter.ofPattern("dd-MM-yyyy"))
				: null;
	}

	
	public String toString() {
		StringBuilder builder = new StringBuilder("[")
				.append("id : ").append(id)
				.append(", name : ").append(name)
				.append(", surname : ").append(surname);
//				.append(", telephone : ").append(telephone)
				/*
				.append(", telephone numbers : ").append(getNumeriTelefono())
				.append(", email : ").append(email).append("]");
				*/
		
		return builder.toString();
	}
	
}
