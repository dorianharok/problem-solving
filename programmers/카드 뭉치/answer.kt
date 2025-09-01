import java.util.*

class Solution {
    fun solution(cards1: Array<String>, cards2: Array<String>, goal: Array<String>): String {
        val q1 = ArrayDeque(cards1.toList())
        val q2 = ArrayDeque(cards2.toList())

        for(s in goal) {
            if(s == q1.peek()) {
                q1.poll()
            } else if (s == q2.peek()) {
                q2.poll()
            } else {
                return "No"
            }
        }

        return "Yes"
    }
}