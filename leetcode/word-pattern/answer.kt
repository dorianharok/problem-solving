class Solution {
    fun wordPattern(pattern: String, s: String): Boolean {
        val charToString = HashMap<Char, String>()
        val stringToChar = HashMap<String, Char>()

        val arr = s.split(" ")
        if(pattern.length != arr.size) return false

        for(i in 0 until pattern.length) {
            charToString.putIfAbsent(pattern[i], arr[i])
            stringToChar.putIfAbsent(arr[i], pattern[i])

            if(charToString[pattern[i]]!! != arr[i] || stringToChar[arr[i]]!! != pattern[i]) return false
        }

        return true
    }
}