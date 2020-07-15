import java.util.*

fun divide(n1: Long, n2: Long): Double {
    return n1 * 1.0 / n2
}

fun main() {
    val scanner = Scanner(System.`in`)
    val a = scanner.nextLong()
    val b = scanner.nextLong()
    println(divide(a, b))
}