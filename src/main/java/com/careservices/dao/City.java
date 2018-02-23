/**
 * 
 */
package com.careservices.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * @author JARVIS
 *
 */
@Entity
@Table(name = "city", schema = "public")
public class City {

	private Integer id;
	private String city;
	private String state ;
	
	@GenericGenerator(name = "generator", strategy = "increment")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name = "city", length = 13)
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	@Column(name = "state", length = 13)
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public City() {
		super();
	}
	
	
}
