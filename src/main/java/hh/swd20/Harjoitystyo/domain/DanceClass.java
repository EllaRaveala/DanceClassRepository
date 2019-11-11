package hh.swd20.Harjoitystyo.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class DanceClass {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name;
	private int duration;
	private String description;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "danceClass")
	List <ClassImplementation> implementations;
	
	//konstruktorit
	public DanceClass() {
		super();
		this.name = null;
		this.duration = 0;
		this.description= null;
	}
	
	public DanceClass(String name, int duration, String description) {
		super();
		this.name = name;
		this.duration = duration;
		this.description = description;
	}
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	

	/*public List<ClassImplementation> getImplementations() {
		return implementations;
	}

	public void setImplementations(List<ClassImplementation> implementations) {
		this.implementations = implementations;
	}*/

	@Override
	public String toString() {
		return "DanceClass [id=" + id + ", name=" + name + ", duration=" + duration + ", description=" + description + "]";
	}	

}
