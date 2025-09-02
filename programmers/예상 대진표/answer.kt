class Solution {
    fun solution(n: Int, a: Int, b: Int): Int {
        var answer = 0
        var aa = a
        var bb = b

        while(aa != bb) {
            aa = (aa + 1) / 2
            bb = (bb + 1) / 2
            answer++
        }

        return answer
    }
}