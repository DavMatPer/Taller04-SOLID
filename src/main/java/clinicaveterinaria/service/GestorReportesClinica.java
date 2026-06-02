package clinicaveterinaria.service;

import clinicaveterinaria.interfaces.IBaseDatos;


public class GestorReportesClinica {
    private final IBaseDatos baseDatos; // Abstracción

    public GestorReportesClinica(IBaseDatos baseDatos) {
        this.baseDatos = baseDatos; // Inyectado
    }

    public void imprimirResumenOperaciones() {
        // Asumiendo que añades getAuditoria() a IBaseDatos, o casteas si es estrictamente necesario
        // ...
    }
}
