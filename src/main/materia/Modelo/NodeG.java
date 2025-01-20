package main.materia.Modelo;

import java.util.LinkedList;
import java.util.List;

public class NodeG {

    //no hay setters porque no se modifican los valores de los nodos

    private int value;
    private List<NodeG> neighbors;

    public NodeG(int value) {
        this.value = value;
        this.neighbors = new LinkedList<>();
    }

    public int getValue() {
        return value;
    }

    public List<NodeG> getNeighbors() {
        return neighbors;
    }

    public void addNeighbor(NodeG neighbor) {
        this.neighbors.add(neighbor);
    }

}
