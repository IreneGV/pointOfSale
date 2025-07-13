package mx.com.igv.pointofsale.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.com.igv.pointofsale.entity.InventariosEntity;
import mx.com.igv.pointofsale.entity.ProductosEntity;

public interface InventariosRepository extends JpaRepository<InventariosEntity, Integer>{
	
	public List<InventariosEntity> findByProductos(ProductosEntity productos);
}