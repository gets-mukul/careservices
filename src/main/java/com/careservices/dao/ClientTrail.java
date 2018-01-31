package com.careservices.dao;

import java.sql.Time;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.GenericGenerator;

/**
 * ClientTrail entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "client_trail", schema = "public", uniqueConstraints = @UniqueConstraint(columnNames = "client_mobile"))

public class ClientTrail extends BaseHibernateDAO implements java.io.Serializable {

	// Fields

	private Integer id;
	private Long buy;
	private Integer clientMobile;
	private String clientName;
	private Date endDate;
	private Date expiryDate;
	private String long_;
	private String lotSize;
	private String script;
	private String segment;
	private Long sell;
	private String short_;
	private Date startDate;
	private String status;
	private Integer stopLoss;
	private String strikePrice;
	private Integer target1;
	private Integer target2;
	private Time time;

	// Constructors

	/** default constructor */
	public ClientTrail() {
	}

	/** minimal constructor */
	public ClientTrail(Integer id, Integer clientMobile, String clientName, Date endDate, Date expiryDate,
			String lotSize, String script, String segment, Date startDate, String status, Integer stopLoss,
			String strikePrice, Integer target1, Integer target2, Time time) {
		this.id = id;
		this.clientMobile = clientMobile;
		this.clientName = clientName;
		this.endDate = endDate;
		this.expiryDate = expiryDate;
		this.lotSize = lotSize;
		this.script = script;
		this.segment = segment;
		this.startDate = startDate;
		this.status = status;
		this.stopLoss = stopLoss;
		this.strikePrice = strikePrice;
		this.target1 = target1;
		this.target2 = target2;
		this.time = time;
	}

	/** full constructor */
	public ClientTrail(Integer id, Long buy, Integer clientMobile, String clientName, Date endDate, Date expiryDate,
			String long_, String lotSize, String script, String segment, Long sell, String short_, Date startDate,
			String status, Integer stopLoss, String strikePrice, Integer target1, Integer target2, Time time) {
		this.id = id;
		this.buy = buy;
		this.clientMobile = clientMobile;
		this.clientName = clientName;
		this.endDate = endDate;
		this.expiryDate = expiryDate;
		this.long_ = long_;
		this.lotSize = lotSize;
		this.script = script;
		this.segment = segment;
		this.sell = sell;
		this.short_ = short_;
		this.startDate = startDate;
		this.status = status;
		this.stopLoss = stopLoss;
		this.strikePrice = strikePrice;
		this.target1 = target1;
		this.target2 = target2;
		this.time = time;
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

	@Column(name = "buy")

	public Long getBuy() {
		return this.buy;
	}

	public void setBuy(Long buy) {
		this.buy = buy;
	}

	@Column(name = "client_mobile", unique = true, nullable = false)

	public Integer getClientMobile() {
		return this.clientMobile;
	}

	public void setClientMobile(Integer clientMobile) {
		this.clientMobile = clientMobile;
	}

	@Column(name = "client_name", nullable = false)

	public String getClientName() {
		return this.clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "end_date", nullable = false, length = 13)

	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "expiry_date", nullable = false, length = 13)

	public Date getExpiryDate() {
		return this.expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	@Column(name = "long")

	public String getLong_() {
		return this.long_;
	}

	public void setLong_(String long_) {
		this.long_ = long_;
	}

	@Column(name = "lot_size", nullable = false)

	public String getLotSize() {
		return this.lotSize;
	}

	public void setLotSize(String lotSize) {
		this.lotSize = lotSize;
	}

	@Column(name = "script", nullable = false)

	public String getScript() {
		return this.script;
	}

	public void setScript(String script) {
		this.script = script;
	}

	@Column(name = "segment", nullable = false)

	public String getSegment() {
		return this.segment;
	}

	public void setSegment(String segment) {
		this.segment = segment;
	}

	@Column(name = "sell")

	public Long getSell() {
		return this.sell;
	}

	public void setSell(Long sell) {
		this.sell = sell;
	}

	@Column(name = "short")

	public String getShort_() {
		return this.short_;
	}

	public void setShort_(String short_) {
		this.short_ = short_;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "start_date", nullable = false, length = 13)

	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	@Column(name = "status", nullable = false)

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name = "stop_loss", nullable = false)

	public Integer getStopLoss() {
		return this.stopLoss;
	}

	public void setStopLoss(Integer stopLoss) {
		this.stopLoss = stopLoss;
	}

	@Column(name = "strike_price", nullable = false)

	public String getStrikePrice() {
		return this.strikePrice;
	}

	public void setStrikePrice(String strikePrice) {
		this.strikePrice = strikePrice;
	}

	@Column(name = "target_1", nullable = false)

	public Integer getTarget1() {
		return this.target1;
	}

	public void setTarget1(Integer target1) {
		this.target1 = target1;
	}

	@Column(name = "target_2", nullable = false)

	public Integer getTarget2() {
		return this.target2;
	}

	public void setTarget2(Integer target2) {
		this.target2 = target2;
	}

	@Column(name = "time", nullable = false, length = 15)

	public Time getTime() {
		return this.time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

}