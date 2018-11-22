package com.marcelo.miluz.models.service.inter;

import java.util.List;

public interface IService<T> {
	void save(T t);
	T findById(Long id);
	void deleteById(Long id);
	List<T> findAll();
}
