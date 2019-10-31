/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dto;

import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author Carlos Jose
 */
public class Operacion {
    LocalDate fecha;
    double saldo;
    int identificador;
    
    private boolean consignacion;
    private boolean retiro;
    private boolean transferencia;

    public Operacion() {
    }

    public Operacion(LocalDate fecha, double saldo, int identificador) {
        this.fecha = fecha;
        this.saldo = saldo;
        this.identificador = identificador;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }
    
    
    
    
}
