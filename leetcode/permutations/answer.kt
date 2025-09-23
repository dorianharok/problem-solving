class Solution {
    fun permute(nums: IntArray): List<List<Int>> {
        var arr = IntArray(nums.size)
        var visited = BooleanArray(nums.size)
        var list = mutableListOf<MutableList<Int>>()

        fun dfs(depth: Int) {
            if(depth == nums.size) {
                list.add(arr.toMutableList())
                return
            }

            for(i in 0 until nums.size) {
                if(visited[i]) continue

                arr[depth] = nums[i]
                visited[i] = true
                dfs(depth + 1)
                visited[i] = false
                arr[depth] = 0
            }
        }

        dfs(0)

        return list
    }
}