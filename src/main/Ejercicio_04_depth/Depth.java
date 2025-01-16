package main.Ejercicio_04_depth;

import java.util.LinkedList;

import java.util.Queue;

import main.materia.Modelo.Node;

public class Depth {
// Método principal para calcular la profundidad máxima de un árbol binario
    public int maxDepth(Node root) {
        if (root == null) {
            return 0; // Un árbol vacío tiene profundidad 0
        }

        // Calcular la profundidad de los subárboles izquierdo y derecho
        int leftDepth = maxDepth(root.getLeft());
        int rightDepth = maxDepth(root.getRight());

        // La profundidad máxima es 1 (el nodo actual) más la mayor entre los subárboles
        return 1 + Math.max(leftDepth, rightDepth);
    }

    // Método auxiliar para construir un árbol binario a partir de un arreglo
    public Node buildBinaryTree(int[] values) {
        if (values.length == 0) {
            return null; // Si el arreglo está vacío, no hay árbol
        }

        Node root = new Node(values[0]);
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        int i = 1;
        while (i < values.length) {
            Node current = queue.poll();

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

        return root;
    }

    // Método auxiliar para imprimir el árbol en formato jerárquico
    public void printTree(Node node, String prefix, boolean isLeft) {
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
