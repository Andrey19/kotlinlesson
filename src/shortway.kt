
fun main(args: Array<String>) {
    val n = readLine()!!.toInt()

    val graph = Array(n) { IntArray(n) }
    repeat(n) { i ->
        graph[i] = readLine()!!.trim().split(" ").map { it.toInt() }.toIntArray()
    }
1
    val (start, end) = readLine()!!.trim().split(" ").map{ it.toInt() - 1}

    fun bfs(graph: Array<IntArray>, start: Int, end: Int): Int {
        val q = ArrayDeque<Pair<Int, Int>>()
        q.add(Pair(start, 0))
        val visited = BooleanArray(n){false}
        visited[start] = true

        while(q.isNotEmpty()){
            val (current, len) = q.removeFirst()
            if (current == end) return len

            for (i in 0 until n){
                if (graph[current][i] == 1 && !visited[i]){
                    visited[i] = true
                    q.add(Pair(i, len.plus(1)))
                }
            }
        }
        return -1
    }
    val rezult = bfs(graph, start, end)
    println(rezult)
}