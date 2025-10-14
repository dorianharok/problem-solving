class Solution {
    lateinit var dp: Array<IntArray>
    val dx = intArrayOf(-1, 0, 1, 0)
    val dy = intArrayOf(0, -1, 0, 1)
    var max = 1

    fun longestIncreasingPath(matrix: Array<IntArray>): Int {
        dp = Array(matrix.size) { IntArray(matrix[0].size) }

        for(i in matrix.indices) {
            for(j in matrix[0].indices) {
                if(dp[i][j] >= 1) continue

                dp[i][j] = 1
                dfs(i, j, 1, matrix)
            }
        }

        return max
    }

    fun dfs(x: Int, y: Int, count: Int, matrix: Array<IntArray>) {
        for(i in 0 until 4) {
            val nx = x + dx[i]
            val ny = y + dy[i]

            if(nx < 0 || ny < 0 || nx >= dp.size || ny >= dp[0].size) continue
            if(matrix[nx][ny] <= matrix[x][y]) continue
            if(dp[nx][ny] >= count + 1) continue

            dp[nx][ny] = count
            max = max(max, count + 1)
            dfs(nx, ny, count + 1, matrix)
        }
    }
}