
package cr.ac.ufidelitas.proyectoed.victorleitonjimenez_pp3;


public class CantidadDeNodos {
    
    private int contadorAdivinado;
    private int contadorBloqueado;
    private int contadorPendiente;

    public CantidadDeNodos(int contadorAdivinado, int contadorBloqueado, int contadorPendiente) {
        this.contadorAdivinado = contadorAdivinado;
        this.contadorBloqueado = contadorBloqueado;
        this.contadorPendiente = contadorPendiente;
    }

    @Override
    public String toString() {
        return "Cantidad de nodos adivinados=" + contadorAdivinado + ", Cantidad de nodos bloqueados=" + contadorBloqueado + ", Cantidad de nodos pendientes=" + contadorPendiente;
    } 
    
    
    
}
