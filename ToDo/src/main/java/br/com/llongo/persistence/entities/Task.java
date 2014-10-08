package br.com.llongo.persistence.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Task implements Serializable {
	public Task() {
	}
	private static final long serialVersionUID = 7185813866142443643L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	@Column
	private String title;
	@Column
	private String labelTitle;
	@Column
	private Boolean completed;
	@Column
	private String labelColor;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getLabelTitle() {
		return labelTitle;
	}
	public void setLabelTitle(String labelTitle) {
		this.labelTitle = labelTitle;
	}
	public Boolean getCompleted() {
		return completed;
	}
	public void setCompleted(Boolean completed) {
		this.completed = completed;
	}
	public String getLabelColor() {
		return labelColor;
	}
	public void setLabelColor(String labelColor) {
		this.labelColor = labelColor;
	}

	public Task( String title, String labelTitle, Boolean completed,
			String labelColor) {
		super();
		this.title = title;
		this.labelTitle = labelTitle;
		this.completed = completed;
		this.labelColor = labelColor;
	}

}
