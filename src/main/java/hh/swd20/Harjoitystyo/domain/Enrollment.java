package hh.swd20.Harjoitystyo.domain;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Enrollment {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name="userid")
	private User user;
	
	@ManyToOne
	@JsonIgnore
    @JoinColumn(name = "implementationid")
	private ClassImplementation implementation;
	
	//konstruktorit
	public Enrollment() {}
	
	public Enrollment(User user, ClassImplementation implementation) {
		super();
		this.user=user;
		this.implementation=implementation;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public ClassImplementation getImplementation() {
		return implementation;
	}

	public void setImplementation(ClassImplementation implementation) {
		this.implementation = implementation;
	}

	@Override
	public String toString() {
		return "Enrollment [id=" + id + ", user=" + user + ", implementation=" + implementation + "]";
	}

}
