package com.careservices.dao;

import java.sql.Time;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

/**
 * ClientTrail entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "client_trail", schema = "public")

public class ClientTrail extends BaseHibernateDAO implements java.io.Serializable {

	// Fields
	

	private Integer id;
	private Date trailStartDate;
	private Date trailEndDate;
	private Time time;	
	private Segment segment;
	private String status;
	private EmployeeTask relatedTask;

	// Constructors


	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "employee_task_id", nullable = false)
	public EmployeeTask getRelatedTask() {
		return relatedTask;
	}



	public void setRelatedTask(EmployeeTask relatedTask) {
		this.relatedTask = relatedTask;
	}
	

	/** default constructor */
	public ClientTrail() {
	}

	

	



	/** minimal constructor */
	public ClientTrail(Integer id) {
		this.id = id;
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

	@Temporal(TemporalType.DATE)
	@Column(name = "trail_start_date", length = 13)

	public Date getTrailStartDate() {
		return this.trailStartDate;
	}

	public void setTrailStartDate(Date trailStartDate) {
		this.trailStartDate = trailStartDate;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "trail_end_date", length = 13)

	public Date getTrailEndDate() {
		return this.trailEndDate;
	}

	public void setTrailEndDate(Date trailEndDate) {
		this.trailEndDate = trailEndDate;
	}

	@Column(name = "time", length = 15)

	public Time getTime() {
		return this.time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

	

	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "segment_id", nullable = false)
	public Segment getSegment() {
		return this.segment;
	}

	public void setSegment(Segment segment) {
		this.segment = segment;
	}



	@Column(name = "status")

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}