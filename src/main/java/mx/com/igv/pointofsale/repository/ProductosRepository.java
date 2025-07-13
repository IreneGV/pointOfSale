package mx.com.igv.pointofsale.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.com.igv.pointofsale.entity.ProductosEntity;

public interface ProductosRepository extends JpaRepository<ProductosEntity, Integer>{
	
}
