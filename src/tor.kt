fun main(args: Array<String>) {

    val (n, m) = readLine()!!.trim().split(" ").map{ it.toInt() }

    val (startRow,startCol,endRow, endCol) = readLine()!!.trim().split(" ").map{ it.toInt() }

    val graph = Array(n) { IntArray(m) }
    repeat(n) { i ->
        graph[i] = readLine()!!.trim().split(" ").map { it.toInt() }.toIntArray()
    }

    val start = Pair(startRow, startCol)
    val end = Pair(endRow,endCol)


//    // SSSWWSSESESEEEEEEEE
//    val n = 10
//    val m = 10
//    val start = Pair(1, 0)
//    val end = Pair(8,8)
//    val array = arrayOf(
//        arrayOf(1, 0, 1, 0, 0, 0, 0, 0, 0, 1),
//        arrayOf(0, 0, 0, 0, 1, 0, 0, 1, 0, 0),
//        arrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
//        arrayOf(0, 0, 0, 1, 0, 0, 1, 1, 0, 0),
//        arrayOf(0, 0, 1, 0, 0, 0, 0, 0, 0, 0),
//        arrayOf(1, 0, 0, 0, 0, 0, 0, 0, 0, 1),
//        arrayOf(1, 0, 0, 0, 0, 0, 0, 0, 0, 0),
//        arrayOf(0, 1, 1, 1, 1, 1, 1, 1, 1, 0),
//        arrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 1),
//        arrayOf(1, 1, 1, 1, 1, 1, 1, 1, 1, 1)
//    )

    val shortWay = findShortWay(n, m, start, end, graph)
    println(shortWay)
}

fun findShortWay(n: Int, m : Int, start: Pair<Int, Int>, end: Pair<Int, Int>, array: Array<IntArray>): String {
    val isV = Array(n) { Array(m) { false } }
    val q = ArrayDeque<Pair<Pair<Int, Int>, String>>()
    q.add(Pair(start, ""))
    isV[start.first][start.second] = true

    while (!q.isEmpty()) {
        val next = q.removeFirst()

        if (next.first == end) return next.second
        val cur = next.first
        var up = cur.first - 1
        if (up < 0) up = n - 1
        var down = cur.first + 1
        if (down >= n) down = 0
        var left = cur.second - 1
        if (left < 0) left = m- 1
        var right = cur.second + 1
        if (right >= n) right = 0

        if (array[up][cur.second] == 0 && !isV[up][cur.second]) {
            isV[up][cur.second] = true
            q.add(Pair(Pair(up, cur.second), next.second.plus("N")))
        }
        if (array[down][cur.second] == 0 && !isV[down][cur.second]) {
            isV[down][cur.second] = true
            q.add(Pair(Pair(down, cur.second), next.second.plus("S")))
        }
        if (array[cur.first][left] == 0 && !isV[cur.first][left]) {
            isV[cur.first][left] = true
            q.add(Pair(Pair(cur.first, left), next.second.plus("W")))
        }
        if (array[cur.first][right] == 0 && !isV[cur.first][right]) {
            isV[cur.first][right] = true
            q.add(Pair(Pair(cur.first, right), next.second.plus("E")))
        }

    }

    return ""
}