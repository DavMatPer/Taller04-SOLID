package clinicaveterinaria.service;

import clinicaveterinaria.interfaces.IMascotaService;
import clinicaveterinaria.interfaces.ICitaService;     //quitado y agragado 
import clinicaveterinaria.model.Cita;
import clinicaveterinaria.model.Factura;
import clinicaveterinaria.model.Mascota;
import clinicaveterinaria.model.Tratamiento;
import clinicaveterinaria.model.Veterinario;
import clinicaveterinaria.interfaces.ICitaService;
import clinicaveterinaria.interfaces.IVeterinarioService;

import java.util.List;


public class RecepcionService implements IMascotaService,ICitaService {

    private final ServicioClinicaCompleto servicioCompleto;

    public RecepcionService(ServicioClinicaCompleto servicioCompleto) {
        this.servicioCompleto = servicioCompleto;
    }

    // Mascotasqeuda fijop
    @Override
    public void crearMascota(Mascota mascota) {
        servicioCompleto.crearMascota(mascota);
    }

    @Override
    public Mascota obtenerMascota(int id) {
        return servicioCompleto.obtenerMascota(id);
    }

    @Override
    public void actualizarMascota(Mascota mascota) {
        servicioCompleto.actualizarMascota(mascota);
    }

    @Override
    public void eliminarMascota(int id) {
        servicioCompleto.eliminarMascota(id);
    }

    
    public void crearVeterinario(Veterinario veterinario) {
        servicioCompleto.crearVeterinario(veterinario);
    }

   
    public Veterinario obtenerVeterinario(int id) {
        return servicioCompleto.obtenerVeterinario(id);
    }

    // Citas queda fijo 
    @Override
    public void crearCita(Cita cita) {
        servicioCompleto.crearCita(cita);
    }

    @Override
    public Cita obtenerCita(int id) {
        return servicioCompleto.obtenerCita(id);
    }

    @Override
    public void cancelarCita(int id) {
        servicioCompleto.cancelarCita(id);
    }
}