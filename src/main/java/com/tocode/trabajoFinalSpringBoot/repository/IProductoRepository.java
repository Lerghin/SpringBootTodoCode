package com.tocode.trabajoFinalSpringBoot.repository;

import com.tocode.trabajoFinalSpringBoot.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductoRepository  extends JpaRepository<Producto, Long> {
}
