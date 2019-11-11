package hh.swd20.Harjoitystyo.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface DanceClassRepository extends CrudRepository<DanceClass, Long>{
	List<DanceClass> findByName(String name);
}
