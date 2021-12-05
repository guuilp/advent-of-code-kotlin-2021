fun main() {
    fun part1(input: List<String>): Int {
        val gamaRate = mutableListOf<String>()
        val epsilonRate = mutableListOf<String>()
        val rowLength = input[0].length
        val diagnosticReportList = Array(rowLength) { Array(input.size) { "" } }

        input.forEachIndexed { rowIndex, row ->
            (0 until rowLength).forEach { index ->
                diagnosticReportList[index][rowIndex] = row.substring(index, index + 1)
            }
        }

        (0 until rowLength).forEach { index ->
            val column = diagnosticReportList[index]
            val zeroOccurrences = column.count { it == "0" }
            val oneOccurrences = column.count { it == "1" }

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
        return 0
    }

    val input: List<String> = readInput("Day03_test")

    println("Part 1 result: ${part1(input)}")
    println("Part 2 result: ${part2(input)}")
}
