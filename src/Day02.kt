fun main() {
    fun part1(input: List<String>): Int {
        var horizontalPosition = 0
        var depth = 0

        input.forEach { actionRaw ->
            val splitAction = actionRaw.split(" ")
            val action = splitAction[0]
            val amount = splitAction[1].toInt()

            if(action.startsWith("forward")) {
                horizontalPosition += amount
            } else if(action.startsWith("up")) {
                depth -= amount
            } else if(action.startsWith("down")) {
                depth += amount
            }
        }

        return horizontalPosition * depth
    }

    fun part2(input: List<String>): Int {
        var horizontalPosition = 0
        var depth = 0
        var aim = 0

        input.forEach { actionRaw ->
            val splitAction = actionRaw.split(" ")
            val action = splitAction[0]
            val amount = splitAction[1].toInt()

            if(action.startsWith("forward")) {
                horizontalPosition += amount
                depth += aim * amount
            } else if(action.startsWith("up")) {
                aim -= amount
            } else if(action.startsWith("down")) {
                aim += amount
            }
        }

        return horizontalPosition * depth
    }

    val input: List<String> = readInput("Day02_test")

    println("Part 1 result: ${part1(input)}")
    println("Part 2 result: ${part2(input)}")

}
