package com.example.RTMicroServiceJava.service;

import com.example.RTMicroServiceJava.entity.Cuenta;
import com.example.RTMicroServiceJava.entity.Movimiento;
import com.example.RTMicroServiceJava.repository.CuentaRepository;
import com.example.RTMicroServiceJava.repository.MovimientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovimientoService {

    @Autowired
    private MovimientoRepository movimientoRepository;

    @Autowired
    private CuentaRepository cuentaRepository;

    public Movimiento saveMovimiento(Movimiento movimiento, Long cuentaId) throws Exception {
        Optional<Cuenta> cuentaOptional = cuentaRepository.findById(cuentaId);
        if (!cuentaOptional.isPresent()) {
            throw new Exception("Cuenta no encontrada");
        }

        Cuenta cuenta = cuentaOptional.get();
        double nuevoSaldo = cuenta.getSaldoInicial() + movimiento.getValor();
        if (nuevoSaldo < 0) {
            throw new Exception("Saldo no disponible");
        }

        cuenta.setSaldoInicial(nuevoSaldo);
        movimiento.setSaldo(nuevoSaldo);
        movimiento.setCuenta(cuenta);

        return movimientoRepository.save(movimiento);
    }
}
