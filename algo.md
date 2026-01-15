# Algoritmos
### Classes de Problemas
**P (Polynomial Time):** fácil de resolver, fácil de verificar se está certo<br>
**NP (Nondeterministic Polynomial Time):** resolver é difícil, mas conferir é fácil.<br>
**NP-Completo:** NP-Completo é um NP, resolver é difícil e conferir é fácil, mas o mais difícil. Você tem vários problemas difíceis, o mais difícil de todos é o NP-Completo. <br>
**NP-Difícil:** Às vezes nem dá pra conferir se a resposta está certa, pode nem ter resposta clara
## 🔍 Algoritmos de Busca 
### Busca Linear (Linear Search)

### Busca Binária (Binary Search)
Posicao do meio como referencia e pergunta se é maior ou menos que o meio. Tem que estar ordenado! <br>
**Tempo:** O(log n) <br>
**Visualização:** https://www.youtube.com/shorts/c-PMOD2O7E4 <br>

```kotlin
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
```
### Busca em Profundidade (DFS)
### Busca em Largura (BFS)

## 🔢 Algoritmos de Ordenação
### Bubble Sort
### Selection Sort
Percorre o array procurando o menor elemento, coloca esse menor elemento na posição correta e repete isso para o restante do array<br>
Tempo: O(n²)<br>
Visualização: https://www.youtube.com/shorts/ya176hFz_f8<br>

```kotlin
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
```
### Insertion Sort
### Merge Sort
### Quick Sort
### Heap Sort
### Tim Sort

## 🌐 Algoritmos de Grafos
### BFS
### DFS
### Dijkstra
O algoritmo de Dijkstra é usado para encontrar o menor caminho entre um nó origem e os demais nós de um grafo ponderado, desde que não existam pesos negativos<br>
**Tempo:** O((V + E) log V) ou O(V²)<br>
**Vantagem:** Mapas / GPS, Redes, Sistemas de recomendação, Jogos, Roteamento<br>
**Desvantagens:** Se houver pesos negativos → use Bellman-Ford, Se o grafo for muito pequeno → solução simples funciona<br>
**Visualização:** https://www.youtube.com/watch?v=IIZOWRwKa_Q<br>

```kotlin
import java.util.PriorityQueue
    
    data class Edge(val to: Int, val weight: Int)
    
    fun dijkstra(
        graph: List<List<Edge>>,
        start: Int
    ): IntArray {
    
        val n = graph.size
        val dist = IntArray(n) { Int.MAX_VALUE }
        dist[start] = 0
    
        val pq = PriorityQueue(compareBy<Pair<Int, Int>> { it.second })
        pq.add(start to 0)
    
        while (pq.isNotEmpty()) {
            val (node, currentDist) = pq.poll()
    
            if (currentDist > dist[node]) continue
    
            for (edge in graph[node]) {
                val newDist = currentDist + edge.weight
    
                if (newDist < dist[edge.to]) {
                    dist[edge.to] = newDist
                    pq.add(edge.to to newDist)
                }
            }
        }
    
        return dist
    }

    val graph = listOf(
        listOf(Edge(1, 4), Edge(2, 1)), // nó 0
        listOf(Edge(3, 1)),            // nó 1
        listOf(Edge(1, 2), Edge(3, 5)), // nó 2
        emptyList()                    // nó 3
    )
    
    val result = dijkstra(graph, 0)
    println(result.toList()) // [0, 3, 1, 4]
```


### Bellman-Ford
### A*
### Kruskal
### Prim
### Topological Sort

## 🧠 Programação Dinâmica
### Fibonacci (DP)
### Knapsack (0/1)
### Longest Common Subsequence (LCS)
### Longest Increasing Subsequence (LIS)
### Edit Distance (Levenshtein)
### Coin Change

## ⚡Algoritmos Gulosos (Greedy)
### Activity Selection
### Interval Scheduling
### Huffman Coding
### Kruskal
### Prim
### Coin Change (versão gulosa)

## 📐 Algoritmos de Aproximação
### Vertex Cover (2-approx)
Qual é o MENOR conjunto possível de vértices que cobre todas as arestas? <br>
1. Pegue uma aresta qualquer
2. Coloque os dois vértices dessa aresta no conjunto
3. Remova todas as arestas ligadas a eles
4. Repita até não sobrar arestas
   
Complexidade: NP-Completo<br>
Visualização: https://www.youtube.com/shorts/4lVbBPXAoq4<br>

```kotlin
data class Edge(val u: Int, val v: Int)
fun vertexCoverApproximation(edges: MutableList<Edge>): Set<Int> {
    val cover = mutableSetOf<Int>()

    while (edges.isNotEmpty()) {
        // pega uma aresta qualquer
        val edge = edges.removeAt(0)

        val u = edge.u
        val v = edge.v

        // adiciona os dois vértices
        cover.add(u)
        cover.add(v)

        // remove todas as arestas ligadas a u ou v
        edges.removeIf { it.u == u || it.v == u || it.u == v || it.v == v }
    }

    return cover
}

fun main() {
    val edges = mutableListOf(
        Edge(1, 2),
        Edge(1, 3),
        Edge(2, 4),
        Edge(3, 4)
    )

    val cover = vertexCoverApproximation(edges)
    println("Vertex Cover aproximado: $cover")
}
```

### Set Cover
### Traveling Salesman (TSP – aproximação)
### Knapsack Approximation

## 🧱 Hashing e Estruturas Relacionadas
### Hash Table
### Open Addressing
### Separate Chaining
### Consistent Hashing

---

    /************************ 2- Ordenação por Seleção *****************************

    */
    

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

    /************************ 6- Dijkstra Algorithm *****************************
    
    */

    



    /************************ P1-Dividir para Conquistar *****************************
    * Resolve um problema grande quebrando ele em partes menores, resolve cada parte separadamente e depois combina os resultados.
    * 
    */
  
    
  }
