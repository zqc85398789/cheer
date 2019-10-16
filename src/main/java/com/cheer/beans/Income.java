package com.cheer.beans;

import java.math.BigDecimal;
import java.util.Date;

import com.cheer.util.DateUtil;

public class Income {
	private Integer id;
	private String item;
	private String income_source;
	private String received_by;
	private BigDecimal amount;
	private Date received_time;
	private String create_by;
	private Date create_time;
	private String update_by;
	private Date update_time;
	private Integer version;

	public Income() {
		super();
	}

	public Income(String item, String income_source, String received_by, BigDecimal amount, Date received_time) {
		super();
		this.item = item;
		this.income_source = income_source;
		this.received_by = received_by;
		this.amount = amount;
		this.received_time = received_time;
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

	public String getIncome_source() {
		return income_source;
	}

	public void setIncome_source(String income_source) {
		this.income_source = income_source;
	}

	public String getReceived_by() {
		return received_by;
	}

	public void setReceived_by(String received_by) {
		this.received_by = received_by;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public Date getReceived_time() {
		return received_time;
	}

	public void setReceived_time(Date received_time) {
		this.received_time = received_time;
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

	public String getDateTimeLocal() {
		return DateUtil.dateFormat(received_time, DateUtil.DATEMINUTE_PATTERN).replace(' ', 'T');
	}
	
	@Override
	public String toString() {
		return "Income [id=" + id + ", item=" + item + ", income_source=" + income_source + ", received_by="
				+ received_by + ", amount=" + amount + ", received_time=" + received_time + ", create_by=" + create_by
				+ ", create_time=" + create_time + ", update_by=" + update_by + ", update_time=" + update_time
				+ ", version=" + version + "]";
	}

	
}
