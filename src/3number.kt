fun main(args: Array<String>) {
    gradient2()
}

fun gradient2(){
    println(readln().split(" ").map{ it.toInt()}.sorted()[1])
}