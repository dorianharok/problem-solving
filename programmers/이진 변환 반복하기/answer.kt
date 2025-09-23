class Solution {
    var removed = 0
    fun solution(s: String): IntArray {
        var ss = s
        var count = 0
        while(ss != "1") {
            ss = parse(ss)
            count++
        }

        return intArrayOf(count, removed)
    }

    fun parse(x: String): String {
        var count = 0

        for(i in x) {
            if(i == '1') {
                count++
            }
        }

        removed += x.length - count

        return Integer.toBinaryString(count)
    }
}