package hh.swd20.Harjoitystyo.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ClassImplementationRepository extends CrudRepository<ClassImplementation, Long> {

   List<ClassImplementation> findByTeacher(Teacher teacher);
    
}
