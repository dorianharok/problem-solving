class Solution {
    fun containsDuplicate(nums: IntArray): Boolean {
        val m = hashMapOf<Int, Boolean>()

        for (n in nums) {
            val b = m.getOrDefault(n, false)
            if(b) {
                return true
            }
            m.put(n, true)
        }

        return false
    }
}