class Solution {
    fun numJewelsInStones(jewels: String, stones: String): Int {
        val jewel = HashMap<Char, Boolean>()
        for(j in jewels) {
            jewel[j] = true
        }

        var answer = 0
        for(s in stones) {
            if(jewel.contains(s)) {
                answer++
            }
        }

        return answer
    }
}