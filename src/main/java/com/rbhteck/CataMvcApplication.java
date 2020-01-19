package com.rbhteck;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.rbhteck.dao.ProduitRepository;
import com.rbhteck.entities.Produit;

@SpringBootApplication
public class CataMvcApplication implements CommandLineRunner {
	//pour faire l'injection du dépendance
	@Autowired
	private ProduitRepository produitRepository;
	public static void main(String[] args) {
		SpringApplication.run(CataMvcApplication.class, args);
	}

	// Pour cette Interface on execute la méthode run aprés le démarage de Spring
	@Override
	public void run(String... args) throws Exception {
//		produitRepository.save(new Produit("PC 5636", 6000, 12));
//		produitRepository.save(new Produit("Imprimante HP 1234", 1200, 10));
//		produitRepository.save(new Produit("PC Compacq", 9000, 1));
//		produitRepository.save(new Produit("Scanner", 1000, 16));
		produitRepository.findAll().forEach(p->{System.out.println(p.getDesignation());});
	}

}
