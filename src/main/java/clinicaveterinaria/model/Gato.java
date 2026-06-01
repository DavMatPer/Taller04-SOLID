package clinicaveterinaria.model;

import clinicaveterinaria.interfaces.ICaminador;


public class Gato extends Animal implements ICaminador {
    public Gato(int id, String nombre) {
        super(id, nombre, TipoAnimal.GATO);
    }

    @Override
    public void caminar() {
        System.out.println(getNombre() + " está caminando.");
    }
    
    /*
    Se eliminaron los métodos que no puede hacer gato: Nadar y Volar.
    */
}
