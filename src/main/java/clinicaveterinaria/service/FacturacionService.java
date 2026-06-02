package clinicaveterinaria.service;

import clinicaveterinaria.interfaces.IBaseDatos;
import clinicaveterinaria.model.Cita;
import clinicaveterinaria.model.Factura;
import java.time.LocalDate;

public class FacturacionService {
    private final IBaseDatos baseDatos;

    public FacturacionService(IBaseDatos baseDatos) {
        this.baseDatos = baseDatos;
    }

    public Factura generarFactura(int id, Cita cita, double monto) {
        Factura factura = new Factura(id, cita, monto, LocalDate.now(), false);
        baseDatos.getFacturas().add(factura);
        return factura;
    }
}