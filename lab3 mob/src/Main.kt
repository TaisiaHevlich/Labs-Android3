fun calculateAverage(numbers: List<Int?>): Double {
    var sum = 0
    var count = 0

    for (number in numbers) {
        if (number != null) {
            sum += number
            count++
        }
    }

    return if (count > 0) sum.toDouble() / count else 0.0
}

fun main() {
    val inputNumbers = mutableListOf<Int?>()

    println("Введіть числа (для завершення введення введіть 'stop'):")
    while (true) {
        val input = readLine()
        if (input == "stop") break
        val number = input?.toIntOrNull()
        inputNumbers.add(number)
    }

    val average = calculateAverage(inputNumbers)
    println("Середнє: $average")
}
