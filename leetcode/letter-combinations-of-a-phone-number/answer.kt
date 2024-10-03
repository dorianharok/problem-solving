class Solution {
    val keypad: MutableMap<Char, List<Char>> = mutableMapOf(
        '0' to mutableListOf(),
        '1' to mutableListOf(),
        '2' to mutableListOf('a', 'b', 'c'),
        '3' to mutableListOf('d', 'e', 'f'),
        '4' to mutableListOf('g', 'h', 'i'),
        '5' to mutableListOf('j', 'k', 'l'),
        '6' to mutableListOf('m', 'n', 'o'),
        '7' to mutableListOf('p', 'q', 'r', 's'),
        '8' to mutableListOf('t', 'u', 'v'),
        '9' to mutableListOf('w', 'x', 'y', 'z'),
    )
    val answer = mutableListOf<String>()
    fun letterCombinations(digits: String): List<String> {
        if(digits.isEmpty()) {
            return answer
        }

        fun dfs(i: Int, s: StringBuilder) {
            if(i == digits.length) {
                answer.add(s.toString())
                return
            }

            val length = keypad[digits[i]]!!.size
            for(j in 0 until length) {
                dfs(i + 1, StringBuilder(s).append(keypad[digits[i]]!![j]))
            }
        }

        dfs(0, StringBuilder())

        return answer
    }
}