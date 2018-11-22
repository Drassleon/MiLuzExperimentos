package com.marcelo.miluz.models.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.marcelo.miluz.models.entity.Rol;
import com.marcelo.miluz.models.entity.Usuarios;
import com.marcelo.miluz.models.repository.UsuarioRepository;

@Service
public class JpaUserDetailsService implements UserDetailsService{

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Usuarios usuario = usuarioRepository.findByUsername(username);
		
		List<GrantedAuthority> autorizacion = new ArrayList<GrantedAuthority>();
		
		for(Rol rol : usuario.getRoles()) {
			autorizacion.add(new SimpleGrantedAuthority(rol.getAutoridad()));
		}
		
		return new User(usuario.getUsername(), usuario.getPassword(), usuario.getPermitir(),
				true, true, true, autorizacion);
	}

	
}
