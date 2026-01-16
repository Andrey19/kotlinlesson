fun main(args: Array<String>) {
    gradient1()
}

fun gradient1() {
    val input = readLine()!!.split(" ").map { it.toInt() }
    val w = input[0]
    val h = input[1]

    var rowSum = LongArray(h){ 0 }
    var countSum = LongArray(w){ 0 }

    for (row in 0 until h){
        for (count in 0 until w){
            val a = (row + 1).toLong() * (count + 1).toLong()
            val b = (h - row).toLong() * (w - count).toLong()
            val result = a * b
            rowSum[row] += result
            countSum[count] += result
        }
    }

    println(rowSum.joinToString(separator = " ") { it.toString() })
    println(countSum.joinToString(separator = " ") { it.toString() })


}