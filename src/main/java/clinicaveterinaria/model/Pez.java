package clinicaveterinaria.model;

import clinicaveterinaria.interfaces.INadador;


public class Pez extends Animal implements INadador{
    public Pez(int id, String nombre) {
        super(id, nombre, TipoAnimal.PEZ);
    }
    
    /*
    Agregar los métodos que el animal si puede hacer
    */
    @Override
    public void nadar() {
        System.out.println(getNombre() + " esta nadando.");
    }

    /*
    Se eliminaron los métodos que el animal no puede hacer
    */
}
