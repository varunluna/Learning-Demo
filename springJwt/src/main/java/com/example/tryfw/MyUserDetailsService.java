package com.example.tryfw;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
@Service
public class MyUserDetailsService implements UserDetailsService{

	@Autowired
	UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> user = userRepository.findUserByUsername(username);
		if (user.isPresent())
		{
			System.out.println("........................user found from db : "+user);
			return user.get();
		}
		else
		{
			System.out.println("........................user not found from db : "+user);
			throw new UsernameNotFoundException("user is not found");
		}
	}

}
