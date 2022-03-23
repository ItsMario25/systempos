package com.example.systemposApp.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;

@Entity 
public class EntryProduct {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="native")
	@GenericGenerator(name="native",strategy="native")
	private Long id;
	
	@Column
	@NotBlank
	private String price;
	@Column
	@NotBlank
	private String stock;
	@Column
	@NotBlank
	private String iva;
	@Column
	@NotBlank
	private String quantity;
	@Column
	@NotBlank
	private String credit;
	@Column
	@NotBlank
	private String dateEntry;
	
	@Size(min=1)
	@OneToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "product_inner",
			joinColumns=@JoinColumn(name="entryProduct_id"),
			inverseJoinColumns=@JoinColumn(name="product_id"))
	private Set<Product> products;
}
