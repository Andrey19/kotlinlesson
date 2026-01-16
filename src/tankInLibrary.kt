//fun main(args: Array<String>) {
//    val input = "str3\n1smth\nbla2bla\n\n"
//    println(orderedArray())
//}

fun orderedArray() {

//    val lines = generateSequence { readLine() }.toList()

    val lines = "str3\n1smth\nbla2bla".split("\n").toList()

    val result = lines
        .map { line ->
            val index = line.filter { it.isDigit() }.toInt()
            val text = line.filter { !it.isDigit() }
            index to text
        }
        .sortedBy { it.first }
        .map { it.second }

    println(result.joinToString("\n"))

//    var input = ""
//    do {
//        val line = readLine()
//        input = input + line + "\n"
//    } while (line != null && !line.isEmpty())
//    input.removeSuffix("\n")
//    val massiv = input.split("\n")
//    val lenghtmassiv = massiv.size
//    val result = Array(lenghtmassiv) { _ -> "" }
//    var numberIndex: String
//    for (s in massiv) {
//        if (!s.isEmpty()) {
//            numberIndex = ""
//            var startIndex = -1
//            for ((index, value) in s.withIndex()) {
//                if (value.isDigit()) {
//                    if (startIndex < 0) {
//                        startIndex = index
//                    }
//                } else {
//                    if (startIndex >= 0) {
//                        numberIndex = s.substring(startIndex,index)
//
//                        break
//                    }
//                }
//            }
//            if (numberIndex.isEmpty() && startIndex >= 0){
//                numberIndex = s.substring(startIndex)
//            }
//            if (!numberIndex.isEmpty()) {
//                result[numberIndex.toInt() - 1] = s.removeRange(startIndex, startIndex + numberIndex.length)
//            }
//        }
//    }
//    for (i in result) {
//        println(i)
//    }
}
