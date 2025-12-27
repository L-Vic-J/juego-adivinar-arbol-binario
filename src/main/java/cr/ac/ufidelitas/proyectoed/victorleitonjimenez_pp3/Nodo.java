
package cr.ac.ufidelitas.proyectoed.victorleitonjimenez_pp3;


public class Nodo {
    
    //Atributos del nodo
    private int dato;
    private Nodo nodoIzquierdo,nodoDerecho;
    private boolean adivinado,bloqueado; 

    //Constructor
    public Nodo(int dato) {
        this.dato = dato;
        this.nodoIzquierdo = null;
        this.nodoDerecho = null;
        this.adivinado = false;
        this.bloqueado = false;
    }

    public Nodo() {
        
        
    }

    
    public int getDato() {
        return dato;
    }

    public Nodo getNodoIzquierdo() {
        return nodoIzquierdo;
    }

    public Nodo getNodoDerecho() {
        return nodoDerecho;
    }

    public Boolean getAdivinado() {
        return adivinado;
    }

    public Boolean getBloqueado() {
        return bloqueado;
    }

    public void setDato(int dato) {
        this.dato = dato;
    }

    public void setNodoIzquierdo(Nodo nodoIzquierdo) {
        this.nodoIzquierdo = nodoIzquierdo;
    }

    public void setNodoDerecho(Nodo nodoDerecho) {
        this.nodoDerecho = nodoDerecho;
    }

    public void setAdivinado(boolean adivinado) {
        this.adivinado = adivinado;
    }

    public void setBloqueado(boolean bloqueado) {
        this.bloqueado = bloqueado;
    }
    
    
    
    
    
}
