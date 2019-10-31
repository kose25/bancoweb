
package Dto;

public class CuentaCorriente extends Cuenta{

   private double sobregiro=1000000; 
    
    public CuentaCorriente() {
        super();
    }

    public double getSobregiro() {
        return sobregiro;
    }

    public void setSobregiro(double sobregiro) {
        this.sobregiro = sobregiro;
    }
    
}
