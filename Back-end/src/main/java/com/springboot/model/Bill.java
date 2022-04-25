package com.springboot.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.springboot.util.JsonDate;

@Entity
@Table(name = "BILL")
public class Bill {

	@Id
	@Column(name = "METER_NUMBER")
	@GeneratedValue(generator = "BILL_SEQ")
	@SequenceGenerator(name = "BILL_SEQ", sequenceName = "BILL_SEQ", allocationSize = 1)
	private Long meterNo;

	@Column(name = "BILL_DATE")
	@JsonDeserialize(using = JsonDate.class)
	private Date billDate;

	@Column(name = "CURRENT_UNITS")
	private int currentUnit;

	@Column(name = "PREVIOUS_UNITS")
	private int previousUnit;

	@Column(name = "CONSUMED_UNITS")
	private int consumed;

	@Column(name = "AMOUNT")
	private int amount;

	@Column(name = "DUE_DATE")
	@JsonDeserialize(using = JsonDate.class)
	private Date dueDate;

	@Column(name = "PAID")
	private String paid;

	/* @OneToOne(mappedBy="bill") private Customer customer; */
	 

	public Bill() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Bill(Date billDate, int currentUnit, int previousUnit, int consumed, int amount, Date dueDate, String paid) {
		super();
		this.billDate = billDate;
		this.currentUnit = currentUnit;
		this.previousUnit = previousUnit;
		this.consumed = consumed;
		this.amount = amount;
		this.dueDate = dueDate;
		this.paid = paid;
		//this.customer = customer;
	}

	public Bill(Long meterNo, Date billDate, int currentUnit, int previousUnit, int consumed, int amount, Date dueDate,
			String paid) {
		super();
		this.meterNo = meterNo;
		this.billDate = billDate;
		this.currentUnit = currentUnit;
		this.previousUnit = previousUnit;
		this.consumed = consumed;
		this.amount = amount;
		this.dueDate = dueDate;
		this.paid = paid;
		//this.customer = customer;
	}

	public Long getMeterNo() {
		return meterNo;
	}

	public void setMeterNo(Long meterNo) {
		this.meterNo = meterNo;
	}

	public Date getBillDate() {
		return billDate;
	}

	public void setBillDate(Date billDate) {
		this.billDate = billDate;
	}

	public int getCurrentUnit() {
		return currentUnit;
	}

	public void setCurrentUnit(int currentUnit) {
		this.currentUnit = currentUnit;
	}

	public int getPreviousUnit() {
		return previousUnit;
	}

	public void setPreviousUnit(int previousUnit) {
		this.previousUnit = previousUnit;
	}

	public int getConsumed() {
		return consumed;
	}

	public void setConsumed(int consumed) {
		this.consumed = consumed;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public String getPaid() {
		return paid;
	}

	public void setPaid(String paid) {
		this.paid = paid;
	}

	/*
	 * @JsonBackReference public Customer getCustomer() { return customer; }
	 * 
	 * public void setCustomer(Customer customer) { this.customer = customer; }
	 */

	@Override
	public String toString() {
		return "Bill [meterNo=" + meterNo + ", billDate=" + billDate + ", currentUnit=" + currentUnit
				+ ", previousUnit=" + previousUnit + ", consumed=" + consumed + ", amount=" + amount + ", dueDate="
				+ dueDate + ", paid=" + paid +"]";
	}

}
