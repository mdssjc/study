import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val c1 = scanner.next().first()
    val c2 = scanner.next().first()
    val c3 = scanner.next().first()

    println(c1 == c2 - 1 && c2 == c3 - 1)
}