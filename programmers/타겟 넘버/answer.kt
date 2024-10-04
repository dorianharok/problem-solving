class Solution {
    var answer = 0
    fun solution(numbers: IntArray, target: Int): Int {
        dfs(numbers, 0, 0, target)
        return answer
    }

    fun dfs(numbers: IntArray, index: Int, sum: Int, target: Int) {
        if(index == numbers.size) {
            if(target == sum) {
                answer++
            }
            return
        }

        dfs(numbers, index+1, sum + numbers[index], target)
        dfs(numbers, index+1, sum - numbers[index], target)
    }
}