package com.example.project.catalog;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;




@Repository
public interface CatalogRepository extends JpaRepository<Catalog, Integer>{
}
