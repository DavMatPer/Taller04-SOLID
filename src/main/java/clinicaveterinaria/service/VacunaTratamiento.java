package clinicaveterinaria.service;
import clinicaveterinaria.interfaces.ITratamiento;

public class VacunaTratamiento implements ITratamiento {
    private final double costo;

    public VacunaTratamiento(double costo) {
        this.costo = costo;
    }

    @Override
    public double CostoFinal() {
        return costo + 5.0;
    }

    @Override
    public String Indicaciones() {
        return "Observar fiebre durante 24 horas.";   
    }
    
    @Override
    public String Sala(){
        return "Preparar refrigeracion y jeringas.";
    }
    
    @Override
    public double ConImpuestos(){
        return CostoFinal() * 1.12;
    }
}       
