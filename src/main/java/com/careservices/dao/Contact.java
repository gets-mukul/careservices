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
@Table(name = "contact", schema = "public")

public class Contact extends BaseHibernateDAO implements java.io.Serializable {

	// Fields

	private Integer id;
	private CareUser uploadedBy;//uploaded by
	private String contactLocation;
	private String contactName;
	private Long contactNumber;
	private Set<EmployeeTask> employeeTasks = new HashSet<EmployeeTask>(0);
	private Timestamp uploadedAt;
	

	// Constructors
	
	
	
	

	/** default constructor */
	public Contact() {
	}

	/** minimal constructor */
	public Contact(Integer id, CareUser careUser, Long contactNumber) {
		this.id = id;
		this.uploadedBy = careUser;
		this.contactNumber = contactNumber;
	}

	/** full constructor */
	public Contact(Integer id, CareUser careUser, String contactLocation, String contactName, Long contactNumber,
			Set<EmployeeTask> employeeTasks) {
		this.id = id;
		this.uploadedBy = careUser;
		this.contactLocation = contactLocation;
		this.contactName = contactName;
		this.contactNumber = contactNumber;
		this.employeeTasks = employeeTasks;
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
	@JoinColumn(name = "uploaded_by", nullable = false)

	public CareUser getUploadedBy() {
		return uploadedBy;
	}

	public void setUploadedBy(CareUser uploadedBy) {
		this.uploadedBy = uploadedBy;
	}

	

	@Column(name = "contact_location")

	public String getContactLocation() {
		return this.contactLocation;
	}

	
	public void setContactLocation(String contactLocation) {
		this.contactLocation = contactLocation;
	}

	@Column(name = "contact_name")

	public String getContactName() {
		return this.contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	@Column(name = "contact_number", nullable = false)

	public Long getContactNumber() {
		return this.contactNumber;
	}

	public void setContactNumber(Long contactNumber) {
		this.contactNumber = contactNumber;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "contact")

	public Set<EmployeeTask> getEmployeeTasks() {
		return this.employeeTasks;
	}

	public void setEmployeeTasks(Set<EmployeeTask> employeeTasks) {
		this.employeeTasks = employeeTasks;
	}

	@Column(name = "uploaded_at")
	public Timestamp getUploadedAt() {
		return uploadedAt;
	}

	public void setUploadedAt(Timestamp uploadedAt) {
		this.uploadedAt = uploadedAt;
	}

}