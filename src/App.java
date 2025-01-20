import java.util.List;
import java.util.Scanner;

import main.Ejercicio_01_insert.InsertBSTTest;
import main.Ejercicio_02_invert.InvertBinaryTree;
import main.Ejercicio_03_listLevels.ListLevels;
import main.Ejercicio_04_depth.Depth;
import main.materia.Controllers.ArbolAVL;
import main.materia.Controllers.ArbolBinario;
import main.materia.Controllers.ArbolRecorridos;
import main.materia.Controllers.Graph;
import main.materia.Modelo.Node;
import main.materia.Modelo.NodeG;

public class App {
    public static void main(String[] args) throws Exception {
        // System.out.println("Hello, World!");

        // runArbolBonario();
        // runArbolAvl();

        // ejercicio_1();
        // ejercicio_2();
        // ejercicio_3();
        // ejercicio_4();

        //runGraph();
        runGraphEjercicio();
    }
    private static void runGraphEjercicio(){

        Graph graph = new Graph();

        NodeG node0 = graph.addNode(0);
        NodeG node1 = graph.addNode(1);
        NodeG node2 = graph.addNode(2);
        NodeG node3 = graph.addNode(3);
        NodeG node4 = graph.addNode(4);
        NodeG node5 = graph.addNode(5);
        NodeG node7 = graph.addNode(7);
        NodeG node8 = graph.addNode(8);
        NodeG node9 = graph.addNode(9);

        graph.addEdge(node0, node1);
        graph.addEdge(node0, node3);
        graph.addEdge(node0, node5);

        graph.addEdge(node1, node0);
        graph.addEdge(node1, node2);
        graph.addEdge(node1, node4);
        graph.addEdge(node1, node8);

        graph.addEdge(node2, node3);
        graph.addEdge(node2, node1);

        graph.addEdge(node3, node0);
        graph.addEdge(node3, node2);
        graph.addEdge(node3, node4);
        graph.addEdge(node3, node7);
        graph.addEdge(node3, node9);

        graph.addEdge(node4, node3);
        graph.addEdge(node4, node1);

        graph.addEdge(node5, node0);

        graph.addEdge(node7, node3);
        graph.addEdge(node7, node8);

        graph.addEdge(node8, node7);
        graph.addEdge(node8, node1);

        graph.addEdge(node9, node1);

        graph.printGraph();

        System.out.println("---------------------");
        System.out.println("\nGraph No Direcconado:");
        System.out.println("");

        graph.getDFS(node0);



    }

        private static void runGraph() {
        Graph graph = new Graph();

        /*
         * // Se crean los nodos
         * NodeG node1 = graph.addNode(5);
         * NodeG node2 = graph.addNode(7);
         * NodeG node3 = graph.addNode(9);
         * NodeG node4 = graph.addNode(11);
         * NodeG node5 = graph.addNode(3);
         * 
         * graph.addEdge(node1, node5);
         * graph.addEdge(node1, node2);
         * graph.addEdge(node1, node3);
         * graph.addEdge(node2, node3);
         * graph.addEdge(node5, node3);
         * graph.addEdge(node5, node4);
         * 
         * graph.printGraph();
         */

        // Se crean los nodos
        NodeG node0 = graph.addNode(0);
        NodeG node1 = graph.addNode(1);
        NodeG node2 = graph.addNode(2);
        NodeG node3 = graph.addNode(3);
        NodeG node4 = graph.addNode(4);
        NodeG node5 = graph.addNode(5);

        // Se crean las aristas entre los nodos del grafo dirigido
        graph.addEdgeUni(node0, node3);
        graph.addEdgeUni(node0, node5);
        graph.addEdgeUni(node3, node2);
        graph.addEdgeUni(node3, node4);
        graph.addEdgeUni(node2, node1);
        graph.addEdgeUni(node4, node1);
        graph.addEdgeUni(node1, node0);

        graph.printGraph();

        System.out.println("\nGraph Direcconado:");
        System.out.println("");

        graph.getDFS(node0);
        graph.getBFS(node0);
        
        // Se crean las aristas entre los nodos del grafo no dirigido
        graph.addEdge(node0, node3);
        graph.addEdge(node0, node5);
        graph.addEdge(node3, node2);
        graph.addEdge(node3, node4);
        graph.addEdge(node2, node1);
        graph.addEdge(node4, node1);
        graph.addEdge(node1, node0);

        System.out.println("");
        System.out.println("\nGraph No Direcconado:");
        System.out.println("");

        graph.getDFS(node0);
        graph.getBFS(node0);

    } 

