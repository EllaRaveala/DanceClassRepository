package hh.swd20.Harjoitystyo.domain;


import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface UserRepositoryList extends CrudRepository<User, Long> {
		List<User> findByUsername(String username);
		}
