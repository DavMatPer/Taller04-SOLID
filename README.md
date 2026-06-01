# ClinicaVeterinaria

Proyecto Java Maven para practicar refactoring con principios SOLID en un taller colaborativo.

El sistema funciona desde el inicio, pero contiene violaciones intencionales de SRP, OCP, LSP, ISP y DIP. La idea es que cada integrante refactorice una zona del código sin romper la ejecución.

## Setup en 5 minutos


Compilar con Maven. Salida esperada:

```text
=== ClinicaVeterinaria funcionando ===
```

## Estructura del proyecto

```text
src/main/java/clinicaveterinaria/
├── Main.java
├── interfaces/
│   ├── IAnimal.java
│   ├── IBaseDatos.java
│   ├── IServicioClinica.java
│   ├── ITratamiento.java
│   └── IVeterinarioService.java
├── model/
│   ├── Mascota.java
│   ├── Veterinario.java
│   ├── Cita.java
│   ├── Tratamiento.java
│   ├── Factura.java
│   └── clases auxiliares para animales y enums
├── repository/
│   ├── BaseDatos.java
│   └── DirectoBaseDatos.java
└── service/
    ├── ReservaService.java
    ├── DiagnosticoService.java
    ├── FacturacionService.java
    ├── ReporteService.java
    └── servicios CRUD y clases con violaciones intencionales
```

## Trabajo del taller

- Integrante 1: refactorizar SRP.
- Integrante 2: refactorizar OCP.
- Integrante 3: refactorizar LSP.
- Integrante 4: refactorizar ISP y DIP.

FERNANDO ZAMBRANO: 

Lo que primero hice, QUE ES LO DEL PASO 1:  eS que la interface ServiceClinica es hacerla o divirla en pequeñas interfaces: `IMascotaService`, `ICitaService`, `IFacturaService`, `IReporteService` 

en la otra parte del RecepcionService 
lo que se hizo fue quitar lo que npo se usaba y otra se agragaron en el impor, ejemplo: 
//agregado nueva interfaces
 // se elimino generarReporteCitasPorVeterinario 

   //se elimino generarReporteMascotasPorDueno 
//se elimino calcularIngresosMensual 
// se elimino crearFactura 
  // se elimino actualizarVeterinario 
//quitado y agragado  

En el paso 3: Se elimino la creacion directa de objetos con new dentro de cclinica y se inyectaron las dependencias mediante el constructor para que la clase dependa de interfaces y no de implementaciones concretas.
 y por ultimo en el paso 4 que corresponde al main:  cree la implementacipnes concretas DirectoVeterinario y DirectoBaseDatos) y se inyecto al constructor de clinica verificando que las clases funciones sin crear sus propias dependecias, cumpliendo con DIP 


Lee `guia.md` para instrucciones, checklists y preguntas de discusión.
