class Solution {
    fun solution(board: Array<IntArray>, skill: Array<IntArray>): Int {
        val arr = Array(board.size+1) { IntArray(board[0].size+1) {0} }

        for (s in skill) {
            if(s[0] == 1) {
                attack(arr, s)
            } else {
                heal(arr, s)
            }
        }

        sum(arr)

        var answer = 0
        for (i in board.indices) {
            for (j in board[i].indices) {
                board[i][j] += arr[i][j]
                if(board[i][j] > 0) {
                    answer++
                }
            }
        }
        return answer
    }

    private fun Array<IntArray>.applySkill(skill: IntArray, isAttack: Boolean) {
        val (_, r1, c1, r2, c2, degree) = skill
        val impact = if (isAttack) -degree else degree
        this[r1][c1] += impact
        this[r2 + 1][c2 + 1] += impact
        this[r2 + 1][c1] -= impact
        this[r1][c2 + 1] -= impact
    }

    fun attack(arr: Array<IntArray>, skill: IntArray) {
        val r1 = skill[1]
        val c1 = skill[2]
        val r2 = skill[3]
        val c2 = skill[4]
        val degree = skill[5]

        arr[r1][c1] -= degree
        arr[r2+1][c2+1] -= degree
        arr[r2+1][c1] += degree
        arr[r1][c2+1] += degree
    }

    fun heal(arr: Array<IntArray>, skill: IntArray) {
        val r1 = skill[1]
        val c1 = skill[2]
        val r2 = skill[3]
        val c2 = skill[4]
        val degree = skill[5]

        arr[r1][c1] += degree
        arr[r2+1][c2+1] += degree
        arr[r2+1][c1] -= degree
        arr[r1][c2 + 1] -= degree
    }

    fun sum(arr: Array<IntArray>) {
        for(i in 0..arr.size-1) {
            for(j in 1..arr[i].size-1) {
                arr[i][j] += arr[i][j-1]
            }
        }

        for(i in 0..arr[0].size-1) {
            for(j in 1..arr.size-1) {
                arr[j][i] += arr[j-1][i]
            }
        }
    }
}