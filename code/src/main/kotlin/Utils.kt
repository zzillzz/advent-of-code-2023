import java.io.File

class Utils {
    fun readFileAsLinesUsingReadLines(fileName: String): List<String>
            = File(fileName).readLines()
}