package hh.swd20.Harjoitystyo;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import hh.swd20.Harjoitystyo.domain.ClassImplementation;
import hh.swd20.Harjoitystyo.domain.ClassImplementationRepository;
import hh.swd20.Harjoitystyo.domain.DanceClass;
import hh.swd20.Harjoitystyo.domain.DanceClassRepository;
import hh.swd20.Harjoitystyo.domain.Teacher;
import hh.swd20.Harjoitystyo.domain.TeacherRepository;
import hh.swd20.Harjoitystyo.domain.User;
import hh.swd20.Harjoitystyo.domain.UserRepository;


@RunWith(SpringRunner.class)
@DataJpaTest
public class HarjoitustyoRepositoryTests {

	@Autowired
	private DanceClassRepository DCrepository;
	
	@Autowired
	private TeacherRepository Trepository;
	
	@Autowired
	private ClassImplementationRepository CIrepository;
	
	@Autowired
	private UserRepository Urepository;
	
	DanceClass danceClass1;
	
	@Test
	public void findByNameShouldReturnDanceClass() {
	List<DanceClass> danceClasses = DCrepository.findByName("Bachata");
	assertThat(danceClasses).hasSize(1);
	assertThat(danceClasses.get(0).getDuration()).isEqualTo(60);
	}
	
	@Test
	public void createNewDanceClassShouldBeSuccesful() {
	DanceClass danceClass = new DanceClass("Kizomba ladies style", 60, "single");
	DCrepository.save(danceClass);
	assertThat(danceClass.getId()).isNotNull();
	}
	
	@Test
    public void deleteDanceClassByIdFromRepositoryShouldBeSuccessful() {
        DCrepository.deleteById(danceClass1.getId());
        assertThat(danceClass1.getId()).isNull();
    }
	
	@Test
	public void findByFirstnameShouldReturnTeacher() {
	List<Teacher> teachers = Trepository.findByFirstname("Piia");
	assertThat(teachers).hasSize(1);
	assertThat(teachers.get(0).getLastname()).isEqualTo("Pekkanen");
	}
	
	@Test
	public void createNewImplementation() {
	ClassImplementation implementation = new ClassImplementation(DCrepository.findByName("Bachata").get(0), Trepository.findByFirstname("Piia").get(0), "16.11", "14.00");
	CIrepository.save(implementation);
	assertThat(implementation.getId()).isNotNull();
	}
	
	@Test
	public void findByNameShouldReturnUser() {
	User user = Urepository.findByUsername("user");
	assertThat(user.getRole()).isEqualTo("USER");
	}
	
	@Test
	public void createNewUser() {
	User user = new User("Guest", "gfjjgf", "USER", "guest@gmail.com");
	Urepository.save(user);
	assertThat(user.getId()).isNotNull();
	}
	
	
}
