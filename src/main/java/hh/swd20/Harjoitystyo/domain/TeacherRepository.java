package hh.swd20.Harjoitystyo.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface TeacherRepository extends CrudRepository<Teacher, Long> {

    List<Teacher> findByFirstname(String firstname);
    
}