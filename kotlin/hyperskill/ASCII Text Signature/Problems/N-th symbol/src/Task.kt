import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val text = scanner.nextLine()
    val n = scanner.nextInt()

    println("Symbol # $n of the string \"$text\" is '${text[n - 1]}'")
}