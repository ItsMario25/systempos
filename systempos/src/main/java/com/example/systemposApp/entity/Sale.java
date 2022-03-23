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
	private String CityName;
	@Column
	@NotBlank
	private String discount;
	@Column
	@NotBlank
	private String subtotal;
	@Column
	@NotBlank
	private String total;
	@Column
	@NotBlank
	private String iva;
	@Column
	@NotBlank
	private String typePayment;
	@Column
	@NotBlank
	private String receivedValue;
	@Column
	@NotBlank
	private String returnValue;
	
	
}
