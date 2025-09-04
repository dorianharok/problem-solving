class Solution {
    lateinit var parent: IntArray

    fun findCircleNum(isConnected: Array<IntArray>): Int {
        val n = isConnected.size
        parent = IntArray(n)

        for (i in 0 until n) {
            parent[i] = i
        }

        for (i in 0 until n) {
            for (j in i + 1 until n) {
                if (isConnected[i][j] == 1) {
                    union(i, j)
                }
            }
        }

        var provinceCount = 0
        for (i in 0 until n) {
            if (parent[i] == i) {
                provinceCount++
            }
        }
        return provinceCount
    }

    fun find(x: Int): Int {
        if (parent[x] == x) return x
        parent[x] = find(parent[x])
        return parent[x]
    }

    fun union(x: Int, y: Int) {
        val rootX = find(x)
        val rootY = find(y)
        if (rootX != rootY) {
            parent[rootY] = rootX
        }
    }
}