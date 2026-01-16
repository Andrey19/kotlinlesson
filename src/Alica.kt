fun findWeddingDate(totalEvents: Int, maxAttempts: Int): Int {
    var left = 1
    var right = totalEvents
    var attempts = 0

    while (left <= right && attempts < maxAttempts) {
        val mid = left + (right - left) / 2
        attempts++

        // Здесь должен быть вызов функции, которая симулирует ответ Алисы
        // Для примера предположим, что функция getEventsUpToDate(mid) возвращает количество событий до даты mid включительно
        val eventsUpToDate = getEventsUpToDate(mid)

        if (eventsUpToDate == (totalEvents + 1) / 2) {
            return mid // Дата найдена
        } else if (eventsUpToDate < (totalEvents + 1) / 2) {
            left = mid + 1
        } else {
            right = mid - 1
        }
    }

    throw IllegalArgumentException("Не удалось найти дату за заданное количество попыток")
}

// Функция, которая симулирует ответ Алисы
// В реальной задаче эта функция будет получать данные от Алисы
fun getEventsUpToDate(date: Int): Int {
    // Здесь должна быть логика, которая определяет количество событий до заданной даты включительно
    // Для примера вернём случайное число, но в реальной задаче это число будет получено от Алисы
    return date // Пример реализации, в реальности это значение будет получено от Алисы
}

fun main() {
    val totalEvents = 101 // Общее количество памятных дат
    val maxAttempts = 7 // Максимальное количество попыток

    try {
        val weddingDate = findWeddingDate(totalEvents, maxAttempts)
        println("Дата свадьбы: $weddingDate")
    } catch (e: IllegalArgumentException) {
        println(e.message)
    }
}