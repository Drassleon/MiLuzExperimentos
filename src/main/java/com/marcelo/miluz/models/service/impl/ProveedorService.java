package com.marcelo.miluz.models.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcelo.miluz.models.entity.Proveedor;
import com.marcelo.miluz.models.repository.ProveedorRepository;
import com.marcelo.miluz.models.service.inter.IProveedorService;

@Service
public class ProveedorService implements IProveedorService {

	@Autowired
	private ProveedorRepository proveedorRepository;
	
	@Override
	public void save(Proveedor proveedor) {
		proveedorRepository.save(proveedor);
	}

	@Override
	public Proveedor findById(Long id) {
		return proveedorRepository.findById(id).orElse(null);
	}

	@Override
	public void deleteById(Long id) {
		proveedorRepository.deleteById(id);
	}

	@Override
	public List<Proveedor> findAll() {
		return (List<Proveedor>)proveedorRepository.findAll();
	}

	@Override
	public List<Proveedor> findByNombre(String term) {
		return proveedorRepository.findByNombre(term);
	}

}
