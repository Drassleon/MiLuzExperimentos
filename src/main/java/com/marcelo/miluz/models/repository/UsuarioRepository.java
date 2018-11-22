package com.marcelo.miluz.models.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.marcelo.miluz.models.entity.Usuarios;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuarios, Long> {
	public Usuarios findByUsername(String nombre);
}