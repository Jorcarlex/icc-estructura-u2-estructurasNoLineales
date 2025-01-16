Ejercicio 01: Insertar en un Árbol Binario de Búsqueda (BST)
Código: InsertBSTTest

Para la construcion de los arboles dentro del metodo `insert(Node root, int value)` cumpliendo las reglas de los valores menores se colocan en el subárbol izquierdo y los valores mayores se colocan en el subárbol derecho. Para la consruccion de del arreglo se implemento el metodo `buildTreeInteractive(int[] values)` que me permite contruir el arbol automaticamente apartir de los arrglo creado la App. La visualizacion de el arbol se utilizo el metodo `printTree()`, este imprime un arbol en formato jerárquico y que nos ayuda a visualizar la estructura del arbol. Su uso es muy simple, se asignan valores como `{10, 5, 15, 2, 7, 12, 20}` y luego se visualiza el arbol con las posiciones correctas.
-----------------------------------------------------------------------------------------------------------------------------------------
Ejercicio 02: Invertir un Árbol Binario
Código: InvertBinaryTree

El metodo `buildBinaryTree(int[] values)` es para creacion de un arbol de igual manera que el ejercicio anterior con el pequeño cambio de que va asignando nodos de izquierda a derecha por nivel. El metodo `invertTree(Node root)` invierte el arbol de manera que intercambia recursivamente los subárboles izquierdo y derecho de cada nodo. Para la visualizacion el `método printTree(Node node, String prefix, boolean isLeft)` imprime el árbol antes y después de invertirlo para verificar los cambios. Es muy facil su uso, se asignan valores al arbol para que luego se llame a `invertTree()` para invertir el árbol y asi usar `printTree()` para visualizar el árbol original y el invertido.
-----------------------------------------------------------------------------------------------------------------------------------------
Ejercicio 03: Listar Niveles del Árbol en Listas Enlazadas
Código: ListLevels

El funcionamiento del codigo comienza con la asignacion de valores al arbol para que luego a la hora de visualizar, el arbol se imprime cde manera correcta y la organizacion de los numeros por niveles. Se tuvo una presente utilizacion de colas.
-----------------------------------------------------------------------------------------------------------------------------------------
Ejercicio 04: Calcular la Profundidad Máxima de un Árbol Binario
Código: Depth

El cálculo de la profundidad máxima de un árbol binario se implementa mediante el método `maxDepth(Node root)`, que utiliza recursión para determinar el número de niveles desde la raíz hasta el nodo más profundo. Si el nodo actual es `null`, la profundidad es 0; de lo contrario, se calcula como `1 + Math.max(leftDepth, rightDepth)`, sumando el nivel actual al mayor entre los subárboles izquierdo y derecho. La construcción del árbol se realiza con el método `buildBinaryTree(int[] values)`, que toma un arreglo de valores y los organiza en un árbol binario siguiendo un recorrido por niveles. Para la visualización, el método `printTree()` imprime el árbol en formato jerárquico, lo que permite confirmar su estructura. Para usar esta funcionalidad, simplemente crea un árbol con un arreglo, como `{10, 20, 15, 24, 9, 8, 21}`, calcula la profundidad máxima con `maxDepth()` y utiliza `printTree()` para observar la estructura del árbol.
