package clinicaveterinaria.model;
import clinicaveterinaria.interfaces.IVolador;
import clinicaveterinaria.interfaces.ICaminador;

public class Pajaro extends Animal implements ICaminador, IVolador{
    public Pajaro(int id, String nombre) {
        super(id, nombre, TipoAnimal.PAJARO);
    }

    @Override
    public void volar() {
        System.out.println(getNombre()+ " está volando.");
    }
    
    @Override
    public void caminar() {
        System.out.println(getNombre()+ " está caminando.");
    }
    /*
    Se eliminó el método nadar que pájaro no puede hacer
    */
}
