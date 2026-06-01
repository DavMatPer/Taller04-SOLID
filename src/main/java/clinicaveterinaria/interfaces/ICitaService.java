package clinicaveterinaria.interfaces;

import clinicaveterinaria.model.Cita;
public interface IcitaService {
     void crearCita(Cita cita);
     Cita obtenerCita(int id);
     void cancelarCita(int id);
}