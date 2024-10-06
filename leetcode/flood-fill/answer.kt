class Solution {
    fun floodFill(image: Array<IntArray>, sr: Int, sc: Int, color: Int): Array<IntArray> {
        val dx = intArrayOf(-1, 0, 1, 0)
        val dy = intArrayOf(0, -1, 0, 1)
        val visited = Array(image.size) { BooleanArray(image[0].size) { false } }

        val q = ArrayDeque<IntArray>()
        val target = image[sr][sc]
        q.add(intArrayOf(sr, sc))
        visited[sr][sc] = true
        image[sr][sc] = color
        while(!q.isEmpty()) {
            val (x, y) = q.removeFirst()
            for (i in 0 until 4) {
                val nx = x + dx[i]
                val ny = y + dy[i]

                if(nx < 0 || ny < 0 || nx >= image.size || ny >= image[0].size || image[nx][ny] != target || visited[nx][ny]) {
                    continue
                }

                image[nx][ny] = color
                visited[nx][ny] = true
                q.add(intArrayOf(nx, ny))
            }
        }

        return image
    }
}