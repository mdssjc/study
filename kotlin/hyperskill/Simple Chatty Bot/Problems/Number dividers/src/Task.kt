import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val n = scanner.nextInt()

    if (n % 2 == 0) {
        println("Divided by 2")
    }
    if (n % 3 == 0) {
        println("Divided by 3")
    }
    if (n % 5 == 0) {
        println("Divided by 5")
    }
    if (n % 6 == 0) {
        println("Divided by 6")
    }
}