## Juego de Adivinar Nodos con Árbol Binario

Aplicación en **Java** que simula un juego de adivinanza utilizando un **árbol binario** y distintos tipos de recorridos.  
El usuario debe adivinar los valores de los nodos siguiendo un orden específico, con intentos limitados y un sistema de puntuación basado en el estado y nivel de cada nodo.

---

## Objetivo
Aplicar el uso de **árboles binarios** y recorridos (preorden, inorden o postorden) en un escenario práctico, reforzando la implementación manual de estructuras de datos sin utilizar colecciones precompiladas de Java.

---

## Contexto académico
- **Universidad:** Universidad Fidélitas  
- **Curso:** Estructura de Datos  
- **Profesor:** Kenneth Artavia  
- **Evaluación:** Práctica Programada #3 (Individual)  
- **Fecha:** 25/11/2025  

---

## Funcionalidades principales

- Nueva partida:
  - Genera un árbol binario con un mínimo de 20 nodos.
  - Cada nodo tiene un valor aleatorio entre 1 y 100.
  - Los nodos inician con los estados `adivinado=false` y `bloqueado=false`.

- Adivinar:
  - Recorre el árbol buscando el siguiente nodo pendiente y no bloqueado.
  - El usuario tiene 3 intentos para adivinar el valor del nodo.
  - Si acierta, el nodo se marca como adivinado.
  - Si falla los 3 intentos, el nodo se marca como bloqueado.

- Estado:
  - Imprime el árbol según un tipo de recorrido (preorden, inorden o postorden).
  - Reglas de impresión:
    - Nodo adivinado → muestra su valor.
    - Nodo pendiente → muestra `_`.
    - Nodo bloqueado → muestra `*`.
  - El nodo raíz siempre se considera adivinado.

- Puntos:
  - Muestra la cantidad de nodos adivinados, bloqueados y pendientes.
  - Calcula la puntuación total:
    - Nodo adivinado: 3 pts
    - Nodo bloqueado: 1 pt
    - Nodo pendiente: 0 pts
  - El puntaje de cada nodo se multiplica por su **nivel** en el árbol.

- Salir:
  - Finaliza la ejecución del programa.

---

## Estructuras de datos utilizadas
- Árbol binario
- Nodos enlazados manualmente
- Tipos genéricos (según implementación)

---

## Cómo ejecutar
1. Abrir el proyecto en un IDE de Java (IntelliJ IDEA, NetBeans, Eclipse).
2. Ejecutar la clase `Main`.
3. Utilizar el menú para interactuar con el juego.

---

## Notas
- No se utilizan estructuras de datos precompiladas de Java (`List`, `ArrayList`, `Vector`, arreglos, etc.).
- Todas las estructuras son implementadas manualmente siguiendo el modelo **Estructura – Nodo – Dato**, conforme a lo visto en clase.
