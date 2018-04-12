package com.careservices.dao;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.GenericGenerator;

/**
 * CareUser entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "care_user", schema = "public", uniqueConstraints = { @UniqueConstraint(columnNames = "mobile"),
		@UniqueConstraint(columnNames = "email") })

public class CareUser extends BaseHibernateDAO implements java.io.Serializable {

	// Fields

	private Integer id;
	private String code;
	private String email;
	private Long mobile;
	private String name;
	private String password;
	private String userType;
	
	private Set<Contact> uploadedContacts = new HashSet<Contact>(0);//
	private Set<EmployeeTask> employeeTasks = new HashSet<EmployeeTask>(0);// tasks for any particular employee
	private Set<EmployeeTask> employeeTasksByAdmin = new HashSet<EmployeeTask>(0);//tasks assign by admin
	
	private String imageUrl;
	private Set<Trade>trades = new HashSet<>(0);
	// Constructors

	/** default constructor */
	public CareUser() {
	}

	/** minimal constructor */
	public CareUser(Integer id, String email, Long mobile, String name, String password, String userType) {
		this.id = id;
		this.email = email;
		this.mobile = mobile;
		this.name = name;
		this.password = password;
		this.userType = userType;
	}

	/** full constructor */
	public CareUser(Integer id, String code, String email, Long mobile, String name, String password, String userType,
			Set<Contact> contacts, Set<EmployeeTask> employeeTasks) {
		this.id = id;
		this.code = code;
		this.email = email;
		this.mobile = mobile;
		this.name = name;
		this.password = password;
		this.userType = userType;
		this.uploadedContacts = contacts;
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

	@Column(name = "code")

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Column(name = "email", unique = true, nullable = false)

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "mobile", unique = true, nullable = false)

	public Long getMobile() {
		return this.mobile;
	}

	public void setMobile(Long mobile) {
		this.mobile = mobile;
	}

	@Column(name = "name", nullable = false)

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "password", nullable = false)

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "user_type", nullable = false)

	public String getUserType() {
		return this.userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "uploadedBy")

	public Set<Contact> getUploadedContacts() {
		return uploadedContacts;
	}

	public void setUploadedContacts(Set<Contact> uploadedContacts) {
		this.uploadedContacts = uploadedContacts;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "actor")

	public Set<EmployeeTask> getEmployeeTasks() {
		return this.employeeTasks;
	}

	public void setEmployeeTasks(Set<EmployeeTask> employeeTasks) {
		this.employeeTasks = employeeTasks;
	}

	@Column(name = "image_url", nullable = true)
	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "createdBy")
	public Set<EmployeeTask> getEmployeeTasksByAdmin() {
		return employeeTasksByAdmin;
	}

	public void setEmployeeTasksByAdmin(Set<EmployeeTask> employeeTasksByAdmin) {
		this.employeeTasksByAdmin = employeeTasksByAdmin;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "employee")
	public Set<Trade> getTrades() {
		return trades;
	}

	public void setTrades(Set<Trade> trades) {
		this.trades = trades;
	}
}