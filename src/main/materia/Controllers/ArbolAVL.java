package main.materia.Controllers;

import main.materia.Modelo.Node;

public class ArbolAVL {

    private Node root;

    public void insert(int value) {
        System.out.println("*Nodo a insertar: " + value);
        System.out.println("Nodo insertado: " + value + ", Balance: " + getBalance(root));
        root = insert(root, value);
        printTree();

    }

    private Node insert(Node nodo, int value) {

        if (nodo == null) {
            Node newNode = new Node(value);

            newNode.setHeight(1);
            return newNode;
        }

        if (value < nodo.getValue()) {
            nodo.setLeft(insert(nodo.getLeft(), value));

        } else if (value > nodo.getValue()) {
            nodo.setRight(insert(nodo.getRight(), value));

        } else {
            return nodo;
        }

        nodo.setHeight(1 + Math.max(height(nodo.getLeft()), height(nodo.getRight())));

        // Obtener el balance do factor de equilibriodel nodo ancestro
        int balance = getBalance(nodo);

        // Caso izquierda - izquierda (Simple)
        if (balance > 1 && value < nodo.getLeft().getValue()) {
            return rightRotate(nodo);
        }

        // Caso derecha - derecha (simple)
        if (balance < -1 && value > nodo.getRight().getValue()) {
            return leftRotate(nodo);
        }

        // Caso izquierda - derecha (Doble)
        if (balance > 1 && value > nodo.getLeft().getValue()) {
            nodo.setLeft(leftRotate(nodo.getLeft()));
            return rightRotate(nodo);
        }

        // Caso derecha - izquierda (Doble)
        if (balance < -1 && value < nodo.getRight().getValue()) {
            nodo.setRight(rightRotate(nodo.getRight()));
            return leftRotate(nodo);
        }

        // Devolvemos el nodo sin cambios`
        return nodo;
    }

    private Node leftRotate(Node x) {
        Node y = x.getRight();
        Node temp = y.getLeft();

        System.out.println("Rotamos izquierda el nodo: " + x.getValue() + ", Balance:"  + getBalance(x));
        // Realizamos la rotaciones
        y.setLeft(x);
        x.setRight(temp);

        // Actualizamos las alturas
        x.setHeight(Math.max(height(x.getLeft()), height(x.getRight())) + 1);
        y.setHeight(Math.max(height(y.getLeft()), height(y.getRight())) + 1);

        // Imprimir informacion despues de la rotacion
        System.out.println("Nueva raiz despues de rotacion izquierda: " + y.getValue());
        return y;
    }

    // Rotacion a la derecha
    private Node rightRotate(Node y) {
        Node x = y.getLeft();
        Node temp = x.getRight();

        System.out.println("Rotamos derecha el nodo: " + y.getValue());
        // Realizamos la rotaciones
        x.setRight(y);
        y.setLeft(temp);

        // Actualizamos las alturas
        y.setHeight(Math.max(height(y.getLeft()), height(y.getRight())) + 1);
        x.setHeight(Math.max(height(x.getLeft()), height(x.getRight())) + 1);

        System.out.println("Nueva raiz despues de rotacion derecha: " + x.getValue());
        return x;
    }

    private int getBalance(Node node) {
        if (node == null) {
            return 0;
        }
        return height(node.getLeft()) - height(node.getRight());
    }

    private int height(Node node) {
        if (node == null) {
            return 0;
        }
        return node.getHeight();
    }

    // clase para imprimir el arbol
    public void printTree() {
        printTree(root, "", true);
    }

    // clase para imprimir el arbol
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
