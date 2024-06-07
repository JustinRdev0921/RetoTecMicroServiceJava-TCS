package com.example.RTMicroServiceJava.controller;

import com.example.RTMicroServiceJava.entity.Cuenta;
import com.example.RTMicroServiceJava.service.CuentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cuentas")
public class CuentaController {
    @Autowired
    private CuentaService cuentaService;

    @GetMapping
    public List<Cuenta> getAllCuentas() {
        return cuentaService.getAllCuentas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cuenta> getCuentaById(@PathVariable Long id) {
        Optional<Cuenta> cuenta = cuentaService.getCuentaById(id);
        return cuenta.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Cuenta createCuenta(@RequestBody Cuenta cuenta) {
        return cuentaService.saveCuenta(cuenta);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateCuenta(@PathVariable Long id, @RequestBody Cuenta cuentaDetails) {
        Optional<Cuenta> cuenta = cuentaService.getCuentaById(id);
        if (cuenta.isPresent()) {
            Cuenta cuentaToUpdate = cuenta.get();
            cuentaToUpdate.setNumeroCuenta(cuentaDetails.getNumeroCuenta());
            cuentaToUpdate.setTipoCuenta(cuentaDetails.getTipoCuenta());
            cuentaToUpdate.setSaldoInicial(cuentaDetails.getSaldoInicial());
            cuentaToUpdate.setEstado(cuentaDetails.getEstado());
            cuentaService.saveCuenta(cuentaToUpdate);
            return ResponseEntity.ok("Cuenta actualizada con éxito");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCuenta(@PathVariable Long id) {
        cuentaService.deleteCuenta(id);
        return ResponseEntity.ok("Cuenta eliminada con éxito");
    }
}
