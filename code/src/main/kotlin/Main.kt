import Days.Day1
import Days.Day2
import java.io.File

fun main(args: Array<String>) {
    val utils = Utils();
    val day1: Day1 = Day1();
    val day2: Day2 = Day2();

    // Actual Result
    val lines = utils.readFileAsLinesUsingReadLines("/Users/zillerahim/Desktop/adventofcode/input.txt")

    println(day1.calculateCalibrationValue(lines))
}

