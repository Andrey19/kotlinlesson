//fun main(args: Array<String>) {
//    gradient()
//}



fun gradient() {
    val input = readLine()!!.split(" ").map { it.toInt() }
    val w = input[0]
    val h = input[1]

    val rowIntensity = Array(h) { 0 }
    val columnIntensity = Array(w) { 0 }

    for (row in 0 until h) {
        for (column in 0 until w) {
            val top = (row + 1) * (column + 1)
            val bottom = (h - row) * (w - column)
            val intensity = top * bottom
            rowIntensity[row] += intensity
            columnIntensity[column] += intensity
        }
    }

    println(rowIntensity.joinToString(" ") { it.toString() })
    println(columnIntensity.joinToString(" ") { it.toString() })
}