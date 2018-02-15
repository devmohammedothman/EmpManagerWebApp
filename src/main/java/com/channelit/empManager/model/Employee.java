package com.channelit.empManager.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table (name = "Employee" ,
uniqueConstraints = @UniqueConstraint(columnNames = {"username"}))
public class Employee {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotNull
	@Size (min = 3 , max = 50)
	@Column (name = "fname" , nullable = false)
	@NotEmpty (message = "Please Enter First Name")
	private String fname;
	
	@NotNull
	@Size (min = 3 , max = 50)
	@Column (name = "mname" , nullable = false)
	@NotEmpty (message = "Please Enter Middle Name")
	private String mname;
	
	@NotNull
	@Size (min = 3 , max = 50)
	@Column (name = "lname" , nullable = false)
	@NotEmpty (message = "Please Enter Last Name")
	private String lname;
	
	@NotNull
	@Size (min = 3 , max = 50)
	@Column (name = "username" , nullable = false)
	@NotEmpty (message = "Please Enter User Name")
	private String username;
	
	@NotNull
	@Size (min = 3 , max = 50)
	@Column (name = "email" , nullable = false)
	@Pattern (regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\."
	        	+"[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@"
	        	+"(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?",
	             message="Invalid Email")
	private String email;
	
	@NotNull
	@Size (min = 3 , max = 50)
	@Column (name = "password" , nullable = false)
	@NotEmpty (message = "Please Enter Password")
	private String password;
	
	
	@DateTimeFormat (pattern = "dd/MM/yyyy")
	@Column (name = "joiningdate")
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
	private LocalDate joiningdate;
	
	
	@Column (name = "birthdate")
	@DateTimeFormat (pattern = "dd/MM/yyyy")
	@Type (type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
	private LocalDate birthdate;
	
	@Column (name = "deptid")
	private int deptid;
	
	@Column (name = "empid" , nullable = false)
	@Min(value =1,message = "Employee Id must be greater than or equal to 1")
	private int empid;
	
	@Column (name = "active")
	private boolean active = true;
	
	//@OneToMany (fetch = FetchType.LAZY , mappedBy = "employee")
	//will not set this as bidirectional till further notice
	//private Set<AttLog> empAttLogs = new HashSet<>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String passowrd) {
		this.password = passowrd;
	}

	public LocalDate getJoiningdate() {
		return joiningdate;
	}

	public void setJoiningdate(LocalDate joiningdate) {
		this.joiningdate = joiningdate;
	}

	public LocalDate getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(LocalDate birthdate) {
		this.birthdate = birthdate;
	}

	public int getDeptid() {
		return deptid;
	}

	public void setDeptid(int deptid) {
		this.deptid = deptid;
	}

	public int getEmpid() {
		return empid;
	}

	public void setEmpid(int empid) {
		this.empid = empid;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

//	public Set<AttLog> getEmpAttLogs() {
//		return empAttLogs;
//	}
//
//	public void setEmpAttLogs(Set<AttLog> empAttLogs) {
//		this.empAttLogs = empAttLogs;
//	}
	
	/*
	 * @Override
		public int hashCode() 
			{
				final int prime = 31;
				int result = 1;
				result = prime * result + id;
				result = prime * result + ((ssn == null) ? 0 : ssn.hashCode());
				return result;
			}
		@Override
		public boolean equals(Object obj) 
			{
				if (this == obj)
				return true;
				if (obj == null)
				return false;
				if (!(obj instanceof Employee))
				return false;
				Employee other = (Employee) obj;
				if (id != other.id)
				return false;
				if (ssn == null) {
				if (other.ssn != null)
				return false;
				} 
				else if (!ssn.equals(other.ssn))
					return false;
				return true;
			}
		@Override
		public String toString() 
			{
				return "Employee [id=" + id + ", name=" + name + ", joiningDate="
				+ joiningDate + ", salary=" + salary + ", ssn=" + ssn + "]";
			}
	 * */
}
