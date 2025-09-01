class Solution {
    fun solution(want: Array<String>, number: IntArray, discount: Array<String>): Int {
        val wishlist = HashMap<String, Int>()

        for(i in want.indices) {
            wishlist[want[i]] = number[i]
        }

        var answer = 0
        for(i in discount.indices) {
            if(isSatisfied(discount, wishlist, i)) {
                answer++
            }
        }

        return answer
    }

    fun isSatisfied(discount: Array<String>, wishlist: HashMap<String, Int>, date: Int): Boolean {
        val limit = if(date + 10 > discount.size) discount.size else date + 10
        val map = HashMap<String, Int>()

        for(i in date until limit) {
            map[discount[i]] = map.getOrDefault(discount[i], 0) + 1
        }

        return map == wishlist
    }
}