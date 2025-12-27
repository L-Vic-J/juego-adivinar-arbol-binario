package cr.ac.ufidelitas.proyectoed.victorleitonjimenez_pp3;

import java.util.Random;
import javax.swing.JOptionPane;

public class Arbol {

    
    //Atributos de la clase
    StringBuilder sb = new StringBuilder();
    Nodo raiz;
    
    //Minima cantidad de nodos
    final int cantidadNodos = 20;
    //Cantidad de intentos para adivinar el valor de nodo
    final int cantidadIntentos = 3;
    int contadorIntentos = 0;
    int contadorAdivinado=0;
    int contadorBloqueado=0;
    int contadorPendiente=0;

   
//Metodo publico para crear un arbol
    public void nuevaPartida() {

            //Se genera el dato de la raiz con random
            Random randomRaiz = new Random();
            int datoRaiz = randomRaiz.nextInt(1, 101);
            this.raiz = new Nodo(datoRaiz);
            //La raiz se pone como advinada
            raiz.setAdivinado(true);

            
            
        int contador = 2;
        
        //Se crean valores para los nodos de manera aleatoria hasta que alcance la cantidad minima de nodos.
        while (contador <= cantidadNodos) {
            Random random = new Random();
            int dato = random.nextInt(1, 101);
            //La raiz y el valor random se pasan como parametros al metodo recursivo
            nuevaPartidadRecursiva(raiz, dato);
            contador++;
        }

        JOptionPane.showMessageDialog(null, "Arbol creado", "Nuevo juego", JOptionPane.INFORMATION_MESSAGE);
    }

    private void nuevaPartidadRecursiva(Nodo nodo, int dato) {

   
        //Si el valor generado es mayor al valor del nodo se va para la izquierda
        if (nodo.getDato() < dato) {

            if (nodo.getNodoIzquierdo() == null) {
                nodo.setNodoIzquierdo(new Nodo(dato));
            } else {
                nuevaPartidadRecursiva(nodo.getNodoIzquierdo(), dato);
            }

        } else {

            //Si el valor generado es menor al valor del nodo se va para la izquierda
            if (nodo.getDato() > dato) {

                if (nodo.getNodoDerecho() == null) {
                    nodo.setNodoDerecho(new Nodo(dato));
                } else {
                    nuevaPartidadRecursiva(nodo.getNodoDerecho(), dato);
                }

            }

        }

    }

    
    //Metodo público para adivinar
    public void adivinar() {
        //Si el arbol esta vacio se muestra advertencia
        if (raiz == null) {
            JOptionPane.showMessageDialog(null, "No hay números que adivinar", "Error al adivinar", JOptionPane.ERROR_MESSAGE);
        } else {
            
            //La raiz se pasa como parametro al metodo recursivo y este metodo retorna el nodo que esta pendiente de advinar usando in Order
            Nodo nodoPendiente = adivinarRecursivoInOrder(raiz);
            //Si el nodo es diferente a null se valida
            if (nodoPendiente!=null){
                
            //Variables para llevar el control de las oportunidades para adivinar
            final int oportunidades = 1;
            int contador = 0;

            
            //Valor del nodo a adivinar se muestra solo para comprobar funcionalidades, se procede a comentar ya que no funciona parte del ciclo normal del programa
            
            //JOptionPane.showMessageDialog(null, nodoPendiente.getDato());

            
            // Input para ingresar el valor
            int valorIngresado = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el numero"));

            
            //Si el valor es diferente al del nodo, se habilitan las oportunidades restantes 
            if (valorIngresado != nodoPendiente.getDato()) {
                while (contador <= oportunidades) {

                    valorIngresado = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el numero"));
                    contador++;
                }
                //Si las oportunidades se acaban, el nodo se bloquea
                JOptionPane.showMessageDialog(null, "No adivinaste el número", "Error al adivinar", JOptionPane.ERROR_MESSAGE);
                nodoPendiente.setBloqueado(true);

                //Si adivino el valor del nodo se ponde como adivinado
            } else {
                nodoPendiente.setAdivinado(true);
                JOptionPane.showMessageDialog(null, "Felicidades, adivinaste el número", "Numero adivinado", JOptionPane.INFORMATION_MESSAGE);

            }
            }



        }
    }

    
    //Metodo recursivo para adivinar
    private Nodo adivinarRecursivoInOrder(Nodo nodo) {

        
        // Si se llega a las hojas, se retorna null
        if (nodo == null) {
            return null;
        }
        
        //Se recorre por el sub-arbol izquierdo
        Nodo nodoIzquierdo=adivinarRecursivoInOrder(nodo.getNodoIzquierdo());
        
        // Si se encuentra el nodo, se retorna
        if (nodoIzquierdo!=null){
            return nodoIzquierdo;
        }

        // Se retorna el nodo que no este adivinado y tampoco este bloqueado, que seria pendiente
       if (!nodo.getAdivinado() == true && !nodo.getBloqueado() == true) {
                return nodo;
            }
       
       //Se recorre el sub-arbol derecho 
       return adivinarRecursivoInOrder(nodo.getNodoDerecho());
       
    }

    
    //Metodo publico para ver el estado de los nodos
    public void estado() {
 
        //Si el arbol esta vacio se muestra la alerta
        if (raiz == null) {
            JOptionPane.showMessageDialog(null, "No hay resultados que mostrar", "Arbol sin numeros", JOptionPane.ERROR_MESSAGE);
        } else {
            //Se pasa la raiz como parametro al metodo recursivo
            String estado = estadoRecursivoInOrder(raiz);
            //Se muestra el estado de los nodos
            JOptionPane.showMessageDialog(null, estado);
            //Se limpia el String Builder 
            this.sb = new StringBuilder();
        }

    }

