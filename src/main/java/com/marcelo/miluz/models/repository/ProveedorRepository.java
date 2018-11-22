package com.marcelo.miluz.models.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.marcelo.miluz.models.entity.Proveedor;

@Repository
public interface ProveedorRepository extends JpaRepository<Proveedor, Long> {
	@Query("select p from Proveedor p where p.nombre like %?1%")
	public List<Proveedor> findByNombre(String term);
}
