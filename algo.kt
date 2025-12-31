/*************** Algoritmos *************************
* 1- Binary Search
*/

fun main() {
    /************************ 1- Binary Search *****************************
    * Posicao do meio como referencia e pergunta se é maior ou menos que o meio. Tem que estar ordenado
    * Tempo: O(log n)
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
  
    /************************ 2-  *****************************
    * uma coleção ordenada de elementos
    *
    */
  
    
  }
