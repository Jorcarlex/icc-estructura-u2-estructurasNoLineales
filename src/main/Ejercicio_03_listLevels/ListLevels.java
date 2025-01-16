package main.Ejercicio_03_listLevels;

import main.materia.Modelo.Node;
import main.materia.Controllers.ArbolBinario;

import java.util.*;

public class ListLevels {

    // Método para imprimir los niveles del árbol
    public static void printLevels(ArbolBinario arbolBinario) {
        Node root = arbolBinario.getRoot();

        // Si el árbol está vacío, imprimir mensaje y salir
        if (root == null) {
            System.out.println("El árbol está vacío.");
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        // .size() = cantidad de elementos en la cola
        // .poll() = remueve y devuelve el primer elemento de la cola
        // .add() = agrega un elemento al final de la cola
        // .isEmpty() = devuelve true si la cola está vacía
        // .getValue() = devuelve el valor del nodo
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>();

            // Recorrer los nodos del nivel actual
            for (int i = 0; i < levelSize; i++) {
                Node currentNode = queue.poll();
                currentLevel.add(currentNode.getValue());

                if (currentNode.getLeft() != null) {
                    queue.add(currentNode.getLeft());
                }

                if (currentNode.getRight() != null) {
                    queue.add(currentNode.getRight());
                }
            }

            // Imprimir los valores del nivel actual separados por comas
            // .stream() = crea un flujo de datos
            // .map() = aplica una función a cada elemento del flujo
            // .toArray() = convierte el flujo en un arreglo
            // .join() = une los elementos del arreglo en un string
            // .valueOf() = convierte un entero en un string
            // ::new = referencia al constructor de un arreglo
            System.out.println(String.join(", ",
                currentLevel.stream().map(String::valueOf).toArray(String[]::new)));
        }
    }
}
