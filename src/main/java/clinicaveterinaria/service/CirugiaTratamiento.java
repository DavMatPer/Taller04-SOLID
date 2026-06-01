package clinicaveterinaria.service;
import clinicaveterinaria.interfaces.ITratamiento;


public class CirugiaTratamiento implements ITratamiento {
    private final double costo;

    public CirugiaTratamiento(double costo) {
        this.costo = costo;
    }

    @Override
    public double CostoFinal() {
        return costo * 1.25 + 80.0;
    }

    @Override
    public String Indicaciones() {
        return "Ayuno previo y control postoperatorio.";   
    }
    
    @Override
    public String Sala(){
        return "Preparar quirofano y anestesia.";
    }
    
    @Override
    public double ConImpuestos(){
        return CostoFinal() * 1.35;
    }
}
