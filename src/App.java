import main.materia.Controllers.ArbolBinario;

public class App {
    public static void main(String[] args) throws Exception {
        //System.out.println("Hello, World!");
        runArbolBonario();
    }

    public static void runArbolBonario() {

        ArbolBinario arbolBinario = new ArbolBinario();
        int [] value = {40, 20, 60, 10, 30, 50, 70, 5, 15, 55};

        for (int valor : value) {
            arbolBinario.insert(valor);
        }
        arbolBinario.printTree();
    }
}
