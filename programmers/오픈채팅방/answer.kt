class Solution {
    companion object {
        val ENTER = "Enter"
        val LEAVE = "Leave"
        val CHANGE = "Change"
    }

    fun solution(record: Array<String>): Array<String> {
        val map = HashMap<String, String>()
        val log = ArrayList<String>()

        for (r in record) {
            val split = r.split(" ")
            val command = split[0]
            val id = split[1]

            when (command) {
                ENTER -> {
                    map[id] = split[2]
                    log.add("$command $id")
                }
                LEAVE -> {
                    log.add("$command $id")
                }
                else -> {
                    map[id] = split[2]
                }
            }
        }

        val answer = ArrayList<String>()
        for(l in log) {
            val split = l.split(" ")
            val command = split[0]
            val nickname = map[split[1]]

            when (command) {
                ENTER -> {
                    answer.add("${nickname}님이 들어왔습니다.")
                }
                else -> {
                    answer.add("${nickname}님이 나갔습니다.")
                }
            }
        }

        return answer.toTypedArray()
    }
}