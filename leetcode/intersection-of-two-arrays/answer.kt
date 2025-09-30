class Solution {
    fun intersection(nums1: IntArray, nums2: IntArray): IntArray {
        val set1 = HashSet<Int>()

        for(num in nums1) {
            set1.add(num)
        }

        val set2 = HashSet<Int>()

        for(num in nums2) {
            if(set1.contains(num)) {
                set2.add(num)
            }
        }

        return set2.toIntArray()
    }
}