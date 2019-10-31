
package Dto;

import java.time.LocalDate;

public class Cuenta implements Comparable{
    
    private long nroCuenta;
    private Cliente cliente;
    private double saldo;
    private LocalDate fechaCreacion;

    public Cuenta() {
    }

    public Cuenta(Long numeroCuenta){
        nroCuenta = numeroCuenta;
    }
    
    public long getNroCuenta() {
            return nroCuenta;
    }

    public void setNroCuenta(long nroCuenta) {
        this.nroCuenta = nroCuenta;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    @Override
    public int compareTo(Object o) {
      Cuenta cuenta=(Cuenta)o;
      return (int)(this.nroCuenta-cuenta.nroCuenta);
    }

    @Override
    public String toString() {
        return "Cuenta{" + "nroCuenta=" + nroCuenta + ", cliente=" + cliente.getCedula() + ", saldo=" + saldo + ", fechaCreacion=" + fechaCreacion + '}';
    }
    
    
    
    
}
