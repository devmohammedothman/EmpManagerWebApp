package com.channelit.empManager.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Type;
import org.joda.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table (name = "AttendanceLog")
public class AttLog {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne (fetch = FetchType.LAZY )
	@JoinColumn (name = "empid",nullable = false)
	private Employee employee;
	
	@Column (name = "daydate")
	@NotNull
	@DateTimeFormat (pattern = "dd/MM/yyyy")
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
	private LocalDate dayDate;
	
	@Column (name = "logtimein")
	@NotNull
	@DateTimeFormat (pattern = "yyyy/MM/dd hh:mm:ss")
	@Type(type="timestamp")
	@Temporal(TemporalType.TIMESTAMP)
	//@Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private Timestamp logTimeIn;
	
	@Column (name = "logtimeout")
	@NotNull
	@DateTimeFormat (pattern = "yyyy/MM/dd hh:mm:ss")
	@Type(type="timestamp")
	@Temporal(TemporalType.TIMESTAMP)
//	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
	private Timestamp logTimeOut;
	
	@Transient
	private int workingHours;
		
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public LocalDate getDayDate() {
		return dayDate;
	}
	public void setDayDate(LocalDate dayDate) {
		this.dayDate = dayDate;
	}
	public Timestamp getLogTimeIn() {
		return logTimeIn;
	}
	public void setLogTimeIn(Timestamp logTimeIn) {
		this.logTimeIn = logTimeIn;
	}
	public Timestamp getLogTimeOut() {
		return logTimeOut;
	}
	public void setLogTimeOut(Timestamp logTimeOut) {
		this.logTimeOut = logTimeOut;
	}
	
	
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	@SuppressWarnings("deprecation")
	public int getWorkingHours() {
		
		workingHours = this.logTimeOut.getHours() - this.logTimeIn.getHours();
		
		return workingHours;
	}
		
}
