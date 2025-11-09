package iuh.fit.se.dtos;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

import iuh.fit.se.entities.Address;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;

public class EmployeeDTO {
	private int id;
	
	@NotNull(message = "First Name must not be Null")
	@NotEmpty(message = "First Name must not be Empty")
	private String firstName;
	
	@NotNull(message = "Last Name must not be Null")
	@NotEmpty(message = "Last Name must not be Empty")
	private String lastName;

	private String gender;

	@NotEmpty(message = "Email must not be Empty")
	@Email(message = "Email should be valid")
	private String emailAddress;
	
	@Pattern(regexp = "\\(\\d{3}\\)\\d{3}-\\d{4}", message = "Please input phone number with format: (NNN)NNN-NNNN")
	private String phoneNumber;

	@Past(message = "Date of birth must be less than today")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dob;

	private Date createdDate;
	private Date modifiedDate;
	
	@JsonIgnore
	private Address address;
	
	public EmployeeDTO() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
}
