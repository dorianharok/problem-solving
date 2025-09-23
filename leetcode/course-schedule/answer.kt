class Solution {
    fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
        val indegree = IntArray(numCourses)
        val adj = Array(numCourses) { mutableListOf<Int>() }

        for(pre in prerequisites) {
            val c = pre[0]
            val n = pre[1]

            adj[n].add(c)
            indegree[c]++
        }

        val q = ArrayDeque<Int>()
        for(i in indegree.indices) {
            if(indegree[i] == 0) {
                q.add(i)
            }
        }

        var count = 0
        while(q.isNotEmpty()) {
            val current = q.removeFirst()
            count++

            for(i in adj[current]) {
                indegree[i]--
                if(indegree[i] == 0) {
                    q.add(i)
                }
            }
        }

        if(count == numCourses) {
            return true
        } else {
            return false
        }
    }
}