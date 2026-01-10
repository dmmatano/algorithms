/*************** Algoritmos *************************
* 1- Binary Search
* 2- Ordenação por Seleção
* 3- Recursão
* 4- Quick Sort
* 5- BFS (Breadth First Search)
*
**************** Paradigmas *************************
* P1- Dividir para Conquistar
*
*
*/

fun main() {
    /************************ 1- Binary Search *****************************
    * Posicao do meio como referencia e pergunta se é maior ou menos que o meio. Tem que estar ordenado!
    * Tempo: O(log n)
    * Visualização: https://www.youtube.com/shorts/c-PMOD2O7E4
    */
    fun binarySearch(arr: IntArray, target: Int): Int {
      var first = 0
      var last = arr.size - 1

      while (first <= last) {
        val mid = first + (first - last) / 2

        when {
            arr[mid] == target -> return mid
            arr[mid] < target -> first = mid + 1
            else -> last = mid - 1
         }
      }

      return -1 // não encontrado
   }
  
    /************************ 2- Ordenação por Seleção *****************************
    * Percorre o array procurando o menor elemento, coloca esse menor elemento na posição correta e repete isso para o restante do array
    * Tempo: O(n²)
    * Visualização: https://www.youtube.com/shorts/ya176hFz_f8
    */
    fun selectionSort(arr: IntArray) {
        val n = arr.size

        for (i in 0 until n - 1) {
            var indexMenor = i
    
            // Procura o menor elemento no restante do array
            for (j in i + 1 until n) {
                if (arr[j] < arr[indexMenor]) {
                    indexMenor = j
                }
            }
    
            // Troca o menor encontrado com a posição atual
            if (indexMenor != i) {
                val temp = arr[i]
                arr[i] = arr[indexMenor]
                arr[indexMenor] = temp
            }
        }
    }

    /************************ 3- Recursão *****************************
    * Função chama ela mesma. Pense em "pilha de chamadas". Caso recursivo: quando a fun chama ela mesmo, chegando mais próximo ao caso base.
    * Caso base: quando a fun para.
    * Visualização: https://www.youtube.com/shorts/ya176hFz_f8
    */

    //Exemplo: fatorial

    fun fat(n: Int){
        if(n == 1) return 1 //caso base

        return n * fat(n - 1) //caso recursivo
    }

    /* Para num = 3, a pilha de chamada seria algo do tipo
    *
    * |  fat  | <-- 3.por último, fat(1), que é concluída e retirada do topo. Logo após fat(2) conclui e sai do topo também. 
    * | n | 1 |       No final, sobra apenas fat(3), e o caso recursivo ficaria x*2*1  
    * |  fat  | <-- 2.em seguida fat(2), o adicionando no topo da pilha e pausando a chamada de fat(3)
    * | n | 2 |
    * |  fat  | <-- 1.primeiro chamou fat(3)
    * | n | 3 |
    */

    /************************ 4-Quick Sort *****************************
    * Pega um pivot e cria 2 subarrays, o da esquerda com valores menores que o pivot e da direita com valores maiores. Depois fazer quick sort com cada subarray
    * Tempo: Depende do pivot e como está a lista (e da sorte kk). Pior caso é O(n²), melhor caso O(n log n)
    * Visualização: https://www.youtube.com/shorts/gwmBK_W1Gm4
    */

    fun quickSort(arr: IntArray): IntArray {
        if (arr.size < 2) return arr
    
        val pivot = arr[0]
        val rest = arr.drop(1)
    
        val minorsArr = rest.filter { it <= pivot }.toIntArray()
        val majorsArr = rest.filter { it > pivot }.toIntArray()
    
        return quickSort(minorsArr) + pivot + quickSort(majorsArr)
    }

    //se quiser se proteger do pior caso, usa a mediana como pivot
    fun medianOfThree(arr: IntArray): Int {
        val first = arr[0]
        val middle = arr[arr.size / 2]
        val last = arr[arr.size - 1]
    
        return listOf(first, middle, last).sorted()[1]
    }

     /************************ 5- BFS (Busca em Largura) *****************************
    * usado para percorrer ou buscar elementos em um grafo ou árvore, explorando primeiro os nós mais próximos do ponto inicial.
    * Tempo:O(V + E).   V = vertice e A = arestas
    * Vantagem: Ideal para problemas de distância mínima em grafos não ponderados, simples
    * Desvantagens: Usa mais memória, Não funciona bem para grafos muito grandes ou infinitos
    * Visualização: https://www.youtube.com/shorts/umHJzlKFGlU
    */

    fun bfs(graph: Map<Int, List<Int>>, start: Int) {
        val visited = mutableSetOf<Int>()
        val queue: ArrayDeque<Int> = ArrayDeque()
    
        visited.add(start)
        queue.add(start)
    
        while (queue.isNotEmpty()) {
            val node = queue.removeFirst()
            println(node)
    
            for (neighbor in graph[node] ?: emptyList()) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor)
                    queue.add(neighbor)
                }
            }
        }
    }

    val graph = mapOf(
        1 to listOf(2, 3),
        2 to listOf(4),
        3 to listOf(5),
        4 to emptyList(),
        5 to emptyList()
    )
    
    bfs(graph, 1)

    

    /************************ P1-Dividir para Conquistar *****************************
    * Resolve um problema grande quebrando ele em partes menores, resolve cada parte separadamente e depois combina os resultados.
    * 
    */
  
    
  }
