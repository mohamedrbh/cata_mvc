package com.rbhteck.web;

import java.awt.print.Pageable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.rbhteck.dao.ProduitRepository;
import com.rbhteck.entities.Produit;

@Controller
public class ProduitContoller {
	@Autowired
	private ProduitRepository produitRepository;
	
//	@RequestMapping(value = "/index", method = RequestMethod.GET)
//	@GetMapping("/index")
//	public String chercher(Model model, @RequestParam(name="page", defaultValue="0") int page) {
//		//List<Produit> produits = produitRepository.findAll();
//		Page<Produit> pageProduits = produitRepository.findAll(PageRequest.of(page,5));
//		model.addAttribute("listProduit", pageProduits.getContent());
//		model.addAttribute("pages",new int[pageProduits.getTotalPages()]);
//		model.addAttribute("currentPage", page);
//		model.addAttribute("maxPages", pageProduits.getTotalPages()-1);
//		return "produits";
//	}
	
	@GetMapping("/index")
	public String chercher(Model model, @RequestParam(name="page", defaultValue="0") int page,
			@RequestParam(name="motCle", defaultValue="") String mc) {
		//List<Produit> produits = produitRepository.findAll();
		Page<Produit> pageProduits = produitRepository.findByDesignationContains(mc, PageRequest.of(page,5));
		model.addAttribute("listProduit", pageProduits.getContent());
		model.addAttribute("pages",new int[pageProduits.getTotalPages()]);
		model.addAttribute("currentPage", page);
		model.addAttribute("maxPages", pageProduits.getTotalPages()-1);
		model.addAttribute("motCle", mc);
		return "produits";
	}
	
	@GetMapping("/delete")
	public String delete(Long id, int page, String motCle) {
		produitRepository.deleteById(id);
		return "redirect:/index?page="+page+"&motCle="+motCle;
	}
	
}
