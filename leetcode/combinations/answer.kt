class Solution {
    fun combine(n: Int, k: Int): List<List<Int>> {
        val arr = IntArray(k)
        val list = mutableListOf<MutableList<Int>>()

        fun dfs(depth: Int, start: Int) {
            if(depth == k) {
                list.add(arr.toMutableList())
                return
            }

            for(i in start .. n) {
                arr[depth] = i
                dfs(depth + 1, i + 1)
                arr[depth] = 0
            }
        }

        dfs(0, 1)

        return list
    }
}