import java.util.*

class Solution {
    fun solution(topping: IntArray): Int {
        val older = HashMap<Int, Int>()
        val younger = HashSet<Int>()

        for(t in topping) {
            older[t] = older.getOrDefault(t, 0) + 1
        }

        var answer = 0
        for(t in topping) {
            older[t] = older.get(t)!! - 1
            if(older[t] == 0) {
                older.remove(t)
            }
            younger.add(t)

            if(older.size == younger.size) {
                answer++
            }
        }

        return answer
    }
}