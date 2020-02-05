package com.example.tryfw;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JwtController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtService jwtService;

	@Autowired
	private MyUserDetailsService userDetailsService;
	

	@GetMapping(value = "/token/{user}/{pass}")
	public ResponseEntity<?> getJwtToken(@PathVariable String user, @PathVariable String pass) throws Exception {
		System.out.println("----------------------------------------------------------------"+user +" : "+pass);
		try {
			authenticationManager.authenticate( new UsernamePasswordAuthenticationToken(user, pass));
		}
		catch (BadCredentialsException e) {
			e.printStackTrace();
			throw new Exception("Incorrect username or password", e);
		}
		UserDetails userDetails = userDetailsService.loadUserByUsername(user);
		String jwt = jwtService.generateToken(userDetails);
		return ResponseEntity.ok(jwt);
	}
	
}
