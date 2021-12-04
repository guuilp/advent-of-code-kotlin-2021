fun main() {
    fun part1(input: List<Int>): Int {
        var measurementsLargerThanPrevious = 0

        input.forEachIndexed { index, i ->
            if (index != 0 && i > input[index - 1]) measurementsLargerThanPrevious++
        }

        return measurementsLargerThanPrevious
    }

    fun part2(input: List<Int>): Int {
        var measurementsLargerThanPrevious = 0

        (0..input.size - 4).forEach { index ->
            val currentTree = input[index] + input[index + 1] + input[index + 2]
            val nextTree = input[index + 1] + input[index + 2] + input[index + 3]

            if (nextTree > currentTree) measurementsLargerThanPrevious++
        }

        return measurementsLargerThanPrevious
    }

    val inputAsStringList: List<String> = readInput("Day01_test")
    val inputAsIntList = inputAsStringList.map { it.toInt() }

    println("Part 1 result: ${part1(inputAsIntList)}")
    println("Part 2 result: ${part2(inputAsIntList)}")

}
