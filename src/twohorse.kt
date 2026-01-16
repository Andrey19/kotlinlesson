fun main(args: Array<String>) {

    val (a1, a2) = readLine()!!.trim().split(" ")

    val q = ArrayDeque<Horses>()
    q.add(Horses(0, a1[0].code - 'a'.code, a1[1].code - '0'.code - 1, a2[0].code - 'a'.code, a2[1].code - '0'.code - 1))
    var result = -1

    val myPairArray: Array<Pair<Int, Int>> = arrayOf(
        Pair(-1, -2),
        Pair(-2, -1),
        Pair(-2, 1),
        Pair(-1, 2),
        Pair(1, 2),
        Pair(2, 1),
        Pair(2, -1),
        Pair(1, -2),
    )

    val set = HashSet<Horses>()

    while (!q.isEmpty()) {
        val next = q.removeFirst()
        println(next)
        if (next.redR == next.greenR && next.redC == next.greenC) {
            result = next.moves
            break
        }
        if(!set.contains(next)) {
            set.add(next)
            for (i in 0..7) {
                val red = isPlay(next.redR + myPairArray[i].first, next.redC + myPairArray[i].second)
                if (red == null) continue
                for (j in 0..7) {
                    val green = isPlay(next.greenR + myPairArray[j].first, next.greenC + myPairArray[j].second)
                    if (green == null) continue
                    val h = Horses(next.moves + 1, red.first, red.second, green.first, green.second)
                    if (set.contains(h)) continue
                    q.add(h)
                }
            }
        }
    }
    println(result)

}

data class Horses(
    val moves: Int,
    val redR: Int,
    val redC: Int,
    val greenR: Int,
    val greenC: Int
){
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Horses

        if (redR != other.redR) return false
        if (redC != other.redC) return false
        if (greenR != other.greenR) return false
        if (greenC != other.greenC) return false

        return true
    }

    override fun hashCode(): Int {
        var result = redR
        result = 31 * result + redC
        result = 31 * result + greenR
        result = 31 * result + greenC
        return result
    }
}

fun isPlay(row: Int, col: Int): Pair<Int, Int>? {
    if (row < 0 || col < 0 || row > 7 || col > 7) {
        return null
    }
    return Pair(row, col)
}
