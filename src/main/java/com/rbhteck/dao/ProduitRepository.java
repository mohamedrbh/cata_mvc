package com.rbhteck.dao;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.rbhteck.entities.Produit;

//quand on utlise cette interface on aura toute les opération CRUD
public interface ProduitRepository extends JpaRepository<Produit, Long> {
	

public Page<Produit> findByDesignationContains(String mc, Pageable pageable);

//public Page<Produit> findByDesignationContains(String mc, PageRequest of);
}
