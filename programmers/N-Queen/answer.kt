import java.util.*

class Solution {
    lateinit var chess: IntArray
    var N = 0
    var answer = 0
    fun solution(n: Int): Int {
        chess = IntArray(n)
        N = n

        bt(0)

        return answer
    }

    fun bt(depth: Int) {
        if(depth == N) {
            answer++
            return
        }

        for(i in 0 until N) {
            chess[depth] = i
            if(!validate(depth)) continue
            bt(depth + 1)
        }
    }

    fun validate(depth: Int): Boolean {
        for(i in 0 until depth) {
            if(chess[i] == chess[depth]) {
                return false
            }

            if(Math.abs(i - depth) == Math.abs(chess[i] - chess[depth])) {
                return false
            }
        }

        return true
    }
}