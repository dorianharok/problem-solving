class Solution {
    fun mostCommonWord(paragraph: String, banned: Array<String>): String {
        val arr = paragraph.replace("\\W+".toRegex(), " ").lowercase().trim().split(" ")

        val key = arr
            .filter { !banned.contains(it) }
            .groupingBy { it }
            .eachCount()
            .maxBy { it.value }.key

        return key
    }
}