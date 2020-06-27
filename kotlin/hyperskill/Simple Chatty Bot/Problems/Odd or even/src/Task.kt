import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val n = scanner.nextInt()

    println(if (n % 2 == 0) "EVEN" else "ODD")
}