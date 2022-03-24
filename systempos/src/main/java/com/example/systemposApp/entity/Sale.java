package com.example.systemposApp.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.*;
import org.hibernate.annotations.GenericGenerator;

@Entity 
public class Sale {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="native")
	@GenericGenerator(name="native",strategy="native")
	private Long id;
	
	@Column
	@NotBlank
	private String nameClient;
	@Column
	@NotBlank
	private String total;
	@Column
	@NotBlank
	private String iva;
	@Column
	@NotBlank
	private String receivedValue;
	@Column
	@NotBlank
	private String returnValue;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNameClient() {
		return nameClient;
	}
	public void setNameClient(String cityName) {
		nameClient = cityName;
	}
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}
	public String getIva() {
		return iva;
	}
	public void setIva(String iva) {
		this.iva = iva;
	}
	public String getReceivedValue() {
		return receivedValue;
	}
	public void setReceivedValue(String receivedValue) {
		this.receivedValue = receivedValue;
	}
	public String getReturnValue() {
		return returnValue;
	}
	public void setReturnValue(String returnValue) {
		this.returnValue = returnValue;
	}
	
	
}
