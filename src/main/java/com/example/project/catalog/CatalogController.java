package com.example.project.catalog;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/catalog")
public class CatalogController {

	private CatalogService catalogservice;
	
	
	@Autowired
	public CatalogController(CatalogService catalogservice) {
		super();
		this.catalogservice = catalogservice;
	}
	
	@GetMapping("/getcatalog")
	public List<Catalog> getAllCatalogmodel(){
		return catalogservice.getAllCatalog();
		
	}
	
	@PostMapping("/insercatalog")
	public List<Catalog> createCatalogmodel(@RequestBody List<Catalog> catmodel)
	{
		return catalogservice.createCatalog(catmodel);

	}
	//getting particular user	
	@GetMapping("/getusercatalog/{userid}")
	public Catalog getCatalogmodelById(@PathVariable Integer userid)
	{
		return catalogservice.getCatalogmodelByUserId(userid);

	}
	
	@PutMapping("/{userid}")
	public Catalog updateCatalogmodel(@PathVariable Integer userid, @RequestBody Catalog catmodel)
	{
		return catalogservice.updateCatalog(userid,catmodel);
	}
	
	@DeleteMapping("/{userid}")
	public void deletePlan(@PathVariable Integer userid)
	{
		catalogservice.deleteCatalog(userid);
		
	}
	
}



