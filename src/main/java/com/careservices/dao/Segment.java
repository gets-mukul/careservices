package com.careservices.dao;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * Contact entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "segment", schema = "public")

public class Segment extends BaseHibernateDAO implements java.io.Serializable {

	// Fields

	public Segment() {
		super();
		// TODO Auto-generated constructor stub
	}

	private Integer id;
	private String name;
	private Integer parentId;
<<<<<<< HEAD
	private String groupId;
=======
	private Set<ScripCode> scripCodes = new HashSet<>(0);
	private Set<ClientTrail>clientTrails = new HashSet<>(0);
>>>>>>> branch 'master' of https://github.com/gets-mukul/careservices.git
	// Constructors

	@GenericGenerator(name = "generator", strategy = "increment")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "id", unique = true, nullable = false)

	public Integer getId() {
		return this.id;
	}

	public Segment(Integer id, String name, Integer parentId) {
		super();
		this.id = id;
		this.name = name;
		this.parentId = parentId;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "parent_id", nullable = true)
	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

<<<<<<< HEAD
	@Column(name = "group_id")

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

=======

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "segment")
	public Set<ScripCode> getScripCodes() {
		return scripCodes;
	}



	public void setScripCodes(Set<ScripCode> scripCodes) {
		this.scripCodes = scripCodes;
	}


	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "segment")
	public Set<ClientTrail> getClientTrails() {
		return clientTrails;
	}



	public void setClientTrails(Set<ClientTrail> clientTrails) {
		this.clientTrails = clientTrails;
	}

	
>>>>>>> branch 'master' of https://github.com/gets-mukul/careservices.git
}