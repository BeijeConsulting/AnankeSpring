//package it.beije.ananke.model;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.Table;
//
//
//@Entity
//@Table(name="numeri_telefono")
//public class Telefono {
//
//	@Id
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
//	@Column(name="id")
//	private Integer id;
//
//	@Column(name="id_contatto")
//	private Integer idContatto;
//
//	@Column(name="telefono")
//	private String telefono;
//
//	
//	public Integer getId() {
//		return id;
//	}
//
//	public void setId(Integer id) {
//		this.id = id;
//	}
//
//	public Integer getIdContatto() {
//		return idContatto;
//	}
//
//	public void setIdContatto(Integer idContatto) {
//		this.idContatto = idContatto;
//	}
//
//	public String getTelefono() {
//		return telefono;
//	}
//
//	public void setTelefono(String telefono) {
//		this.telefono = telefono;
//	}
//	
//	public String toString() {
//		StringBuilder builder = new StringBuilder("[")
//				.append("id : ").append(id)
//				.append(", idContatto : ").append(idContatto)
//				.append(", telefono : ").append(telefono).append("]");
//		
//		return builder.toString();
//	}
//
//}
//
//
///*
//CREATE TABLE `numeri_telefono` (
//  `id` int(11) NOT NULL AUTO_INCREMENT,
//  `id_contatto` int(11) NOT NULL,
//  `telefono` varchar(20) NOT NULL,
//  PRIMARY KEY (`id`),
//  KEY `contatto_idx` (`id_contatto`),
//  CONSTRAINT `contatto` FOREIGN KEY (`id_contatto`) REFERENCES `contatti` (`id`)
//) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci
//*/
