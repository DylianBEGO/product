package fr.dylian.deal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.dylian.deal.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{
	
}
