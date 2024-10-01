class Solution {
    fun dailyTemperatures(temperatures: IntArray): IntArray {
        val answer = IntArray(size = temperatures.size)

        val stack = Stack<Int>()

        for(i in temperatures.indices) {
            while(!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                answer[stack.peek()] = i - stack.pop()
            }

            stack.push(i)
        }

        while(!stack.isEmpty()) {
            answer[stack.pop()] = 0
        }

        return answer
    }
}