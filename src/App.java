import main.Ejercicio_03_listLeves.ListLevels;
import main.materia.Controllers.ArbolBinario;
import main.materia.Controllers.ArbolRecorridos;

public class App {
    public static void main(String[] args) throws Exception {
        // System.out.println("Hello, World!");
        // runArbolBonario();
        runEjercicio3();

    }

    // Ejercicio 3
    private static void runEjercicio3() {
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