    //Metodo recursivo de estado
    private String estadoRecursivoInOrder(Nodo nodo) {

        //Se recorre mientras no se llegue a las hojas
        if (nodo != null) {
            
            //Se recorre por la izquierda
            estadoRecursivoInOrder(nodo.getNodoIzquierdo());
            //Si el nodo esta bloqueado, al string builder se le añade un *
            if (nodo.getBloqueado() == true) {
                sb.append("*").append("+");
            //Si el nodo esta adivinado, al string builder se le añade el dato
            } else if (nodo.getAdivinado() == true) {
                sb.append(nodo.getDato()).append("+");
            //Si el nodo esta pendiente de adivinar, al string builder se le añade el -
            } else if (nodo.getAdivinado() == false) {
                sb.append("-").append("+");
            }

            //Se recorre por la derecha
            estadoRecursivoInOrder(nodo.getNodoDerecho());

        }
        
        //Se retorna el String builder pero usando su metodo toString
        return sb.toString();

    }
    
    
    //Metodo publico para calcular la cantidad de nodos adivinados, bloqueados o pendientes
    public void cantidadDeNodos (){
        
        //Un objeto de tipo CantidadDeNodos recibe el return del metodo recursivo que usa como parametro la raíz
        CantidadDeNodos cantidadDeNodos= cantidadDeNodosRecursivo(raiz);
        //Se muestran los nodos
        JOptionPane.showMessageDialog(null,cantidadDeNodos.toString());
        
        
        
    }
    
  //Metodo recursivo para calcular la cantidad de nodos por tipo
    private CantidadDeNodos cantidadDeNodosRecursivo(Nodo nodo) {

        
        //Mientras no se llegue a las hojas se recorre
        if (nodo != null) {
            //Se recorre por la izquierda
            cantidadDeNodosRecursivo(nodo.getNodoIzquierdo());
            //Si el nodo esta adivinado, se suma 1 al contador de Adivinado
            if (nodo.getAdivinado() == true) {
                contadorAdivinado++;
           //Si el nodo esta bloqueado, se suma 1 al contador de Bloqueado
            }else if (nodo.getBloqueado()==true){
                contadorBloqueado++;
           //Si el nodo esta pendiente, se suma 1 al contador de Pendiente
            }else if (!nodo.getAdivinado()== true && !nodo.getBloqueado()==true){
                contadorPendiente++;
        }
            //Se recorre por la derecha
            cantidadDeNodosRecursivo(nodo.getNodoDerecho());
          
        }
        
        //Se crea el objeto y se retorna
         CantidadDeNodos cantidad= new CantidadDeNodos(contadorAdivinado, contadorBloqueado, contadorPendiente);
         
         return cantidad;
    }
    
    
    //Metodo publico para calcular puntos
   public void calcularPuntos (){
       
       //Una variable int recibe al return del metodo recursivo que recibe como parametro la raiz y el nivel 0
       int puntaje= calcularPuntosRecursivo(raiz, 0);
       //Se muestra el puntaje obtenido
       JOptionPane.showMessageDialog(null,"El puntaje obtenido fue:"+puntaje);
       
   }

//Metodo privado recursivo para calcular los puntos
   private int calcularPuntosRecursivo (Nodo nodo, int nivel){
       
       //Variable puntos arranca en 0
       int puntos=0;
       
       // Mientras no se llegue a las hojas se reccorre
       if (nodo!=null){
           //Si el nodo esta adivinado se suma el calculo para los adivinados en el nivel
           if (nodo.getAdivinado()==true){
               puntos+=3*nivel;
           //Si el nodo esta bloqueado se suma el calculo para los bloqueados en el nivel
           }else if (nodo.getBloqueado()==true){
               puntos+=1*nivel;
           }
           
           //Se suma la llamada al sub-arbol izquierdo y derecho
           puntos+=calcularPuntosRecursivo (nodo.getNodoIzquierdo(), nivel+1);
           puntos+=calcularPuntosRecursivo (nodo.getNodoDerecho(), nivel+1);
       }
       
       
       //Se retorna los puntos
       return puntos;
       
       
   }
}

