class Solution {
    val dx = intArrayOf(-1, 0, 1, 0)
    val dy = intArrayOf(0, -1, 0, 1)
    lateinit var visited: Array<BooleanArray>

    fun exist(board: Array<CharArray>, word: String): Boolean {
        visited = Array(board.size) { BooleanArray(board[0].size) }

        for(i in board.indices) {
            for(j in board[0].indices) {
                if(board[i][j] == word[0]) {
                    visited[i][j] = true
                    if(dfs(i, j, 1, board, word)) return true
                    visited[i][j] = false
                }
            }
        }

        return false
    }

    fun dfs(x: Int, y: Int, len: Int, board: Array<CharArray>, word: String): Boolean {
        if(len == word.length) {
            return true
        }

        for(i in 0 until 4) {
            val nx = x + dx[i]
            val ny = y + dy[i]

            if(nx < 0 || ny < 0 || nx >= board.size || ny >= board[0].size) continue
            if(word[len] != board[nx][ny]) continue

            if(!visited[nx][ny]) {
                visited[nx][ny] = true
                if(dfs(nx, ny, len + 1, board, word)) return true
                visited[nx][ny] = false
            }
        }

        return false
    }
}