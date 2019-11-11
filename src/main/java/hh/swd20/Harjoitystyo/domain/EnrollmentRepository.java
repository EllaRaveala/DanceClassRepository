package hh.swd20.Harjoitystyo.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface EnrollmentRepository extends CrudRepository<Enrollment, Long> {

   List<Enrollment> findByUser(User user);
    
}
