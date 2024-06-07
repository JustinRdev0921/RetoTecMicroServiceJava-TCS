package com.example.RTMicroServiceJava.service;

import com.example.RTMicroServiceJava.entity.Cuenta;
import com.example.RTMicroServiceJava.repository.CuentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CuentaService {
    @Autowired
    private CuentaRepository cuentaRepository;

    public List<Cuenta> getAllCuentas() {
        return cuentaRepository.findAll();
    }

    public Optional<Cuenta> getCuentaById(Long id) {
        return cuentaRepository.findById(id);
    }

    public Cuenta saveCuenta(Cuenta cuenta) {
        return cuentaRepository.save(cuenta);
    }

    public void deleteCuenta(Long id) {
        cuentaRepository.deleteById(id);
    }
}
