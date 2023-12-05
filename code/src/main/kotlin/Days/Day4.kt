package Days

class Day4 {
    fun part1(input: List<String>) {
        var score = 0
        for (gameLine in input) {
            val game = separateGameFromTitle(gameLine)
            score += getScore(game)
        }

        println("score: $score")
    }

    fun part2(input: List<String>) {
        var score = 0
        val games = mutableMapOf<Int, Int>()
        for (i in input.indices) {
            games[i] = 1
        }

        for (i in input.indices) {
            val game = separateGameFromTitle(input[i])
            val foundNumber = getFoundNumber(game)
            for (k in 0..< games[i]!!) {
                for (j in i + 1 ..i + foundNumber) {
                    if (games[j] != null) {
                        games[j] = games[j]!! + 1
                    }
                }
            }

        }

        for (game in games) {
            score += game.value
        }

        println("score: $score")
    }

    private fun separateGameFromTitle(gameLine: String): String {
        val game = gameLine.split(":")
        return game.last
    }

    private fun getScore(game: String): Int {
        val foundNumber = getFoundNumber(game)

        return if (foundNumber > 0) {
            var answer = 1
            for (i in 2..foundNumber) {
                answer += answer
            }
            answer
        } else {
            0
        }
    }

    private fun getFoundNumber(game: String): Int {
        var foundNumber = 0
        val numbers = game.split("|")
        val winningNumbers = numbers[0].split(" ").filter { it -> it.isNotEmpty() }.map { it.toInt() }
        val yourNumbers = numbers[1].split(" ").filter { it -> it.isNotEmpty() }.map { it.toInt() }
        for (number in winningNumbers) {
            if (yourNumbers.stream().anyMatch{ it == number}) {
                foundNumber++
            }
        }
        return foundNumber
    }
}