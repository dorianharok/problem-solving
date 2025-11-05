class Solution {
    fun isIsomorphic(s: String, t: String): Boolean {
        val map1 = HashMap<Char, Char>()
        val map2 = HashMap<Char, Char>()

        for(i in 0 until s.length) {
            val c1 = s[i]
            val c2 = t[i]

            if(map1.contains(c1) && map1[c1] != c2) return false
            if(map2.contains(c2) && map2[c2] != c1) return false

            map1[c1] = c2
            map2[c2] = c1
        }

        return true
    }
}