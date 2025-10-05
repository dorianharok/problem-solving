class Solution {
    companion object {
        val dx = intArrayOf(0, 1, 0, -1)
        val dy = intArrayOf(1, 0, -1, 0)
    }

    fun getMaximumGold(grid: Array<IntArray>): Int {
        var answer = 0

        for(i in 0 until grid.size) {
            for(j in 0 until grid[i].size) {
                if(grid[i][j] != 0) {
                    val gold = bt(i, j, grid)
                    answer = maxOf(answer, gold)
                }
            }
        }

        return answer
    }

    fun bt(x: Int, y: Int, grid: Array<IntArray>): Int {
        val currentGold = grid[x][y]
        grid[x][y] = 0

        var max = 0
        for(i in 0 until 4) {
            val nx = x + dx[i]
            val ny = y + dy[i]

            if(nx < 0 || ny < 0 || nx >= grid.size || ny >= grid[0].size || grid[nx][ny] == 0) {
                continue
            }

            max = maxOf(max, bt(nx, ny, grid))
        }

        grid[x][y] = currentGold

        return currentGold + max
    }
}