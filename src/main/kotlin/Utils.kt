import java.util.Scanner

class Utils {
    fun isNumeric(toCheck: String): Boolean {
        return toCheck.all { char -> char.isDigit() }
    }

    fun getStringInput(): String {
        var value: String
        while (true) {
            value = Scanner(System.`in`).nextLine()
            if (value.isNotEmpty()) return value
        }
    }
}
