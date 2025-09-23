class Solution {
    fun findItinerary(tickets: List<List<String>>): List<String> {
        val map = HashMap<String, PriorityQueue<String>>()
        val list = LinkedList<String>()

        for(ticket in tickets) {
            map.putIfAbsent(ticket[0], PriorityQueue<String>())
            map[ticket[0]]!!.offer(ticket[1])
        }

        fun dfs(from: String) {
            while(map.contains(from) && map[from]!!.isNotEmpty()) {
                dfs(map[from]!!.poll())
            }

            list.add(0, from)
        }

        dfs("JFK")

        return list
    }
}