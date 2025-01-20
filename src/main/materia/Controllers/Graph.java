package main.materia.Controllers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

import main.materia.Modelo.Node;
import main.materia.Modelo.NodeG;

public class Graph {

    private List<NodeG> nodes;

    // Constructor
    public Graph() {
        this.nodes = new ArrayList<>(); // Inicializar la lista de nodos
    }

    // Metodo para añadir un nodo al grafo
    public NodeG addNode(int value) {

        NodeG nodeG = new NodeG(value);
        nodes.add(nodeG);
        return nodeG;
    }

    public void addEdge(NodeG src, NodeG dest) {
        src.addNeighbor(dest);
        dest.addNeighbor(src);
    }

    public void addEdgeUni(NodeG src, NodeG dest) {
        src.addNeighbor(dest);
    }

    public void printGraph() {
        for (NodeG nodeG : nodes) {
            System.out.print("Vertice " + nodeG.getValue() + ": ");

            for (NodeG nei : nodeG.getNeighbors()) {
                System.out.print(nei.getValue() + "->");
            }
            System.out.println();
        }
    }

    // Los "DFS" son recorridos en profundidad que se utilizan para recorrer todos
    // los nodos de un grafo o árbol
    // de manera ordenada. Se trata de un algoritmo recursivo que se basa en la idea
    // de ir explorando todos los
    // nodos de un grafo de manera profunda antes de pasar a explorar los nodos
    // vecinos.
    // Explora tanto como sea posible a lo largo de cada rama antes de retroceder.
    public void getDFS(NodeG start) {

        Set<NodeG> visitados = new HashSet<>();

        System.out.println("DFS desde el nodo" + start.getValue() + ":");

        getDFSUtil(start, visitados);
        System.out.println();
    }

    public void getDFSUtil(NodeG node, Set<NodeG> visitados) {

        if (visitados.contains(node)) {
            return;
        }

        visitados.add(node);
        System.out.print(node.getValue() + " ");

        for (NodeG neighbor : node.getNeighbors()) {
            getDFSUtil(neighbor, visitados);
        }
        
    }

    // Los "BFS" son recorridos en anchura que se utilizan para recorrer todos los
    // nodos de un grafo o árbol de
    // manera ordenada. Se trata de un algoritmo que se basa en la idea de ir
    // explorando todos los nodos de un
    // grafo de manera horizontal antes de pasar a explorar los nodos vecinos.
    // Explora todos los vertices vecinos en el nivel actual antes de pasar al
    // siguiente nivel.
    public void getBFS(NodeG start) {
        Set <NodeG> visitados = new HashSet<>();
        Queue<NodeG> cola = new java.util.LinkedList<>();

        System.out.println("BFS desde el nodo" + start.getValue() + ":");
        cola.add(start);
        visitados.add(start);

        // .poll() remueve el primer elemento de la cola
        while (!cola.isEmpty()) {

            // Saco el primer elemento de la cola
            NodeG actual = cola.poll();
            System.out.print(actual.getValue() + " ");
            
            // Recorro los vecinos del nodo actual
            for (NodeG neighbor : actual.getNeighbors()) {

                // Si el vecino no ha sido visitado, lo agrego a la cola
                if (!visitados.contains(neighbor)) {
                    visitados.add(neighbor);
                    cola.add(neighbor);
                }
            }
        }


    }

    public void printAdjacencyMatrix() {
    }

}
