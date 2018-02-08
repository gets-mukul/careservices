package com.careservices.dao;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	private String paymentAmount;
	private String paymentId;
	private String paymentType;
	private String status;
	private Timestamp createdAt;

	private CareUser createdBy;

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

	/** full constructor */
	public EmployeeTask(Integer id, CareUser careUser, Contact contact, String paymentAmount, String paymentId,
			String paymentType, String status) {
		this.id = id;
		this.actor = careUser;
		this.contact = contact;
		this.paymentAmount = paymentAmount;
		this.paymentId = paymentId;
		this.paymentType = paymentType;
		this.status = status;
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

	@Column(name = "payment_amount")

	public String getPaymentAmount() {
		return this.paymentAmount;
	}

	public void setPaymentAmount(String paymentAmount) {
		this.paymentAmount = paymentAmount;
	}

	@Column(name = "payment_id")

	public String getPaymentId() {
		return this.paymentId;
	}

	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}

	@Column(name = "payment_type")

	public String getPaymentType() {
		return this.paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
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

}