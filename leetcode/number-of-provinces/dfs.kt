class Solution {
    fun findCircleNum(isConnected: Array<IntArray>): Int {
        val n = isConnected.size
        val visited = BooleanArray(n)
        var answer = 0

        fun dfs(x: Int) {
            for(i in isConnected[x].indices) {
                if(x == i) continue;
                if(visited[i]) continue;
                if(isConnected[x][i] != 1) continue;

                visited[i] = true
                dfs(i)
            }
        }

        for(i in 0 until n) {
            if(visited[i]) continue;

            visited[i] = true
            dfs(i)
            answer++
        }

        return answer
    }
}