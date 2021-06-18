package com.edu.icesi.ci.taller4.back.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.edu.icesi.ci.taller4.back.model.Userr;
import com.edu.icesi.ci.taller4.back.repository.UserrRepository;

@Service
public class MyCustomUserDetailsService implements UserDetailsService {
	
	private UserrRepository userepo;
	
	@Autowired
	public MyCustomUserDetailsService(UserrRepository userepo) {
		this.userepo = userepo;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {		
		Userr user = userepo.findByUserName(username);					
		if(user !=null) {			
			User.UserBuilder builder = User.withUsername(username).password(user.getUserPassword()).roles(user.getUsertype().toString());			
			return builder.build();
		}
		else {			
			throw new UsernameNotFoundException("User not found.");
		}
	}
}