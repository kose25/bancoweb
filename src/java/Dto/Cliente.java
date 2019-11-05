
package Dto;

import java.time.LocalDate;

public class Cliente implements Comparable {
    
    private long cedula;
    private String  nombre;
    private LocalDate fechaNacimiento;
    private String dirCorrespondencia;
    private long telefono;
    private String email;
    

    public Cliente() {
    }

    public Cliente(long cedula, String nombre, LocalDate fechaNacimiento, String dirCorrespondencia, long telefono, String email) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.dirCorrespondencia = dirCorrespondencia;
        this.telefono = telefono;
        this.email = email;
    }   

    public Cliente(Long nroCedula) {
        cedula=nroCedula;
    }
    
    
    @Override
    public int compareTo(Object o) {
       Cliente x=(Cliente)o;
       
     return ((int)(this.cedula-x.cedula));
    }

    public long getCedula() {
        return cedula;
    }

    public void setCedula(long cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getDirCorrespondencia() {
        return dirCorrespondencia;
    }

    public void setDirCorrespondencia(String dirCorrespondencia) {
        this.dirCorrespondencia = dirCorrespondencia;
    }

    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Cliente{" + "cedula=" + cedula + ", nombre=" + nombre + ", fechaNacimiento=" + fechaNacimiento + ", dirCorrespondencia=" + dirCorrespondencia + ", telefono=" + telefono + ", email=" + email + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + (int) (this.cedula ^ (this.cedula >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cliente other = (Cliente) obj;
        if (this.cedula != other.cedula) {
            return false;
        }
        return true;
    }
    
    
    
    
    
}
