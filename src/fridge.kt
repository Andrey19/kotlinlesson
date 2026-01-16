fun main(args: Array<String>) {

    val (troom, tcond) = readLine()!!.trim().split(" ").map { it.toInt() }
    val temp = readLine().toString()

    when (temp) {
        "freeze" -> if (troom > tcond) println(tcond) else println(troom)
        "heat" -> if (tcond > troom) println(tcond) else println(troom)
        "auto" -> println(tcond)
        "fan" -> println(troom)
    }

}