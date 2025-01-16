package main.Ejercicio_01_insert;

import main.materia.Modelo.Node;

public class InsertBSTTest {

    // Descripción: Implementa un algoritmo para insertar valores en un Árbol
    // Binario de Búsqueda (BST). Un BST es un árbol binario donde cada nodo
    // sigue las siguientes reglas:

    // El subárbol izquierdo de un nodo contiene solo nodos con valores menores que
    // el nodo.
    // El subárbol derecho de un nodo contiene solo nodos con valores mayores que el
    // nodo.
    // ----------------------------------------------------------------------------------

    private Node root;

    // Método para insertar un valor en el BST
    public Node insert(Node root, int value) {
        if (root == null) {
            return new Node(value);
        }

        if (value < root.getValue()) { // Si el valor es menor que el nodo actual, ir al subárbol izquierdo
            root.setLeft(insert(root.getLeft(), value));
        } else if (value > root.getValue()) { // Si el valor es mayor que el nodo actual, ir al subárbol derecho
            root.setRight(insert(root.getRight(), value));
        }

        return root;
    }

    // Método para insertar valores
    public void buildTreeInteractive(int[] values) {
        for (int value : values) {
            root = insert(root, value);
        }
    }

    // Método para imprimir el árbol
    public void printTree() {
        printTree(root, "", true);
    }

    private void printTree(Node node, String prefix, boolean isLeft) {
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
