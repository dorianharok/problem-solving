class Solution {
    fun smallestEvenMultiple(n: Int): Int {
        return n + (n % 2) * n
    }
}