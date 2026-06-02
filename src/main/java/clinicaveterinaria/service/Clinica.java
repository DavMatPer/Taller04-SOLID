package clinicaveterinaria.service;

import clinicaveterinaria.interfaces.IBaseDatos;
import clinicaveterinaria.interfaces.IVeterinarioService;
import clinicaveterinaria.model.Cita;
import clinicaveterinaria.model.Mascota;
import clinicaveterinaria.model.Veterinario;
import java.time.LocalDate;

public class Clinica {

    private final IVeterinarioService veterinarioService;
    private final IBaseDatos baseDatos; // Ahora depende de la interfaz

    public Clinica(IVeterinarioService veterinarioService, IBaseDatos baseDatos) {
        this.veterinarioService = veterinarioService;
        this.baseDatos = baseDatos;
    }

    public Cita agendarConsultaRapida(Mascota mascota, Veterinario veterinario) {
        // Se eliminó el baseDatos.conectar() porque no es parte del contrato y rompe el DIP
        Cita cita = veterinarioService.reservarCita(mascota, veterinario, LocalDate.now());
        baseDatos.getCitas().add(cita);
        return cita;
    }
}