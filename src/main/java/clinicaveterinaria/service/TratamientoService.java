package clinicaveterinaria.service;

import clinicaveterinaria.interfaces.IBaseDatos;
import clinicaveterinaria.interfaces.ITratamiento;
import clinicaveterinaria.model.Tratamiento;
import java.util.List;

public class TratamientoService {
    private final IBaseDatos baseDatos;

    public TratamientoService(IBaseDatos baseDatos) {
        this.baseDatos = baseDatos;
    }

    public void crearTratamiento(Tratamiento tratamiento) {
        baseDatos.getTratamientos().add(tratamiento);
        baseDatos.registrarOperacion("crearTratamiento");
    }

    public Tratamiento obtenerTratamiento(int id) {
        for (Tratamiento tratamiento : baseDatos.getTratamientos()) {
            if (tratamiento.getId() == id) { return tratamiento; }
        }
        return null;
    }

    public void actualizarTratamiento(Tratamiento tratamiento) {
        eliminarTratamiento(tratamiento.getId());
        crearTratamiento(tratamiento);
    }

    public void eliminarTratamiento(int id) {
        baseDatos.getTratamientos().removeIf(tratamiento -> tratamiento.getId() == id);
        baseDatos.registrarOperacion("eliminarTratamiento");
    }

    public String prepararSala(ITratamiento sal) {
        return sal.Sala();
    }

    public List<Tratamiento> listarTratamientos() { return baseDatos.getTratamientos(); }
}