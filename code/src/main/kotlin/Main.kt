import Days.Day1
import Days.Day2
import Days.Day3
import Days.Day4

fun main(args: Array<String>) {
    val utils = Utils();
    val day1: Day1 = Day1()
    val day2: Day2 = Day2()
    val day3 = Day3()
    val day4 = Day4()

    // Actual Result
    val lines = utils.readFileAsLinesUsingReadLines("code/src/main/kotlin/inputFiles/input-day4")


    // println(day1.calculateCalibrationValue(lines))
    // day2.part1(lines)
    // day2.part2(lines)
    // day3.part1(lines)
    // day4.part1(lines)
    day4.part2(lines)
}

