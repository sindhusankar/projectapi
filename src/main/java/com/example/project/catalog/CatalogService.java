package com.example.project.catalog;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




@Service
public class CatalogService {
  private final CatalogRepository catalogrepository;
	
	
	@Autowired
	public CatalogService(CatalogRepository catalogrepository) {

		this.catalogrepository = catalogrepository;
	}
	
		
	public List<Catalog> getAllCatalog(){
		return catalogrepository.findAll();
	}
	
	public List<Catalog> createCatalog(List<Catalog> catalog) {
		
		return catalogrepository.saveAll(catalog);
		
	}
	
	public Catalog getCatalogmodelByUserId (Integer userid) {
		return catalogrepository.findById(userid).orElse((null));
	}
	
	
	public Catalog updateCatalog(Integer userid,Catalog catalog) {
		Catalog existingCatalog = catalogrepository.findById(userid).orElse(null);
		if (existingCatalog != null) {
			existingCatalog.setName(catalog.getName());
			existingCatalog.setDescription(catalog.getDescription());
			existingCatalog.setPrice(catalog.getPrice());
			return catalogrepository.save(existingCatalog);
			
		}
		return null;
	}
	
	public void deleteCatalog(Integer id)
	{
		catalogrepository.deleteById(id);
	}
	


	
}


