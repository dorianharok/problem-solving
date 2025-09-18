class Solution {
    var set = HashSet<String>()

    fun ladderLength(beginWord: String, endWord: String, wordList: List<String>): Int {
        val q = ArrayDeque<Pair<String,Int>>()
        q.add(Pair(beginWord, 1))
        set.add(beginWord)

        while(q.isNotEmpty()) {
            val (cur, cnt) = q.removeFirst()

            if(cur == endWord) {
                return cnt
            }

            for (word in wordList) {
                if(!validate(cur, word)) continue

                set.add(word)
                q.add(Pair(word, cnt + 1))
            }
        }

        return 0
    }

    fun validate(a: String, b: String): Boolean {
        if(set.contains(b)) {
            return false
        }

        var count = 0

        for(i in 0 until a.length) {
            if(a[i] != b[i]) {
                count++
                if(count > 1) {
                    return false
                }
            }
        }

        return count == 1
    }
}