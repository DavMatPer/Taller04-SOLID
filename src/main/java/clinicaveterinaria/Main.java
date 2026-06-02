package clinicaveterinaria;

import clinicaveterinaria.interfaces.INadador;
import clinicaveterinaria.model.*;
import clinicaveterinaria.repository.*;
import clinicaveterinaria.service.*;
import clinicaveterinaria.interfaces.ITratamiento;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        BaseDatos baseDatos = new BaseDatos();
        MascotaService mascotaService = new MascotaService(baseDatos);
        VeterinarioCrudService veterinarioCrudService = new VeterinarioCrudService(baseDatos);
        ReservaService reservaService = new ReservaService(baseDatos);
        DiagnosticoService diagnosticoService = new DiagnosticoService();
        FacturacionService facturacionService = new FacturacionService(baseDatos);
        TratamientoService tratamientoService = new TratamientoService(baseDatos);
        ReporteService reporteService = new ReporteService(baseDatos);

        Mascota mascota = new Mascota(1, "Luna", TipoAnimal.PERRO, 4, "Ana Perez");
        Veterinario veterinario = new Veterinario(1, "Dr. Ruiz", "Medicina general", true);
        
        // Mantenemos el tratamiento original para no romper la base de datos antigua
        Tratamiento tratamiento = new Tratamiento(1, TipoTratamiento.CIRUGIA, "Esterilizacion", 120.0);
        
        // --- SOLUCIÓN ERROR 1: Creamos el tratamiento bajo el contrato correcto (OCP) ---
        CirugiaTratamiento cirugia = new CirugiaTratamiento(1, "Esterilizacion", 120.0); 

        mascotaService.crearMascota(mascota);
        veterinarioCrudService.crearVeterinario(veterinario);
        tratamientoService.crearTratamiento(tratamiento);

        Cita cita = reservaService.reservarCita(1, mascota, veterinario, LocalDate.now());
        diagnosticoService.diagnosticar(cita, "Paciente estable para tratamiento.");
        
        // Usamos la implementación cirugia para calcular el costo real de forma segura
        Factura factura = facturacionService.generarFactura(1, cita, cirugia.CostoFinal());
        factura.setPagada(true);

        System.out.println("=== ClinicaVeterinaria funcionando ===");
        System.out.println(mascotaService.obtenerMascota(1));
        System.out.println(cita);
        System.out.println(factura);
        
        // --- SOLUCIÓN ERROR 1: Usamos la interfaz directamente y eliminamos el (ITratamiento) ---
        System.out.println("Preparacion: " + tratamientoService.prepararSala(cirugia));
        System.out.println("Costo con impuestos: " + new CalculadoraCostoTratamiento().calcularConImpuestos(cirugia));
        
        System.out.println("Citas Dr. Ruiz: " + reporteService.generarReporteCitasPorVeterinario(1).size());
        System.out.println("Mascotas de Ana Perez: " + reporteService.generarReporteMascotasPorDueno("Ana Perez").size());
        System.out.println("Ingresos del mes: " + reporteService.calcularIngresosMensual());

        demostrarViolacionesSinRomperEjecucion(veterinario, mascota, tratamiento, reservaService, diagnosticoService, reporteService);
        DirectoVeterinario veterinarioService = new DirectoVeterinario();
        DirectoBaseDatos baseDatosDirecta = new DirectoBaseDatos();
        Clinica clinica = new Clinica(veterinarioService, baseDatosDirecta);
        clinica.agendarConsultaRapida(mascota, veterinario);
        
        // Se mantiene igual para no afectar tu firma actual de calcularTratamiento
        new ServicioClinicaCompleto(baseDatos).calcularTratamiento(cirugia);
    }

    private static void demostrarViolacionesSinRomperEjecucion(Veterinario veterinario, Mascota mascota, Tratamiento tratamiento, ReservaService reservaService, DiagnosticoService diagnosticoService, ReporteService reporteService) {
        // AHORA implementa el metodo desde ReservaService
        Cita citaDesdeModelo = reservaService.reservarCita(2, mascota, veterinario, LocalDate.now().plusDays(1));
        // AHORA implementa el metodo desde DiagnosticoService
        diagnosticoService.diagnosticar(citaDesdeModelo, "Ejemplo de SRP violado desde el modelo.");
        // AHORA implementa el metodo desde ReporteService
        System.out.println(reporteService.crearReporte(citaDesdeModelo, veterinario));

        INadador pez = new Pez(3, "Nemo");
        pez.nadar();
        System.out.println("El pez heredó caminar() y volar(), aunque no debe usarlos.");
        System.out.println("Tratamiento OCP violado pero funcional: " + tratamiento.obtenerIndicaciones(new CirugiaTratamiento(1, "Esterilizacion", 120.0)));
    }
}