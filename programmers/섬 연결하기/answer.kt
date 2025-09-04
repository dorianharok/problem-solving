class Solution {
    var parent: IntArray? = null

    fun solution(n: Int, costs: Array<IntArray>): Int {
        parent = IntArray(n)

        costs.sortBy { it[2] }

        for(i in 0 until n) {
            parent!![i] = i
        }

        var edges = 0
        var totalCosts = 0

        for(cost in costs) {
            if(edges == n-1) {
                break
            }

            val a = cost[0]
            val b = cost[1]

            if(find(a) != find(b)) {
                union(a, b)
                totalCosts += cost[2]
                edges++
            }
        }

        return totalCosts
    }

    fun find(x: Int): Int {
        if (x == parent!![x]) return x

        return find(parent!![x])
    }

    fun union(x: Int, y: Int) {
        val a = find(x)
        val b = find(y)

        if (a < b) {
            parent!![b] = a
        } else {
            parent!![a] = b
        }
    }
}