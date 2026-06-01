package clinicaveterinaria.service;
import clinicaveterinaria.interfaces.ITratamiento;


public class FisioterapiaTratamiento implements ITratamiento {
    private final double costo;

    public FisioterapiaTratamiento(double costo) {
        this.costo = costo;
    }

    @Override
    public double CostoFinal() {
        return costo * 0.95;
    }

    @Override
    public String Indicaciones() {
        return "Repetir sesiones dos veces por semana.";   
    }
    
    @Override
    public String Sala(){
        return "Preparar camilla y bandas elasticas.";
    }
    
    @Override
    public double ConImpuestos(){
        return CostoFinal() * 1.05;
    }  
}
