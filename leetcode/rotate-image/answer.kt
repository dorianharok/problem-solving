class Solution {
    fun rotate(matrix: Array<IntArray>): Unit {
        val map = matrix.map { it.copyOf() }

        for(i in matrix.indices) {
            for(j in matrix[0].indices) {
                matrix[i][j] = map[matrix.size - 1 - j][i]
            }
        }
    }
}