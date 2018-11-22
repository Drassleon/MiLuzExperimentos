package com.marcelo.miluz.models.service.inter;

import java.util.List;

import com.marcelo.miluz.models.entity.Proveedor;

public interface IProveedorService extends IService<Proveedor> {
	public List<Proveedor> findByNombre(String term);
}
