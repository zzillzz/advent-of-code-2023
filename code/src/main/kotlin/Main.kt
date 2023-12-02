import Days.Day1
import Days.Day2
import java.io.File

fun main(args: Array<String>) {
    val utils = Utils();
    val day1: Day1 = Day1();
    val day2: Day2 = Day2();

    // Actual Result
    val lines = utils.readFileAsLinesUsingReadLines("code/src/main/kotlin/inputFiles/input-day2")
    val testString = "Game 1: 1 blue, 2 green, 3 red; 7 red, 8 green; 1 green, 2 red, 1 blue; 2 green, 3 red, 1 blue; 8 green, 1 blue"


    //println(day1.calculateCalibrationValue(lines))
    day2.part1(lines)
    day2.part2(lines)
}

