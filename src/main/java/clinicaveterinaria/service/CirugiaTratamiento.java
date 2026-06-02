package clinicaveterinaria.service;
import clinicaveterinaria.interfaces.ITratamiento;
import clinicaveterinaria.model.TipoTratamiento;
import clinicaveterinaria.model.Tratamiento;


public class CirugiaTratamiento extends Tratamiento implements ITratamiento {
    private final double costo;

    public CirugiaTratamiento(int id, String descripcion, double costo) {
        super(id, TipoTratamiento.CIRUGIA, descripcion, costo);
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
