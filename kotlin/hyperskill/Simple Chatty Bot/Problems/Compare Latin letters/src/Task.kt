import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val ll1 = scanner.next().first()
    val ll2 = scanner.next().first()

    println(ll1.equals(ll2, true))
}