package hh.swd20.Harjoitystyo.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Long> {

   List<Student> findByFirstname(String firstname);
    
}