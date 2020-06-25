import java.util.Scanner

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val c = scanner.next().first()

    println(c.isUpperCase() || c in '1'..'9')
}