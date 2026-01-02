/*************** Algoritmos *************************
* 1- Binary Search
* 2- Ordenação por Seleção
* 3- Recursão
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
  
    
  }
