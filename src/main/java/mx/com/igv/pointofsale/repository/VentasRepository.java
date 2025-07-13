package mx.com.igv.pointofsale.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.com.igv.pointofsale.entity.VentasEntity;

public interface VentasRepository extends JpaRepository<VentasEntity, Integer>{
	
	public List<VentasEntity> findByFechaHoraBetween(LocalDateTime fechaInicio, LocalDateTime fechaFin);
}