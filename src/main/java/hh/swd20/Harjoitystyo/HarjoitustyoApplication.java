package hh.swd20.Harjoitystyo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.swd20.Harjoitystyo.domain.ClassImplementation;
import hh.swd20.Harjoitystyo.domain.ClassImplementationRepository;
import hh.swd20.Harjoitystyo.domain.DanceClass;
import hh.swd20.Harjoitystyo.domain.DanceClassRepository;
import hh.swd20.Harjoitystyo.domain.Enrollment;
import hh.swd20.Harjoitystyo.domain.EnrollmentRepository;
import hh.swd20.Harjoitystyo.domain.Student;
import hh.swd20.Harjoitystyo.domain.StudentRepository;
import hh.swd20.Harjoitystyo.domain.Teacher;
import hh.swd20.Harjoitystyo.domain.TeacherRepository;
import hh.swd20.Harjoitystyo.domain.User;
import hh.swd20.Harjoitystyo.domain.UserRepository;
import hh.swd20.Harjoitystyo.domain.UserRepositoryList;

@SpringBootApplication
public class HarjoitustyoApplication {
	private static final Logger log = LoggerFactory.getLogger(HarjoitustyoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(HarjoitustyoApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner danceClassDemo(DanceClassRepository DCrepository, ClassImplementationRepository CIrepository, StudentRepository Srepository, TeacherRepository Trepository, UserRepository Urepository, EnrollmentRepository Erepository, UserRepositoryList UListrepository) {
		return (args) -> {
			log.info("save a few classes");
			
			Trepository.save(new Teacher("Sanni", "Laukkanen", "sanni@hotmail.com", "0446768965"));
			Trepository.save(new Teacher("Pekka", "Pakkala", "pekka@hotmail.com", "0415836989"));
			Teacher teacherPiia = new Teacher("Piia", "Pekkanen", "piia@hotmail.com", "0446768965");
			Trepository.save(teacherPiia);
			Trepository.save(new Teacher("Mari", "Tuominen", "mari@hotmail.com", "0447586944"));
			
			Srepository.save(new Student("Maija", "Poppanen", "maija@gmail.com"));
			Srepository.save(new Student("Mikko", "Mikkonen", "mikko@gmail.com"));
			
			DCrepository.save(new DanceClass("Bachata", 60, "in couples"));
			DCrepository.save(new DanceClass("Salsa", 60, "in couples"));	
			DCrepository.save(new DanceClass("Traditional kizomba", 60, "in couples"));
			DCrepository.save(new DanceClass("Rueda", 45, "sinlge"));	
			DCrepository.save(new DanceClass("Reggaeton", 45, "single"));
			DCrepository.save(new DanceClass("Dominican bachata", 60, "in couples"));
			DCrepository.save(new DanceClass("Salsa ladies style", 60, "single"));
			DCrepository.save(new DanceClass("Urban kizomba", 90, "in couples"));	
			
			//CIrepository.save(new ClassImplementation(DCrepository.findByName("Bachata").get(0), Trepository.findByFirstname("Sanni").get(0), "12.11", "18.00"));
			ClassImplementation implementationBachata =new ClassImplementation(DCrepository.findByName("Bachata").get(0), Trepository.findByFirstname("Sanni").get(0), "12.11", "18.00");
			CIrepository.save(implementationBachata);
			CIrepository.save(new ClassImplementation(DCrepository.findByName("Salsa").get(0), Trepository.findByFirstname("Pekka").get(0), "12.11", "19.00"));
			CIrepository.save(new ClassImplementation(DCrepository.findByName("Reggaeton").get(0), Trepository.findByFirstname("Sanni").get(0), "13.11", "18.00"));
			CIrepository.save(new ClassImplementation(DCrepository.findByName("Rueda").get(0), Trepository.findByFirstname("Piia").get(0), "13.11", "20.00"));
			CIrepository.save(new ClassImplementation(DCrepository.findByName("Urban kizomba").get(0), Trepository.findByFirstname("Mari").get(0), "14.11", "17.00"));
			CIrepository.save(new ClassImplementation(DCrepository.findByName("Dominican bachata").get(0), Trepository.findByFirstname("Mari").get(0), "14.11", "18.15"));
			CIrepository.save(new ClassImplementation(DCrepository.findByName("Bachata").get(0), Trepository.findByFirstname("Piia").get(0), "15.11", "18.30"));
			CIrepository.save(new ClassImplementation(DCrepository.findByName("Salsa").get(0), Trepository.findByFirstname("Pekka").get(0), "16.11", "19.30"));
		
			User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER", "user@gmail.com");
			User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN", "admin@gmail.com");
			Urepository.save(user1);
			Urepository.save(user2);
			
			Erepository.save(new Enrollment(UListrepository.findByUsername("user").get(0), implementationBachata));
			
			log.info("fetch all classes");
			for (DanceClass DanceClass : DCrepository.findAll()) {
				log.info(DanceClass.toString());
			}
			
		};
	}

}
