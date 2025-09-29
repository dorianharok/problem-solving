class Solution {
    lateinit var parent: IntArray
    fun validPath(n: Int, edges: Array<IntArray>, source: Int, destination: Int): Boolean {
        parent = IntArray(n){ it }

        for((u, v) in edges) {
            union(u, v)
        }

        return find(source) == find(destination)
    }

    fun union(u: Int, v: Int) {
        val a = find(u)
        val b = find(v)

        when {
            a > b -> parent[a] = b
            else -> parent[b] = a
        }
    }

    fun find(x: Int): Int {
        if(x != parent[x]) {
            parent[x] = find(parent[x])
        }

        return parent[x]
    }
}