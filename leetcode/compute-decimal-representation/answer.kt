class Solution {
    fun decimalRepresentation(n: Int): IntArray {
        val list = mutableListOf<Int>()

        var nn = n
        var digit = 1
        while(nn != 0) {
            if(nn % 10 == 0) {
                digit *= 10
                nn /= 10
                continue
            }

            list.add(nn % 10 * digit)
            nn /= 10
            digit *= 10
        }

        list.reverse()
        return list.toIntArray()
    }
}