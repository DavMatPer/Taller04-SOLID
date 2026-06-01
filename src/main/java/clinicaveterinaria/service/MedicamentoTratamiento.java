package clinicaveterinaria.service;
import clinicaveterinaria.interfaces.ITratamiento;


public class MedicamentoTratamiento implements ITratamiento{
    private final double costo;

    public MedicamentoTratamiento(double costo) {
        this.costo = costo;
    }

    @Override
    public double CostoFinal() {
        return costo * 1.10;
    }

    @Override
    public String Indicaciones() {
        return "Administrar segun receta.";   
    }
    
    @Override
    public String Sala(){
        return "Preparar receta y dosis.";
    }
    
    @Override
    public double ConImpuestos(){
        return CostoFinal() * 1.08;
    }  
}
