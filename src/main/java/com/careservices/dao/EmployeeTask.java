package com.careservices.dao;

import java.sql.Timestamp;
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
 * EmployeeTask entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "employee_task", schema = "public")

public class EmployeeTask extends BaseHibernateDAO implements java.io.Serializable {

	// Fields

	private Integer id;
	private CareUser actor;
	private Contact contact;
	
	private String status;
	private Timestamp createdAt;

	private CareUser createdBy;
	private Timestamp updatedAt;
	private Set<ClientTrail> relatedTrails; //kitne trail dia hai contact ko
	// Constructors

	/** default constructor */
	public EmployeeTask() {
	}

	/** minimal constructor */
	public EmployeeTask(Integer id, CareUser careUser, Contact contact) {
		this.id = id;
		this.actor = careUser;
		this.contact = contact;
	}

	

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "increment")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "id", unique = true, nullable = false)

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false)

	public CareUser getActor() {
		return actor;
	}

	public void setActor(CareUser actor) {
		this.actor = actor;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "contact_id", nullable = false)

	public Contact getContact() {
		return this.contact;
	}

	

	public void setContact(Contact contact) {
		this.contact = contact;
	}



	@Column(name = "status")

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name = "created_at")
	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "created_by", nullable = false)
	public CareUser getcreatedBy() {
		return createdBy;
	}

	public void setcreatedBy(CareUser createdBy) {
		this.createdBy = createdBy;
	}
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "relatedTask")
	
	public Set<ClientTrail> getRelatedTrails() {
		return relatedTrails;
	}

	public void setRelatedTrails(Set<ClientTrail> relatedTrails) {
		this.relatedTrails = relatedTrails;
	}

	@Column(name = "updated_at")
	public Timestamp getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	
}