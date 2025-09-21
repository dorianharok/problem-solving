class Solution {
    companion object {
        val dx = intArrayOf(0, 1, 0, -1)
        val dy = intArrayOf(1, 0, -1, 0)
    }

    fun spiralOrder(matrix: Array<IntArray>): List<Int> {
        val list = mutableListOf<Int>()
        val n = matrix.size
        val m = matrix[0].size

        var x = 0
        var y = 0
        var dir = 0

        for(i in 1 .. n * m) {
            list.add(matrix[x][y])
            matrix[x][y] = -101

            val nx = x + dx[dir]
            val ny = y + dy[dir]

            if(nx < 0 || ny < 0 || nx >= n || ny >= m || matrix[nx][ny] == -101) {
                dir = (dir + 1) % 4
            }

            x = x + dx[dir]
            y = y + dy[dir]
        }

        return list
    }
}