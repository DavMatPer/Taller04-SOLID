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

Lee `guia.md` para instrucciones, checklists y preguntas de discusión.

## DISCUSION

###  1. PABLO OJEDA

Se eliminaron los siguiente metodos de la clase Veterinario:

- reservarCita() - Logica a ReservaService
- diagnosticar() -  Logica a DiagnosticoService
- crearReporte() - Logica a ReporteService

### 3. DAVID MATOS

Existía una violacion del principio LSP entre las clases Animal y sus hijos. Animal implementaba una interfaz que tenia todos las acciones: volar, nadar, caminar. Pero esta implementación decía que cualquier anial puede hacerlo todo, pero existen animales que no pueden hacer ciertas acciones. Esto hacía que no se pudiera sustituir el padre por el hijo con total seguridad.

Para resolverlo hicimos:

- Dividimos la interfaz IAnimal en tres interfaces: INadador, ICaminador e IVolador. Y eliminamso la interfaz IAnimal.
- La clase Animal ya no implementaba la interfaz y eliminamos los métodos de acción. Con eso decimos que cualquier animal puede hacerlo todo, solo sabíamos lo general de cada animal.
- Ahora hicimos que cada hijo de animal implementara las inerfaces que eran acordes con sus acciones naturales y eliminamos las acciones imposibles.
- Cambiamos en el método `demostrarViolacionesSinRomperEjecucion` el tipo de una variable pez que era Animal por el tipo Nadador. 

Ahora con este cambio las clases hijas e pueden sustituir por el padre sin miedo de que exista un error o acción antinatural.