    public static void ejercicio_1() {
        InsertBSTTest bst = new InsertBSTTest();
        Scanner scanner = new Scanner(System.in);

        boolean inputValid = false;

        while (!inputValid) {
            System.out.println("Input:");
            String input = scanner.nextLine();

            // Convertir la entrada del usuario en un arreglo de enteros
            String[] inputValues = input.split(",");
            int[] values = new int[inputValues.length];

            try {
                for (int i = 0; i < inputValues.length; i++) {
                    values[i] = Integer.parseInt(inputValues[i].trim());
                }

                // Construir el árbol con los valores ingresados
                bst.buildTreeInteractive(values);
                inputValid = true; // Si no hay excepción, el input es válido

                // Imprimir el árbol resultante
                System.out.println("\nOutput:");
                bst.printTree();

            } catch (NumberFormatException e) {
                System.out.println("Error: Asegúrese de ingresar solo números enteros separados por comas.");
            }
        }

        scanner.close();
    }

    public static void ejercicio_2() {
        InvertBinaryTree ibt = new InvertBinaryTree();

        // Valores para construir el árbol binario
        int[] values = { 10, 20, 15, 24, 9, 8, 21, 22, 50, 25 };

        // Construir el árbol binario
        Node root = ibt.buildBinaryTree(values);

        // Imprimir el árbol original
        System.out.println("Input:");
        ibt.printTree(root, "", true);

        // Invertir el árbol binario
        Node invertedRoot = ibt.invertTree(root);

        // Imprimir el árbol invertido
        System.out.println("\nOutput:");
        ibt.printTree(invertedRoot, "", true);

    }

    private static void ejercicio_3() {
        ArbolBinario arbolBinario = new ArbolBinario();
        int[] numeros = { 4, 2, 1, 3, 7, 6, 9 };

        for (int valor : numeros) {
            arbolBinario.insert(valor);
        }

        System.out.println("Input: ");
        arbolBinario.printTree();

        System.out.println("Ouput: ");
        ListLevels.printLevels(arbolBinario);
    }

    public static void ejercicio_4() {
        Depth depth = new Depth();

        // Valores para construir el árbol binario
        int[] values = { 10, 20, 15, 24, 9, 8, 21 };

        // Construir el árbol binario
        Node root = depth.buildBinaryTree(values);

        // Imprimir el árbol binario en formato jerárquico
        System.out.println("Intput:");
        depth.printTree(root, "", true);

        // Calcular la profundidad máxima
        int maxDepth = depth.maxDepth(root);

        // Imprimir el resultado
        System.out.println("\nOutput: ");
        System.out.println(maxDepth);
    }

    // --------------------------------------------------------
    public static void runArbolAvl() {

        ArbolAVL arbolAVL = new ArbolAVL();
        int[] values = { 10, 20, 15, 24, 9, 8, 21, 23, 50, 25 };

        for (int value : values) {
            arbolAVL.insert(value);
        }
    }

    // --------------------------------------------------------
    public static void runArbolBonario() {

        // Se crea un arbol binario
        ArbolBinario arbolBinario = new ArbolBinario();
        int[] value = { 40, 20, 60, 10, 30, 50, 70, 5, 15, 55 };

        // Se insertan los valores en el arbol
        for (int valor : value) {
            arbolBinario.insert(valor);
        }
        arbolBinario.printTree();

        ArbolRecorridos arbolRecorridos = new ArbolRecorridos();

        // impreme el arbol en preOrder
        System.out.println("Recorrido preOrder: ");
        arbolRecorridos.preOrderInterativo(arbolBinario.getRoot());
        System.out.println("\nRecorrido inOrder: ");
        arbolRecorridos.inOrderInterativo(arbolBinario.getRoot());
        System.out.println("\nRecorrido postOrder: ");
        arbolRecorridos.posOrderInterativo(arbolBinario.getRoot());

    }
}
