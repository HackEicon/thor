package br.com.llongo.persistence.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Categorys implements Serializable {
	public Categorys() {
	}
	private static final long serialVersionUID = 7185813866142443644L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	@Column
	private String categoryname;
	@Column
	private String description;
	@Column
	private Boolean active;
	@Column
	private String labelColor;
	
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCategoryname() {
		return categoryname;
	}
	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Boolean getActive() {
		return active;
	}
	public void setActive(Boolean active) {
		this.active = active;
	}
	public String getLabelColor() {
		return labelColor;
	}
	public void setLabelColor(String labelColor) {
		this.labelColor = labelColor;
	}
	
	public Categorys( String categoryname, String description, Boolean active, String labelColor) {
		super();
		this.categoryname = categoryname;
		this.description = description;
		this.active = active;
		this.labelColor = labelColor;
	}

}
