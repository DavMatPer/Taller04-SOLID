package clinicaveterinaria.service;

import clinicaveterinaria.interfaces.IMascotaService;
import clinicaveterinaria.interfaces.ICitaService;    
import clinicaveterinaria.model.Cita;
import clinicaveterinaria.model.Mascota;
import clinicaveterinaria.model.Veterinario;

public class RecepcionService implements IMascotaService, ICitaService {

    private final IMascotaService mascotaService;
    private final ICitaService citaService;
    private final VeterinarioCrudService veterinarioCrudService;

    // Inyecta abstracciones puras
    public RecepcionService(IMascotaService mascotaService, ICitaService citaService, VeterinarioCrudService veterinarioCrudService) {
        this.mascotaService = mascotaService;
        this.citaService = citaService;
        this.veterinarioCrudService = veterinarioCrudService;
    }

    @Override
    public void crearMascota(Mascota mascota) {
        mascotaService.crearMascota(mascota);
    }

    @Override
    public Mascota obtenerMascota(int id) {
        return mascotaService.obtenerMascota(id);
    }

    @Override
    public void actualizarMascota(Mascota mascota) {
        mascotaService.actualizarMascota(mascota);
    }

    @Override
    public void eliminarMascota(int id) {
        mascotaService.eliminarMascota(id);
    }

    
    public void crearVeterinario(Veterinario veterinario) {
        veterinarioCrudService.crearVeterinario(veterinario);
    }

   
    public Veterinario obtenerVeterinario(int id) {
        return veterinarioCrudService.obtenerVeterinario(id);
    }

    // Citas queda fijo 
    @Override
    public void crearCita(Cita cita) {
        citaService.crearCita(cita);
    }

    @Override
    public Cita obtenerCita(int id) {
        return citaService.obtenerCita(id);
    }

    @Override
    public void cancelarCita(int id) {
        citaService.cancelarCita(id);
    }
}