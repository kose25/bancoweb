package Negocio;

import Dto.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class Banco {

    Long identificador = 1L;
    TreeSet<Cliente> clientes = new TreeSet();
    TreeSet<Cuenta> cuentas = new TreeSet();
    List<Operacion> operaciones = new ArrayList<>();

    public Banco() {
    }

    public boolean insertarCliente(long cedula, String nombre, String dir, String fecha, String email, long telefono) {
        Cliente nuevo = new Cliente();
        nuevo.setCedula(cedula);
        nuevo.setNombre(nombre);
        nuevo.setFechaNacimiento(crearFecha(fecha));
        nuevo.setDirCorrespondencia(dir);
        nuevo.setTelefono(telefono);
        nuevo.setEmail(email);
        //iría al dao , pero sólo por hoy en dinamic_memory
        return this.clientes.add(nuevo);
    }

    public boolean insertarCuenta(long nroCuenta, long cedula, boolean tipo) {
        Cliente x = new Cliente();
        x.setCedula(cedula);
        x = buscarCliente(x);
        if (x == null) {
            return false;
        }
        Cuenta nueva = tipo ? new CuentaAhorro() : new CuentaCorriente();
        nueva.setCliente(x);
        nueva.setNroCuenta(nroCuenta);
        nueva.setFechaCreacion(LocalDate.now());
        return this.cuentas.add(nueva);
    }

    public boolean realizarConsignacion(double saldo, Long nroCuenta) {
        Cuenta cuenta = findCuentaByNroCuenta(nroCuenta);
        if (cuenta != null) {
            Consignacion consignacion = new Consignacion();
            consignacion.setFecha(LocalDate.now());
            consignacion.setIdentificador(identificador.intValue());
            consignacion.setSaldo(saldo);
            identificador++;
            cuenta.setSaldo(cuenta.getSaldo() + saldo);
            return operaciones.add(consignacion);
        }
        return false;
    }

    public boolean realizarRetiro(double saldo, Long nroCuenta) {
        Cuenta cuenta = findCuentaByNroCuenta(nroCuenta);
        if (cuenta != null) {
            Retiro retiro = new Retiro();
            retiro.setFecha(LocalDate.now());
            retiro.setIdentificador(identificador.intValue());
            retiro.setSaldo(saldo);
            identificador++;
            if (cuenta.getSaldo() >= saldo) {
                cuenta.setSaldo(cuenta.getSaldo() - saldo);
                return operaciones.add(retiro);
            }

        }
        return false;
    }

    public boolean realizarTransferencia(double saldo, Long nroCuentaEnviar, Long nroCuentaRecibir) {

        Cuenta cuenta = findCuentaByNroCuenta(nroCuentaEnviar);
        Cuenta cuentab = findCuentaByNroCuenta(nroCuentaRecibir);
        if (cuenta != null && cuentab != null) {
            Transferencia transferencia = new Transferencia();
            transferencia.setFecha(LocalDate.now());
            transferencia.setIdentificador(identificador.intValue());
            transferencia.setSaldo(saldo);
            identificador++;
            if (cuenta.getSaldo() >= saldo) {
                cuenta.setSaldo(cuenta.getSaldo() - saldo);
                cuentab.setSaldo(cuentab.getSaldo() + saldo);
                return operaciones.add(transferencia);
            }
        }
        return false;
    }

    public Cuenta findCuentaByNroCuenta(Long nroCuenta) {
        Cuenta c = new Cuenta(nroCuenta);
        if (cuentas.contains(c)) {
            return cuentas.floor(c);
        }
        return null;
    }

    public Cliente findClienteByNroCedula(Long nroCedula) {
        Cliente cli = new Cliente(nroCedula);
        if (clientes.contains(cli)) {
            return clientes.floor(cli);
        }
        return null;
    }

    
    
    public ArrayList findCuentaByNroCedula(Long nroCedula) {
        ArrayList<Cuenta> resultado = new ArrayList<Cuenta>();
        Cliente cli = findClienteByNroCedula(nroCedula);
        for (Cuenta c : cuentas) {
            if (c.getCliente().equals(cli)) {
                resultado.add(c);
            }
        }
        return resultado;
    }

    private Cliente buscarCliente(Cliente x) {
        if (this.clientes.contains(x)) {
            return this.clientes.floor(x);
        }
        return null;
    }

    private Cliente buscarCliente2(Cliente x) {
        for (Cliente y : this.clientes) {
            if (y.equals(x)) {
                return y;
            }
        }
        return null;
    }

    private LocalDate crearFecha(String fecha) {
        String fechas[] = fecha.split("-");
        int agno = Integer.parseInt(fechas[0]);
        int mes = Integer.parseInt(fechas[1]);
        int dia = Integer.parseInt(fechas[2]);
        return LocalDate.of(agno, mes, dia);
    }

    public TreeSet<Cliente> getClientes() {
        return clientes;
    }

    public TreeSet<Cuenta> getCuentas() {
        return cuentas;
    }

}
