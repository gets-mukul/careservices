package com.careservices.dao;

import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

/**
 * ScripCode entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "scrip_code", schema = "public")

public class ScripCode extends BaseHibernateDAO implements java.io.Serializable {

	// Fields

	private Integer id;
	private String symbol;
	private Date expiry;
	private Integer mktLot;
	private Segment segment;
	private Set<Trade>trades = new HashSet<>(0);
	// Constructors

	/** default constructor */
	public ScripCode() {
	}

	/** minimal constructor */
	public ScripCode(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public ScripCode(Integer id, String symbol, Date expiry, Integer mktLot) {
		this.id = id;
		this.symbol = symbol;
		this.expiry = expiry;
		this.mktLot = mktLot;
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

	@Column(name = "symbol")

	public String getSymbol() {
		return this.symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "expiry", length = 13)

	public Date getExpiry() {
		return this.expiry;
	}

	public void setExpiry(Date expiry) {
		this.expiry = expiry;
	}

	@Column(name = "mkt_lot")

	public Integer getMktLot() {
		return this.mktLot;
	}

	public void setMktLot(Integer mktLot) {
		this.mktLot = mktLot;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "segment_id", nullable = false)
	public Segment getSegment() {
		return segment;
	}

	public void setSegment(Segment segment) {
		this.segment = segment;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "scrip")
	public Set<Trade> getTrades() {
		return trades;
	}

	public void setTrades(Set<Trade> trades) {
		this.trades = trades;
	}
}