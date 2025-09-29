class Solution {
    fun nextGreatestLetter(letters: CharArray, target: Char): Char {
        var l = 0
        var r = letters.size - 1

        while(l < r) {
            val mid = l + (r - l) / 2

            if(letters[mid] > target) {
                r = mid
            } else {
                l = mid + 1
            }
        }

        return if(letters[l] > target) letters[l] else letters[0]
    }
}