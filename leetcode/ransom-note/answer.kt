class Solution {
    fun canConstruct(ransomNote: String, magazine: String): Boolean {
        val arr = IntArray(26)
        for(m in magazine.toCharArray()) {
            arr[m - 'a']++
        }

        for(note in ransomNote.toCharArray()) {
            arr[note - 'a']--
            if(arr[note - 'a'] < 0) {
                return false
            }
        }

        return true
    }
}