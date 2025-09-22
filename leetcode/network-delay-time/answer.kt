class Solution {
    fun networkDelayTime(times: Array<IntArray>, n: Int, k: Int): Int {
        val visited = BooleanArray(n + 1)
        val distances = IntArray(n + 1) { Int.MAX_VALUE }
        val pq = PriorityQueue<GraphNode>()

        val graph = Array(n + 1) { mutableListOf<GraphNode>() }
        for(t in times) {
            graph[t[0]].add(GraphNode(t[1], t[2]))
        }

        distances[k] = 0
        pq.offer(GraphNode(k, 0))

        while(pq.isNotEmpty()) {
            val current = pq.poll()
            val vertex = current.vertex
            val distance = current.distance

            if(visited[vertex]) continue
            visited[vertex] = true

            for(edge in graph[vertex]) {
                val newDist = distances[vertex] + edge.distance
                if(newDist < distances[edge.vertex]) {
                    distances[edge.vertex] = newDist
                    pq.offer(GraphNode(edge.vertex, distances[edge.vertex]))
                }
            }
        }

        var max = 0
        for(i in 1..n) {
            if(distances[i] == Int.MAX_VALUE) {
                return -1
            }
            max = maxOf(max, distances[i])
        }

        return max
    }
}

data class GraphNode(val vertex: Int, val distance: Int) : Comparable<GraphNode> {
    override fun compareTo(other: GraphNode): Int = this.distance - other.distance
}