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
    var length = 0
    val list = mutableListOf<String>()

    fun letterCombinations(digits: String): List<String> {
        if(digits.isEmpty()) {
            return list
        }

        length = digits.length

        dfs(0, digits, StringBuilder())

        return list
    }

    fun dfs(depth: Int, digits:String, s: StringBuilder) {
        if(depth == length) {
            list.add(s.toString())
            return
        }

        val key = digits[depth]
        for(digit in keypad.get(key)!!) {
            dfs(depth + 1, digits, StringBuilder(s).append(digit))
        }
    }
}