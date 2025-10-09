class Solution {
    fun maxNumberOfBalloons(text: String): Int {
        val map = hashMapOf('b' to 1, 'a' to 1, 'l' to 2, 'o' to 2, 'n' to 1)

        val arr = IntArray(26)
        for(t in text) {
            arr[t - 'a']++
        }

        var min = Int.MAX_VALUE
        for((t, need) in map) {
            val count = arr[t - 'a']
            min = min(min, count / need)
        }

        return min
    }
}