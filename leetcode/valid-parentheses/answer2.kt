class Solution {
    fun isValid(s: String): Boolean {
        val stack: ArrayDeque<Char> = ArrayDeque()

        val table = mapOf(
            ')' to '(',
            ']' to '[',
            '}' to '{'
        )

        for(ch in s) {
            if (!table.contains(ch)) {
                stack.addLast(ch)
            } else if(stack.isEmpty() || table[ch] != stack.removeLast()) {
                return false
            }
        }

        return stack.isEmpty()
    }
}