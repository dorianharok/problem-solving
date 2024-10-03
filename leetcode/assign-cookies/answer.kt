class Solution {
    fun findContentChildren(g: IntArray, s: IntArray): Int {
        Arrays.sort(g)
        Arrays.sort(s)

        var index = s.lastIndex
        var answer = 0
        for(i in g.reversed()) {
            if(index < 0) {
                return answer
            }

            if(s[index] < i) {
                continue
            }

            index--
            answer++
        }

        return answer
    }
}