package com.cheer.beans;

import java.math.BigDecimal;
import java.util.Date;

public class Expense {
	private Integer id;
	private String item;
	private String expensed_to;
	private String expensed_by;
	private BigDecimal amount;
	private Date expensed_time;
	private String create_by;
	private Date create_time;
	private String update_by;
	private Date update_time;
	private Integer version;

	public Expense() {
		super();
	}

	public Expense(String item, String expensed_to, String expensed_by, BigDecimal amount, Date expensed_time) {
		super();
		this.item = item;
		this.expensed_to = expensed_to;
		this.expensed_by = expensed_by;
		this.amount = amount;
		this.expensed_time = expensed_time;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public String getExpensed_to() {
		return expensed_to;
	}

	public void setExpensed_to(String expensed_to) {
		this.expensed_to = expensed_to;
	}

	public String getExpensed_by() {
		return expensed_by;
	}

	public void setExpensed_by(String expensed_by) {
		this.expensed_by = expensed_by;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public Date getExpensed_time() {
		return expensed_time;
	}

	public void setExpensed_time(Date expensed_time) {
		this.expensed_time = expensed_time;
	}

	public String getCreate_by() {
		return create_by;
	}

	public void setCreate_by(String create_by) {
		this.create_by = create_by;
	}

	public Date getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}

	public String getUpdate_by() {
		return update_by;
	}

	public void setUpdate_by(String update_by) {
		this.update_by = update_by;
	}

	public Date getUpdate_time() {
		return update_time;
	}

	public void setUpdate_time(Date update_time) {
		this.update_time = update_time;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	@Override
	public String toString() {
		return "Expense [id=" + id + ", item=" + item + ", expensed_to=" + expensed_to + ", expensed_by=" + expensed_by
				+ ", amount=" + amount + ", expensed_time=" + expensed_time + ", create_by=" + create_by
				+ ", create_time=" + create_time + ", update_by=" + update_by + ", update_time=" + update_time
				+ ", version=" + version + "]";
	}
	
	
}
