package com.example.RTMicroServiceJava.repository;

import com.example.RTMicroServiceJava.entity.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CuentaRepository extends JpaRepository<Cuenta, Long> {
}
