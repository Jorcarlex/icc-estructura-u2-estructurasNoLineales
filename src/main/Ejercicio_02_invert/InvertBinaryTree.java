package main.Ejercicio_02_invert;

import java.util.LinkedList;
import java.util.Queue;

import main.materia.Modelo.Node;

public class InvertBinaryTree {

    // Descripción: Dada la raíz de un árbol binario, implementa un algoritmo que
    // devuelva el árbol binario invertido.

    // ----------------------------------------------------------------------------------

    // Método para construir un árbol binario a partir de un arreglo de enteros
    public Node buildBinaryTree(int[] values) {
        if (values.length == 0) {
            return null; // Si el arreglo está vacío, no hay árbol
        }

        // Crear la raíz del árbol con el primer valor
        Node root = new Node(values[0]);

        // Cola para gestionar la asignación de nodos
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        int i = 1;
        // Asignar los nodos hijos
        while (i < values.length) {
            Node current = queue.poll(); // Obtener el nodo actual de la cola

            // Asignar el hijo izquierdo
            if (i < values.length) {
                current.setLeft(new Node(values[i++]));
                queue.add(current.getLeft());
            }

            // Asignar el hijo derecho
            if (i < values.length) {
                current.setRight(new Node(values[i++]));
                queue.add(current.getRight());
            }
        }

        // Retornar la raíz del árbol
        return root;
    }

    // Método para invertir el árbol binario
    public Node invertTree(Node root) {
        if (root == null) {
            return null; // Si el nodo es null, no hay nada que invertir
        }

        // Intercambiar los nodos izquierdo y derecho
        Node temp = root.getLeft();
        root.setLeft(invertTree(root.getRight()));
        root.setRight(invertTree(temp));

        return root; // Retornar la raíz invertida
    }

    // Método para imprimir el árbol binario con control de prefijos
    public void printTree(Node node, String prefix, boolean isLeft) {
        // Limitar el tamaño del prefijo para evitar errores
        if (prefix.length() > 100) {
            prefix = prefix.substring(0, 100) + "...";
        }

        if (node != null) {
            System.out.println(prefix + (isLeft ? "├── " : "└── ") + node.getValue());

            if (node.getLeft() != null || node.getRight() != null) {
                if (node.getLeft() != null) {
                    printTree(node.getLeft(), prefix + (isLeft ? "|   " : "   "), true);
                } else {
                    System.out.println(prefix + (isLeft ? "|   " : "   ") + "├── null");
                }

                if (node.getRight() != null) {
                    printTree(node.getRight(), prefix + (isLeft ? "|   " : "   "), false);
                } else {
                    System.out.println(prefix + (isLeft ? "|   " : "   ") + "└── null");
                }
            }
        }
    }
}
