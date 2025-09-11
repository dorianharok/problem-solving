class Solution {
    lateinit var graph: MutableList<ArrayList<Int>>
    lateinit var visited: BooleanArray

    fun solution(n: Int, computers: Array<IntArray>): Int {
        graph = MutableList(computers.size) { ArrayList() }
        for(i in computers.indices) {
            for(j in i + 1 until computers[i].size) {
                if(computers[i][j] == 1) {
                    graph[i].add(j)
                    graph[j].add(i)
                }
            }
        }

        visited = BooleanArray(computers.size)

        var answer = 0
        for(i in computers.indices) {
            if(visited[i]) continue;

            visited[i] = true
            dfs(i)
            answer++
        }
        return answer
    }

    fun dfs(n: Int) {
        for(i in graph[n]) {
            if(visited[i]) continue;

            visited[i] = true
            dfs(i)
        }
    }
}