package main.materia.Controllers;

import main.materia.Modelo.Node;

public class ArbolBinario {

    private Node root;

    //metodo para insertar un nodo en el arbol
    public void insert(int value) {
        root = insert(root, value);

    }

    //metodo para insertar un nodo en el arbol
    private Node insert(Node node, int value) {

        if (node == null)
            return new Node(value);

        if (value < node.getValue()) {
            node.setLeft(insert(node.getLeft(), value));
        }
        if (value > node.getValue()) {
            node.setRight(insert(node.getRight(), value));
        }
        return node;
    }

    //clase para imprimir el arbol 
    public void printTree() {
        printTree(root, "", true);
    }

    //clase para imprimir el arbol 
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

    public Node getRoot() {
        return root;
    }

}
