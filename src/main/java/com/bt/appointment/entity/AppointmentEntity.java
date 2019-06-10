package com.bt.appointment.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "appointment")
public class AppointmentEntity {
	
	@Id
	@Column(name="ref_id")
	private Long refId;
	
	@Column(name="date")
	private String date;
	
	@Column(name="am_pm")
	private String amPM;
	
	@Column(name="status")
	private String status;

	
	public Long getRefId() {
		return refId;
	}

	public void setRefId(Long refId) {
		this.refId = refId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getAm_pm() {
		return amPM;
	}

	public void setAm_pm(String am_pm) {
		this.amPM = am_pm;
	}

	public String isStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
