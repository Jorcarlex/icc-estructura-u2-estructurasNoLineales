package main.materia.Controllers;

import java.util.Stack;

import main.materia.Modelo.Node;

public class ArbolRecorridos {

    //-----------VA EN LA PRUEBA----------------

    public void preOrderInterativo(Node root){
        
        //verificar si no esta vacio
        if (root == null) {
            return; 
        }

        //Pila para manejar los nodo del arbol durante el recorrido
        Stack<Node> stack = new Stack<Node>();

        //Se agrega el nodo raiz
        stack.push(root);

        //Mientras la pila no este vacia, 
        while (!stack.isEmpty()) {
            //El pop es para sacar el elemento de la pila, sin embargo,
            //tambien paraagrergar el elemento a la pila se usa push
            Node node = stack.pop(); 
            System.out.print(node.getValue() + ", ");   

            //Se agrega el nodo derecho primero
            if (node.getRight() != null) {
                stack.push(node.getRight());
            }

            //Se agrega el nodo izquierdo
            if (node.getLeft() != null) {
                stack.push(node.getLeft());
                
            }
        }
    }

    public void preOrderRecursivo(Node node){

        //Cominza verificando que el el nodo no sea nulo, si lo es se detiene para esa rama
        //al no ser nulo se imprime el nodo actual y posteriormente se recorre el nodo izquierdo
        //hasta llegar al nodo mas a la izquierda, luego se recorre el nodo derecho de ese nodo
        //y se repite el proceso hasta llegar al nodo mas a la derecha del arbol.
        //PreOrden --- > centro, izquierda, derecha

        //verificar si no esta vacio
        if (node != null) {

            //Imprime el nodo actual
            System.out.print(node.getValue() + ", ");

            //Se recorre al lado izquierdo
            preOrderRecursivo(node.getLeft());
            //Se recorre al lado derecho
            preOrderRecursivo(node.getRight());
        }
    }

    public void inOrderInterativo(Node node){
        
        if (node != null) {
            //Se recorre el nodo izquierdo
            inOrderInterativo(node.getLeft());
            //Se imprime el nodo actual
            System.out.print(node.getValue() + ", ");
            //Se recorre el nodo derecho
            inOrderInterativo(node.getRight());
        }
    }

    public void posOrderInterativo(Node node){
        if (node != null) {
            
            //Se recorre el nodo izquierdo
            posOrderInterativo(node.getLeft());
            //Se recorre el nodo derecho
            posOrderInterativo(node.getRight());
            //Se imprime el nodo actual
            System.out.print(node.getValue() + ", ");
        }
    }
}
