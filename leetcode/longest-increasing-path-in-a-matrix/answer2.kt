class Solution {
    lateinit var dp: Array<IntArray>
    val dx = intArrayOf(-1, 0, 1, 0)
    val dy = intArrayOf(0, -1, 0, 1)

    fun longestIncreasingPath(matrix: Array<IntArray>): Int {
        dp = Array(matrix.size) { IntArray(matrix[0].size) }

        var max = 1
        for(i in matrix.indices) {
            for(j in matrix[0].indices) {
                max = max(max, dfs(i, j, matrix))
            }
        }

        return max
    }

    fun dfs(x: Int, y: Int, matrix: Array<IntArray>): Int {
        if(dp[x][y] > 0) {
            return dp[x][y]
        }

        var currentMax = 1
        for(i in 0 until 4) {
            val nx = x + dx[i]
            val ny = y + dy[i]

            if(nx < 0 || ny < 0 || nx >= dp.size || ny >= dp[0].size) continue
            if(matrix[nx][ny] <= matrix[x][y]) continue

            val len = 1 + dfs(nx, ny, matrix)
            currentMax = max(currentMax, len)
        }

        dp[x][y] = currentMax
        return currentMax
    }
}