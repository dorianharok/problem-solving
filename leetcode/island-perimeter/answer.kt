class Solution {
    val dx = intArrayOf(-1, 0, 1, 0)
    val dy = intArrayOf(0, -1, 0, 1)
    lateinit var visited: Array<BooleanArray>
    var sum = 0

    fun islandPerimeter(grid: Array<IntArray>): Int {
        visited = Array(grid.size) { BooleanArray(grid[0].size) }

        for(i in grid.indices) {
            for(j in grid[i].indices) {
                if(!visited[i][j] && grid[i][j] == 1) {
                    dfs(i, j, grid)
                }
            }
        }

        return sum
    }

    fun dfs(x:Int, y: Int, grid: Array<IntArray>) {
        if(visited[x][y]) return
        visited[x][y] = true
        sum += 4

        for(i in 0 until 4) {
            val nx = x + dx[i]
            val ny = y + dy[i]

            if(nx < 0 || ny < 0 || nx >= grid.size || ny >= grid[0].size || grid[nx][ny] == 0) continue
            sum--

            if(visited[nx][ny]) continue
            dfs(nx, ny, grid)
        }
    }
}