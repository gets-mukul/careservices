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
	private Contact relatedContact;//contact which agree for demo

	private Integer id;
	private Date trailStartDate;
	private Date trailEndDate;
	private Time time;
	private String secrip;
	private String longShort;
	private String segment;
	private Date expityDate;
	private Double strikePrice;
	private Integer lotSizeQty;
	private Long buySell;
	private Integer firstTarget;
	private Integer secondTarget;
	private Integer stopLoss;
	private String status;
	

	// Constructors


	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "contact_id", nullable = false)
	
	public Contact getRelatedContact() {
		return relatedContact;
	}

	public void setRelatedContact(Contact relatedContact) {
		this.relatedContact = relatedContact;
	}

	/** default constructor */
	public ClientTrail() {
	}

	

	/** minimal constructor */
	public ClientTrail(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public ClientTrail(Integer id, String clientName, Long mobile, Date trailStartDate, Date trailEndDate, Time time,
			String secrip, String longShort, String segment, Date expityDate, Double strikePrice, Integer lotSizeQty,
			Long buySell, Integer firstTarget, Integer secondTarget, Integer stopLoss, String status) {

		this.id = id;

		this.trailStartDate = trailStartDate;
		this.trailEndDate = trailEndDate;
		this.time = time;
		this.secrip = secrip;
		this.longShort = longShort;
		this.segment = segment;
		this.expityDate = expityDate;
		this.strikePrice = strikePrice;
		this.buySell = buySell;
		this.firstTarget = firstTarget;
		this.secondTarget = secondTarget;
		this.stopLoss = stopLoss;
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

	@Column(name = "secrip")

	public String getSecrip() {
		return this.secrip;
	}

	public void setSecrip(String secrip) {
		this.secrip = secrip;
	}

	@Column(name = "long_short")

	public String getLongShort() {
		return this.longShort;
	}

	public void setLongShort(String longShort) {
		this.longShort = longShort;
	}

	@Column(name = "segment")

	public String getSegment() {
		return this.segment;
	}

	public void setSegment(String segment) {
		this.segment = segment;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "expity_date", length = 13)

	public Date getExpityDate() {
		return this.expityDate;
	}

	public void setExpityDate(Date expityDate) {
		this.expityDate = expityDate;
	}

	@Column(name = "strike_price", precision = 10)

	public Double getStrikePrice() {
		return this.strikePrice;
	}

	public void setStrikePrice(Double strikePrice) {
		this.strikePrice = strikePrice;
	}

	@Column(name = "lot_size_qty")

	public Integer getLotSizeQty() {
		return this.lotSizeQty;
	}

	public void setLotSizeQty(Integer lotSizeQty) {
		this.lotSizeQty = lotSizeQty;
	}

	@Column(name = "buy_sell")

	public Long getBuySell() {
		return this.buySell;
	}

	public void setBuySell(Long buySell) {
		this.buySell = buySell;
	}

	@Column(name = "first_target")

	public Integer getFirstTarget() {
		return this.firstTarget;
	}

	public void setFirstTarget(Integer firstTarget) {
		this.firstTarget = firstTarget;
	}

	@Column(name = "second_target")

	public Integer getSecondTarget() {
		return this.secondTarget;
	}

	public void setSecondTarget(Integer secondTarget) {
		this.secondTarget = secondTarget;
	}

	@Column(name = "stop_loss")

	public Integer getStopLoss() {
		return this.stopLoss;
	}

	public void setStopLoss(Integer stopLoss) {
		this.stopLoss = stopLoss;
	}

	@Column(name = "status")

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}