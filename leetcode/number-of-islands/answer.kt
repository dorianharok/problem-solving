class Solution {
    val dx = arrayOf(0, -1, 0, 1)
    val dy = arrayOf(-1, 0, 1, 0)

    fun numIslands(grid: Array<CharArray>): Int {
        var answer = 0
        for (i in grid.indices) {
            for (j in grid[0].indices) {
                if (grid[i][j] != '1') continue

                bfs(grid, i, j)
                answer++
            }
        }

        return answer
    }

    fun bfs(grid: Array<CharArray>, i: Int, j: Int) {
        val q = ArrayDeque<IntArray>()
        grid[i][j] = '0'
        q.add(intArrayOf(i, j))

        while(!q.isEmpty()) {
            val (x, y) = q.removeFirst()
            for(i in 0 until 4) {
                val nx = x + dx[i]
                val ny = y + dy[i]

                if(!validate(nx, ny, grid.size, grid[0].size)) continue
                if(grid[nx][ny] != '1') continue

                grid[nx][ny] = '0'
                q.add(intArrayOf(nx, ny))
            }
        }
    }

    fun validate(x:Int, y: Int, row: Int, col: Int): Boolean {
        if(x < 0 || y < 0 || x >= row || y >= col) {
            return false
        }

        return true
    }
}