package clinicaveterinaria.service;

import clinicaveterinaria.interfaces.ITratamiento;


public class CalculadoraCostoTratamiento {
    public double calcularConImpuestos(ITratamiento calcImp) {
        return calcImp.ConImpuestos();
    }
}
