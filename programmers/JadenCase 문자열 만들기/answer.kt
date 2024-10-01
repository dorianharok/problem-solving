class Solution {
    fun solution(s: String): String {
        return s.split(" ")
            .map { it.lowercase() }
            .map { it -> it.replaceFirstChar { it.uppercase() } }
            .joinToString(separator = " ")
    }
}