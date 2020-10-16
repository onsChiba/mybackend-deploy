package com.hellokoding.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hellokoding.auth.model.PoissonFavoris;
import com.hellokoding.auth.model.User;

public interface PoissonRepos extends  JpaRepository<PoissonFavoris, Long>{
	public PoissonFavoris findById(long id);
	public PoissonFavoris findByName(String name);
}
