/**
 * 
 */
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
 * @author Mayank
 *
 */
@Entity
@Table(name = "trade", schema = "public")
public class Trade extends BaseHibernateDAO implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Contact contact;
	private ScripCode scrip;
	private Timestamp createdAt;
	private Timestamp updatedAt;
	private Boolean isLong;
	private Boolean isShort;
	private Timestamp expiryDate;
	private Double strikePrice;
	private Double lotSize;
	private Double quantity;
	private Double buyValue;
	private Double sellValue;
	private Double firstTarget;
	private Double secondTarget;
	private Double stopLoss;
	private String status;
	private Double gain;
	private Double loss;
	private ClientTrail trial;
	private CareUser employee;
	public Trade() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
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
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "contact_id", nullable = false)
	public Contact getContact() {
		return contact;
	}
	public void setContact(Contact contact) {
		this.contact = contact;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "scrip_id", nullable = false)
	public ScripCode getScrip() {
		return scrip;
	}
	public void setScrip(ScripCode scrip) {
		this.scrip = scrip;
	}
	
	@Column(name="created_at")
	public Timestamp getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}
	
	@Column(name="updated_at")
	public Timestamp getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	@Column(name="is_long")
	public Boolean getIsLong() {
		return isLong;
	}
	public void setIsLong(Boolean isLong) {
		this.isLong = isLong;
	}
	
	@Column(name="is_short")
	public Boolean getIsShort() {
		return isShort;
	}
	public void setIsShort(Boolean isShort) {
		this.isShort = isShort;
	}
	
	@Column(name="expiry_date")
	public Timestamp getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(Timestamp expiryDate) {
		this.expiryDate = expiryDate;
	}
	
	@Column(name="strike_price")
	public Double getStrikePrice() {
		return strikePrice;
	}
	public void setStrikePrice(Double strikePrice) {
		this.strikePrice = strikePrice;
	}
	
	@Column(name="lot_size")
	public Double getLotSize() {
		return lotSize;
	}
	public void setLotSize(Double lotSize) {
		this.lotSize = lotSize;
	}
	
	@Column(name="quantity")
	public Double getQuantity() {
		return quantity;
	}
	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}
	
	@Column(name="buy")
	public Double getBuyValue() {
		return buyValue;
	}
	public void setBuyValue(Double buyValue) {
		this.buyValue = buyValue;
	}
	
	@Column(name="sell")
	public Double getSellValue() {
		return sellValue;
	}
	public void setSellValue(Double sellValue) {
		this.sellValue = sellValue;
	}
	
	@Column(name="first_target")
	public Double getFirstTarget() {
		return firstTarget;
	}
	public void setFirstTarget(Double firstTarget) {
		this.firstTarget = firstTarget;
	}
	
	@Column(name="second_target")
	public Double getSecondTarget() {
		return secondTarget;
	}
	public void setSecondTarget(Double secondTarget) {
		this.secondTarget = secondTarget;
	}
	
	@Column(name="stop_loss")
	public Double getStopLoss() {
		return stopLoss;
	}
	public void setStopLoss(Double stopLoss) {
		this.stopLoss = stopLoss;
	}
	
	@Column(name="status")
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	@Column(name="gain")
	public Double getGain() {
		return gain;
	}
	public void setGain(Double gain) {
		this.gain = gain;
	}
	
	@Column(name="loss")
	public Double getLoss() {
		return loss;
	}
	public void setLoss(Double loss) {
		this.loss = loss;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "trail_id", nullable = false)
	public ClientTrail getTrial() {
		return trial;
	}
	public void setTrial(ClientTrail trial) {
		this.trial = trial;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "employee_id", nullable = false)
	public CareUser getEmployee() {
		return employee;
	}
	public void setEmployee(CareUser employee) {
		this.employee = employee;
	}

	
	
}
