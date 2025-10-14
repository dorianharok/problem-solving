class Solution {
    fun findOrder(numCourses: Int, prerequisites: Array<IntArray>): IntArray {
        val answer = IntArray(numCourses)
        val indegree = IntArray(numCourses)
        val adj = Array(numCourses) { mutableListOf<Int>() }

        for((a, b) in prerequisites) {
            adj[b].add(a)
            indegree[a]++
        }

        val q = ArrayDeque<Int>()
        for((i, v) in indegree.withIndex()) {
            if(v == 0) {
                q.add(i)
            }
        }

        var idx = 0
        while(q.isNotEmpty()) {
            val cur = q.removeFirst()
            answer[idx++] = cur

            for(next in adj[cur]) {
                indegree[next]--

                if(indegree[next] == 0) {
                    q.add(next)
                }
            }
        }

        return if(idx == numCourses) answer else intArrayOf()
    }
}