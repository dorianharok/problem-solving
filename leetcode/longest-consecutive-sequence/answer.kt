class Solution {
    fun longestConsecutive(nums: IntArray): Int {
        if (nums.size == 0) return 0

        val uf = UnionFind()
        val numSet = HashSet<Int>()

        for(num in nums) {
            if(numSet.add(num)) {
                uf.add(num)
            }
        }

        for(num in nums) {
            if (uf.contains(num + 1)) {
                uf.union(num, num + 1)
            }

            if (uf.contains(num - 1)) {
                uf.union(num, num -1)
            }
        }

        println(uf.parents)
        println(uf.size)

        return uf.getMaxSize()
    }
}

class UnionFind {
    val parents = HashMap<Int, Int>()
    val size = HashMap<Int, Int>()

    fun add(num: Int) {
        parents[num] = num
        size[num] = 1
    }

    fun find(x: Int): Int {
        if(!parents.containsKey(x)) {
            return -1
        }

        if(parents[x] == x) {
            return x
        }

        parents[x] = find(parents[x]!!)
        return parents[x]!!
    }

    fun union(x: Int, y: Int) {
        val rootX = find(x)
        val rootY = find(y)

        if(rootX == rootY) {
            return
        }

        if (size.get(rootX)!! < size.get(rootY)!!) {
            parents[rootX] = rootY
            size[rootY] = size.get(rootX)!! + size.get(rootY)!!
        } else {
            parents[rootY] = rootX
            size[rootX] = size.get(rootX)!! + size.get(rootY)!!
        }
    }

    fun getMaxSize(): Int {
        var maxSize = 0
        for (s in size.values) {
            maxSize = Math.max(maxSize, s)
        }
        return maxSize
    }

    fun contains(num: Int): Boolean {
        return parents.containsKey(num)
    }
}