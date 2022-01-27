package com.inti.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

import com.inti.entities.Role;
import com.inti.entities.Utilisateur;
import com.inti.model.UtilisateurDetail;
import com.inti.services.interfaces.IUtilisateurService;

@Service
public class AppUserDetailsService implements UserDetailsService{
	
	@Autowired
	IUtilisateurService utilisateurService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Utilisateur utilisateur=utilisateurService.findbyUsername(username);
		Set<Role> roles=utilisateur.getRoles();
		for (Role role : roles) {
			System.out.println(role.toString());
		}
		// Les profils
		Set<GrantedAuthority> authorities=new HashSet<GrantedAuthority>();
		
		for(Role role:roles) {
			authorities.add(new SimpleGrantedAuthority(role.getLibelle()));
		}
		
		UtilisateurDetail usDetail=new UtilisateurDetail();
		usDetail.setUtilisateur(utilisateur);
		usDetail.setAuthorities(authorities);
		
		return usDetail;
	}

}
