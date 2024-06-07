package com.example.RTMicroServiceJava.entity;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
public class Movimiento {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Date fecha;
    private String tipoMovimiento;
    private Double valor;
    private Double saldo;

    @ManyToOne
    @JoinColumn(name = "cuenta_id")
    private Cuenta cuenta;

    public Movimiento() {
    }

    public Movimiento(Long id, Date fecha, String tipoMovimiento, Double valor, Double saldo, Cuenta cuenta) {
        this.id = id;
        this.fecha = fecha;
        this.tipoMovimiento = tipoMovimiento;
        this.valor = valor;
        this.saldo = saldo;
        this.cuenta = cuenta;
    }

    public Movimiento(Date fecha, String tipoMovimiento, Double valor, Double saldo, Cuenta cuenta) {
        this.fecha = fecha;
        this.tipoMovimiento = tipoMovimiento;
        this.valor = valor;
        this.saldo = saldo;
        this.cuenta = cuenta;
    }

    // Getters y setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getTipoMovimiento() {
        return tipoMovimiento;
    }

    public void setTipoMovimiento(String tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }
}
