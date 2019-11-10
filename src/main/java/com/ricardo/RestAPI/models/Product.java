package com.ricardo.RestAPI.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotEmpty(message = "Cant not be empty")
	@NotBlank(message = "Cant not be blank")
	@Column
	@Size(min = 4, max = 255)
	private String name;

	@NotNull(message = "Cant not be null")
	@Column
	@Min(value = 0, message = "Value min is 0")
	@Max(value = 1000, message = "Value max is 100")
	private Integer qtd;

	@Column
	private Date dateCreated;

	public Product() {

	}

	@PrePersist
	public void onPrePersist() {
		if (this.dateCreated == null) {
			this.dateCreated = new Date();
		}
	}

	public Product(Long id, String name, Integer qtd, Date dateCreated) {
		this.id = id;
		this.name = name;
		this.qtd = qtd;
		this.dateCreated = dateCreated;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getQtd() {
		return qtd;
	}

	public void setQtd(Integer qtd) {
		this.qtd = qtd;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	@Override
	public String toString() {
		return "{id: " + this.id + " name: " + this.name + " qtd: " + this.qtd + " dateCreated: " + this.dateCreated
				+ " }";
	}

}
