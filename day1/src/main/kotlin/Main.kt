import java.io.File

fun main(args: Array<String>) {
    // Actual result
    val lines = readFileAsLinesUsingReadLines("/Users/zillerahim/Desktop/adventofcode/input.txt")
    println(calculateCalibrationValue(lines))

    // Attempt 1
//    val inputString = "heightseven4two5"
//    val inputString2 = "heightwo4two5"
//    val convertedString = convertNumericWords(inputString2)
//    println("Converted String: $convertedString")

    // Attempt 2
//    val inputString = "heightseven4two5"
//    val answer = calculateCalibrationSum(inputString)
//    println(answer)
}

fun readFileAsLinesUsingReadLines(fileName: String): List<String>
        = File(fileName).readLines()

fun calculateCalibrationValue(words: List<String>): Int {
    val values = mutableListOf<Int>()
    for (i in words.indices) {
        values.add(
            checkLineCode(
                convertNumericWords(words[i])
            )
        )
    }

    return values.sum()
}

fun checkLineCode(word: String): Int {
    var firstNum: Int? = null
    var foundFirstNum = false
    var secondNum: Int? = null

    for (i in 0..< word.length) {
        val currentCharacter = word[i]
        if (currentCharacter.isDigit()) {
            val charNum = word[i].digitToInt()
            if (!foundFirstNum) {
                firstNum = charNum
                foundFirstNum = true
            } else {
                secondNum = charNum
            }
        }
    }

    if (secondNum != null) {
        val num = ("$firstNum$secondNum").toInt()
        print(" = $num \n")
        return ("$firstNum$secondNum").toInt()
    } else {
        val num = ("$firstNum$firstNum").toInt()
        print(" = $num \n")
        return ("$firstNum$firstNum").toInt()
    }
}

fun convertNumericWords(input: String): String {
    var testInput = ""
    val numericWordsMap = mapOf(
        "one" to "1",
        "two" to "2",
        "three" to "3",
        "four" to "4",
        "five" to "5",
        "six" to "6",
        "seven" to "7",
        "eight" to "8",
        "nine" to "9",
        "zero" to "0"
    )

    val listOfWords = listOf("one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "zero")

    for (i in input.indices) {
        if (input[i].isDigit()) {
            testInput += input[i]
        } else {
            var breakPoint = 0
            for (j in i..input.length) {
                val newInput = input.substring(i, j)
                if (newInput in listOfWords) {
                    val number = numericWordsMap[newInput]
                    if (number != null) {
                        testInput += number
                        break
                    }
                }
                breakPoint++
                if (breakPoint == 6) {
                    break
                }
            }
        }

    }
    print("$input = $testInput")


    return testInput
}

//fun extractCalibrationValue(line: String): Int {
//    val digits = line.filter { it.isDigit() || it.isLetter() }
//    val firstDigit = digits.first().toString().toIntOrNull() ?: convertWordToDigit(digits.substring(0, 3))
//    val lastDigit = digits.last().toString().toIntOrNull() ?: convertWordToDigit(digits.substring(digits.length - 3))
//
//    return (firstDigit * 10) + lastDigit
//}
