package com.tocode.trabajoFinalSpringBoot.repository;

import com.tocode.trabajoFinalSpringBoot.model.Cliente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClienteRepository extends JpaRepository<Cliente, Long> {
}
