package br.com.llongo.persistence.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Products implements Serializable {
	
	public Products() {
	}

	private static final long serialVersionUID = 7185813866142443655L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column
	private String productname;
	@Column
	private String description;
	@Column
	private String imagepath;
	
	private Categorys categorys;
	@Column
	private Boolean active;
	@Column
	private double price;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImagepath() {
		return imagepath;
	}

	public void setImagepath(String imagepath) {
		this.imagepath = imagepath;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "categorys_id")
	public Categorys getCategory() {
		return this.categorys;
	}
 
	public void setCategory(Categorys category) {
		this.categorys = category;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Products(String productname, String description, String imagepath, Categorys category, Boolean active, double price) {
		super();
		this.productname = productname;
		this.description = description;
		this.imagepath  = imagepath;
		this.categorys = category;
		this.active = active;
		this.price = price;
	}

}
