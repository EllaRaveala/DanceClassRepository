package hh.swd20.Harjoitystyo.webcontroller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import hh.swd20.Harjoitystyo.domain.User;
import hh.swd20.Harjoitystyo.domain.UserRepository;


@Service
public class UserDetailServiceImpl implements UserDetailsService  {
	private final UserRepository Urepository;

	@Autowired
	public UserDetailServiceImpl(UserRepository userRepository) {
		this.Urepository = userRepository;
	}

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {   
    	User curruser = Urepository.findByUsername(username);
        UserDetails user = new org.springframework.security.core.userdetails.User(username, curruser.getPasswordHash(), 
        		AuthorityUtils.createAuthorityList(curruser.getRole()));
        return user;
    }   
} 

