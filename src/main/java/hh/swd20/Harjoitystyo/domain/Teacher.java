package hh.swd20.Harjoitystyo.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Teacher {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String firstname;
	private String lastname;
	private String email;
	private String phone;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "teacher")
	private List<ClassImplementation> implementations;
	
	//konstruktorit
	public Teacher() {
		super();
		this.firstname = null;
		this.lastname = null;
		this.email= null;
		this.phone=null;
	}
	
	public Teacher(String firstname, String lastname, String email, String phone, List <ClassImplementation> classImplementations) { 
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.email= email;
		this.phone= phone;
		this.implementations=classImplementations;
	}
	
	public Teacher(String firstname, String lastname, String email, String phone) { 
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.email= email;
		this.phone= phone;
	}


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
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

	public List<ClassImplementation> getImplementations() {
		return implementations;
	}

	public void setImplementations(List<ClassImplementation> implementations) {
		this.implementations = implementations;
	}

	@Override
	public String toString() {
		return "Teacher [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", email=" + email
				+ ", phone=" + phone + "]";
	}
	
	
	
}