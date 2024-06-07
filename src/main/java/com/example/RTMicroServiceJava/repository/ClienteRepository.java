package com.example.RTMicroServiceJava.repository;

import com.example.RTMicroServiceJava.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository  extends JpaRepository<Cliente, Long> { }
