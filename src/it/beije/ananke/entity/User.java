package it.beije.ananke.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@Table(name="user")
public class User {
	
		//Instance fields
		
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		@Column(name="id")
		private int id;

		@Column(name="first_name")
		private String firstName;

		@Column(name="second_name")
		private String secondName;

		@Column(name="email")
		private String email;
		
		@JsonProperty(access = Access.WRITE_ONLY)
		@Column(name="password")
		private String password;

		//Getters and Setters
		
		public int getId() {
			return id;
		}


		public void setId(int id) {
			this.id = id;
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getSecondName() {
			return secondName;
		}

		public void setSecondName(String secondName) {
			this.secondName = secondName;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		
		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}
		
		//ToString
		
		@Override
		public String toString() {
			return "User [id=" + id + ", firstName=" + firstName + ", secondName=" + secondName + ", email=" + email
					+ ", password=" + password + "]";
		}

}
