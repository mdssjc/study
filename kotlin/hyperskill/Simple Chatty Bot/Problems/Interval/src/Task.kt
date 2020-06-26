import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)

    val n = scanner.nextInt()

    if (n > -15 && n <= 12 || n > 14 && n < 17 || n >= 19) {
        println("True")
    } else {
        println("False")
    }
}