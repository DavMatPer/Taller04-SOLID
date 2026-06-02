package clinicaveterinaria.service;

import clinicaveterinaria.interfaces.IBaseDatos;
import clinicaveterinaria.model.Cita;
import java.util.List;

public class CitaService {
    private final IBaseDatos baseDatos;

    public CitaService(IBaseDatos baseDatos) {
        this.baseDatos = baseDatos;
    }

    public void crearCita(Cita cita) {
        baseDatos.getCitas().add(cita);
        baseDatos.registrarOperacion("crearCita");
    }

    public Cita obtenerCita(int id) {
        for (Cita cita : baseDatos.getCitas()) {
            if (cita.getId() == id) { return cita; }
        }
        return null;
    }

    public void actualizarCita(Cita cita) {
        eliminarCita(cita.getId());
        crearCita(cita);
    }

    public void eliminarCita(int id) {
        baseDatos.getCitas().removeIf(cita -> cita.getId() == id);
        baseDatos.registrarOperacion("eliminarCita");
    }

    public List<Cita> listarCitas() { return baseDatos.getCitas(); }
}