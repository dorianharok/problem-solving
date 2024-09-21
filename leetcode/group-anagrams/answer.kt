class Solution {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        return strs.groupBy {
                str -> str.toCharArray().sorted().joinToString("")
        }.values.toList()
    }
}