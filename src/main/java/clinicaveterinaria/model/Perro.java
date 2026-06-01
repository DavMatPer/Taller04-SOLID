package clinicaveterinaria.model;

import clinicaveterinaria.interfaces.ICaminador;
import clinicaveterinaria.interfaces.INadador;


public class Perro extends Animal implements ICaminador, INadador{
    public Perro(int id, String nombre) {
        super(id, nombre, TipoAnimal.PERRO);
    }

    @Override
    public void caminar() {
        System.out.println(getNombre() + " está caminando.");
    }
    
    @Override
    public void nadar() {
        System.out.println(getNombre() + " está nadando.");
    }
    
    /*
    Se elminó el método que perro no puede hacer: Volar
    */
}
