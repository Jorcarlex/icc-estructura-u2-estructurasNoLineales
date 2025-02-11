package main.materia.Modelo;

public class Node {

    //atributos
    private int value;
    private Node left;
    private Node right;
    private int height;

    public int getHeight() {
        return height;
    }
    public void setHeight(int height) {
        this.height = height;
    }
    //getters y setters
    public int getValue() {
        return value;
    }
    public void setValue(int value) {
        this.value = value;
    }
    public Node getLeft() {
        return left;
    }
    public void setLeft(Node left) {
        this.left = left;
    }
    public Node getRight() {
        return right;
    }
    public void setRight(Node right) {
        this.right = right;
    }

    //constructor
    public Node(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
    
    //toString
    @Override
    public String toString() {
        return "Node [value=" + value + ", left=" + left + ", right=" + right + "]";
    }
    
    
}
