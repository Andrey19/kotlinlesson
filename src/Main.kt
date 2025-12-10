//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val amount = 14_000
    val bankCard = "Vkpay"
    val maxSend = 150_000


    if (amount < maxSend) {
        println()
        if (bankCard == "Mastercard" || bankCard == "Maestro") {
            if (75000 < amount || amount < 300) {
                val result = (amount * 0.006) + 20
                println("Ваша комиссия составит : $result  рублей")
            } else {
                println("Ваша комиссия составит :  0  рублей ")
            }

        }

        if (bankCard == "Visa" || bankCard == "Мир") {
            val result = amount * 0.0075
            if (result < 35) {
                println("Ваша комиссия составит : 35  рублей")
            } else {
                println("Ваша комиссия составит : $result  рублей")
            }
        }

        if (bankCard == "Vkpay") {
            if (amount > 15000) {
                println(" Превыщен лимит переводов по Vkpay   \n максимальный возможный 15_000 рублей ")
            } else {
                println("Ваша комиссия составит : 0   рублей")
            }
        }
    } else {
        println(" Превыщен лимит переводов  \n максимальный возможный 150_000 рублей ")
    }

//--------------------------Task 2

    println()
    var likes: Int = 6

    if (likes % 10 == 1 && likes % 100 != 11) {
        println("Понравилось " + likes + " человеку ")
    } else {
        println("Понравилось " + likes + " людям ")
    }


    //--------------------------Task 3

        println()
        var amount1: Double = 11000.0
        var regularClient: Boolean = true
        var result: Double
        val firstsale: Double = 100.0
        val secondsale: Double = 0.95
        val onesale: Double = 0.99

        if (amount1 < 1000) {
            println("Итоговая сумма : " + amount1)
            result = amount1
        } else if (amount1 >= 1000 && amount1 <= 10_000) {
            result = (amount1 - firstsale)
            println("После применения скидки : " + result)
        } else {
            result = amount1 * secondsale
            println("После применения 5% скидки : " + result )
        }

        if (regularClient == true) {
            result *= onesale
            println("После применения 1% скидки : " + result)
        }


}