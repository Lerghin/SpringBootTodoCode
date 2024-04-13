package com.tocode.trabajoFinalSpringBoot.repository;

import com.tocode.trabajoFinalSpringBoot.model.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IVentaRepository extends JpaRepository<Venta, Long> {
}
