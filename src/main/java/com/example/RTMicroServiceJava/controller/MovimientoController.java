package com.example.RTMicroServiceJava.controller;

import com.example.RTMicroServiceJava.DTO.MovimientoDTO;
import com.example.RTMicroServiceJava.entity.Movimiento;
import com.example.RTMicroServiceJava.service.MovimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/movimientos")
public class MovimientoController {

    @Autowired
    private MovimientoService movimientoService;

    @PostMapping
    public ResponseEntity<?> createMovimiento(@RequestBody MovimientoDTO movimientoDTO) {
        try {
            Movimiento movimiento = new Movimiento();
            movimiento.setFecha(movimientoDTO.getFecha());
            movimiento.setTipoMovimiento(movimientoDTO.getTipoMovimiento());
            movimiento.setValor(movimientoDTO.getValor());

            Movimiento createdMovimiento = movimientoService.saveMovimiento(movimiento, movimientoDTO.getCuentaId());
            return ResponseEntity.ok(createdMovimiento);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
