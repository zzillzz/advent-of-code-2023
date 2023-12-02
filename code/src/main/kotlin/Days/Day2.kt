package Days

import kotlin.math.max
import kotlin.math.min

class Day2 {

    // Game 1: 1 blue, 2 green, 3 red; 7 red, 8 green; 1 green, 2 red, 1 blue; 2 green, 3 red, 1 blue; 8 green, 1 blue
    private fun getMaxCountForColor(color: String): Int {
        return when (color) {
            "blue" -> 14
            "green" -> 13
            "red" -> 12
            else -> 0
        }
    }

    fun part1(input: List<String>) {
        var answer = 0
        for (i in input.indices) {
            if (checkGame(input[i])) {
                answer += i + 1
            }
        }
        println("answer: $answer")
    }

    fun part2(input: List<String>) {
        val values = mutableListOf<Int>()
        for (i in input.indices) {
            val lineAnswer = getMinColoursRequired(input[i])
            var lineValue = 1
            for (color in lineAnswer) {
                lineValue *= color.value
            }
            values.add(lineValue)
        }

        println(values.sum())
    }

    private fun checkGame(inputLine: String): Boolean {
        var accepted = true

        val sets = inputLine.split(";")
        for (set in sets) {
            val colorCounts = mutableMapOf<String, Int>()
            val colorMatches = Regex("""(\d+)\s*([a-zA-Z]+)""").findAll(set)

            for (match in colorMatches) {
                val count = match.groupValues[1].toInt()
                val color = match.groupValues[2].toLowerCase()

                colorCounts[color] = colorCounts.getOrDefault(color, 0) + count
            }

            for (color in colorCounts) {
                if (color.value > getMaxCountForColor(color.key)) {
                    accepted = false
                }
            }
        }

        return accepted
    }

    private fun getMinColoursRequired(inputLine: String): MutableMap<String, Int> {
        val sets = inputLine.split(";")
        val minColorCounts = mutableMapOf<String, Int>()
        minColorCounts.put("blue", 0)
        minColorCounts.put("green", 0)
        minColorCounts.put("red", 0)

        for (set in sets) {
            val colorCounts = mutableMapOf<String, Int>()
            val colorMatches = Regex("""(\d+)\s*([a-zA-Z]+)""").findAll(set)

            for (match in colorMatches) {
                val count = match.groupValues[1].toInt()
                val color = match.groupValues[2].toLowerCase()

                colorCounts[color] = colorCounts.getOrDefault(color, 0) + count
            }

            for (color in colorCounts) {
                minColorCounts[color.key] = max(color.value, minColorCounts[color.key]!!)
            }
        }

        return minColorCounts
    }
}