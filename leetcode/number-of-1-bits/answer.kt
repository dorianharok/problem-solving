class Solution {
    fun hammingWeight(n: Int): Int {
        val b = Integer.toBinaryString(n)

        var answer = 0
        for(c in b.toCharArray()) {
            if(c == '1') {
                answer++
            }
        }

        return answer
    }
}