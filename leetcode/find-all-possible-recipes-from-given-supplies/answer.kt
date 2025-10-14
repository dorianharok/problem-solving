class Solution {
    fun findAllRecipes(recipes: Array<String>, ingredients: List<List<String>>, supplies: Array<String>): List<String> {
        val indegree = IntArray(recipes.size)
        val adj = HashMap<String, MutableList<Int>>()

        for(i in recipes.indices) {
            for(ing in ingredients[i]) {
                indegree[i]++
                adj.putIfAbsent(ing, mutableListOf<Int>())
                adj[ing]!!.add(i)
            }
        }

        val list = mutableListOf<String>()
        val q = ArrayDeque<String>()
        for(s in supplies) {
            q.add(s)
        }

        while(q.isNotEmpty()) {
            val ingredient = q.removeFirst()

            if(adj[ingredient] == null) continue
            for(idx in adj[ingredient]!!) {
                indegree[idx]--
                if(indegree[idx] == 0) {
                    q.add(recipes[idx])
                    list.add(recipes[idx])
                }
            }
        }

        return list
    }
}