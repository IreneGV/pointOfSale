package mx.com.igv.pointofsale.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.com.igv.pointofsale.entity.ProveedoresEntity;

public interface ProveedoresRepository extends JpaRepository<ProveedoresEntity, Integer>{
	
}