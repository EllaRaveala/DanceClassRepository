package hh.swd20.Harjoitystyo.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
//import java.util.Date;
//import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class ClassImplementation {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@ManyToOne
	@JsonIgnore
    @JoinColumn(name = "teacherid")
	private Teacher teacher;
	
	private String time;
	
	private String date;
	
	/*@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date date;*/
	
	@ManyToOne
	@JsonIgnore
    @JoinColumn(name = "danceclassid")
	private DanceClass danceClass;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "implementation")
	private List<Enrollment> enrollments;
	
	public ClassImplementation() {}
	
	public ClassImplementation(Teacher teacher, String time, String date, DanceClass danceClass, List<Enrollment> enrollments) {
		super();
		 this.teacher = teacher;
		 this.time= time;
		 this.date= date;
		 this.danceClass= danceClass;
		 this.enrollments= enrollments;
	}
	
	public ClassImplementation(DanceClass danceClass, Teacher teacher, String date, String time) {
		super();
		this.danceClass= danceClass;
		 this.teacher = teacher;
		 this.time= time;
		 this.date= date;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	
	
	
	/*public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}*/

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public DanceClass getDanceClass() {
		return danceClass;
	}

	public void setDanceClass(DanceClass danceClass) {
		this.danceClass = danceClass;
	}

	public List<Enrollment> getEnrollments() {
		return enrollments;
	}

	public void setEnrollments(List<Enrollment> enrollments) {
		this.enrollments = enrollments;
	}

	@Override
	public String toString() {
		return "ClassImplementation [id=" + id + ", teacher=" + teacher + ", time=" + time + ", date=" + date
				+ ", danceClass=" + danceClass + "]";
	}
	
}