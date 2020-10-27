package com.entities;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "candidate")
public class User {
	
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "id")
	    private int id;
	 @NotEmpty(message = "Please enter your username")
	 @Size(min =4, message = "Your password must contain 4 characters")
		
	private String username;
	 	//  @Id
	 // @Column(name = "email",unique=true,columnDefinition="VARCHAR(45)",nullable = false)
	@NotEmpty(message = "Please enter your password")
	 @Size(min =8, message = "Your password must contain 8 characters")
	
	  private String password;
	  @DateTimeFormat(pattern = "dd/MM/yyyy")
	  @NotNull(message = "Please enter your dob")
	  @Temporal(value=TemporalType.DATE)

	  private Date dob;
	  @NotEmpty(message = "Please enter your email")
	  @Email(message = "Enter a valid email")

	  private String email;
	  @Size(min=10,max=10,message = "Phone number must contain 10 digits") 
	  @NotEmpty(message = "Please enter your phone")
	  @Pattern(regexp="(^$|[0-9]{10})",message = "Invalid number format")
	  private String phone;
	  
	  @OneToOne(mappedBy="user",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
		@JoinColumn(name = "jid")
  	private JobProcessDetails jobprocessdetails;
	 
	  public String getUsername() {
	    return username;
	  }

	  public int getId() {
	        return id;
	    }

	    public void setId(int id) {
	        this.id = id;
	    }

	  public void setUsername(String username) {
	    this.username = username;
	  }

	  public String getPassword() {
	    return password;
	  }

	  public void setPassword(String password) {
	    this.password = password;
	  }

	
	  public String getEmail() {
	    return email;
	  }

	  public void setEmail(String email) {
	    this.email = email;
	  }

	
	  public String getPhone() {
	    return phone;
	  }

	  public void setPhone(String phone) {
	    this.phone = phone;
	  }
	  public Date getDob() {
		    return dob;
		  }

		  public void setDob(Date dob) {
		    this.dob = dob;
		  }
		  
		  
		  public JobProcessDetails getJobProcessDetails() {
		        return jobprocessdetails;
		    }
		 
		    public void setJobProcessDetails(JobProcessDetails jobprocessdetails) {
		        this.jobprocessdetails = jobprocessdetails;
		    }
		  
		  
	  @Override
		public String toString() {
			return "User [id=" + id +"username=" + username + ", password=" + password  + ", dob=" + dob+", email=" + email + ",phone="+phone+"]";
		}

}
