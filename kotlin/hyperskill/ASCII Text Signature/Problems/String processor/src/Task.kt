import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val string1 = scanner.next()
    val operator = scanner.next()
    val string2 = scanner.next()

    println(when (operator) {
        "equals" -> string1 == string2
        "plus" -> string1 + string2
        "endsWith" -> string1.endsWith(string2)
        else -> "Unknown operation"
    })
}