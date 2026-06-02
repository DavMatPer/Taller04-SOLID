package clinicaveterinaria.service;

import clinicaveterinaria.interfaces.IBaseDatos;
import clinicaveterinaria.model.Cita;
import clinicaveterinaria.model.EstadoCita;
import clinicaveterinaria.model.Mascota;
import clinicaveterinaria.model.Veterinario;
import java.time.LocalDate;

public class ReservaService {
    private final IBaseDatos baseDatos;

    public ReservaService(IBaseDatos baseDatos) {
        this.baseDatos = baseDatos;
    }

    public Cita reservarCita(int id, Mascota mascota, Veterinario veterinario, LocalDate fecha) {
        Cita cita = new Cita(id, mascota, veterinario, fecha, "Pendiente", EstadoCita.PROGRAMADA);
        baseDatos.getCitas().add(cita);
        veterinario.setDisponible(false);
        return cita;
    }
}