import kotlin.system.measureTimeMillis

fun main() {
    fun part1(input: List<String>): Int {
        val gamaRate = mutableListOf<String>()
        val epsilonRate = mutableListOf<String>()
        val rowLength = input[0].length

        (0 until rowLength).forEach { index ->
            val zeroOccurrences = input.count { it[index] == '0' }
            val oneOccurrences = input.size - zeroOccurrences

            if (zeroOccurrences > oneOccurrences) {
                gamaRate.add("0")
                epsilonRate.add("1")
            } else {
                gamaRate.add("1")
                epsilonRate.add("0")
            }
        }

        return gamaRate.joinToString("").toInt(2) * epsilonRate.joinToString("").toInt(2)
    }

    fun part2(input: List<String>): Int {
        var oxygenGeneratorRating = input
        var co2ScrubberRating = input

        val rowLength = input[0].length

        (0 until rowLength).forEach { index ->
            if (oxygenGeneratorRating.size == 1) return@forEach

            val zeroOccurrences = oxygenGeneratorRating.count { it[index] == '0' }
            val oneOccurrences = oxygenGeneratorRating.size - zeroOccurrences

            oxygenGeneratorRating = if (zeroOccurrences > oneOccurrences) {
                oxygenGeneratorRating.filter { it[index] == '0' }
            } else if (zeroOccurrences < oneOccurrences) {
                oxygenGeneratorRating.filter { it[index] == '1' }
            } else {
                oxygenGeneratorRating.filter { it[index] == '1' }
            }
        }

        (0 until rowLength).forEach { index ->
            if (co2ScrubberRating.size == 1) return@forEach

            val zeroOccurrences = co2ScrubberRating.count { it[index] == '0' }
            val oneOccurrences = co2ScrubberRating.size - zeroOccurrences

            co2ScrubberRating = if (zeroOccurrences > oneOccurrences) {
                co2ScrubberRating.filter { it[index] == '1' }
            } else if (zeroOccurrences < oneOccurrences) {
                co2ScrubberRating.filter { it[index] == '0' }
            } else {
                co2ScrubberRating.filter { it[index] == '0' }
            }
        }

        return oxygenGeneratorRating.first().toInt(2) * co2ScrubberRating.first().toInt(2)
    }

    val input: List<String> = readInput("Day03_test")

    val executionTimePartOne = measureTimeMillis {
        println("Part 1 result: ${part1(input)}")
    }
    println("Part 1 - Execution time: ${executionTimePartOne}ms")

    check(part1(input) == 2743844)

    val executionTimePartTwo = measureTimeMillis {
        println("Part 1 result: ${part2(input)}")
    }
    println("Part 2 - Execution time: ${executionTimePartTwo}ms")

    check(part2(input) == 6677951)
}
