package clinicaveterinaria.interfaces;

import clinicaveterinaria.model.Reporte;
public interface IReporteService {
List<Cita> generarReporteCitasPorVeterinario(int veterinarioId);

    List<Mascota> generarReporteMascotasPorDueno(String duenoNombre);

    double calcularIngresosMensual();
}