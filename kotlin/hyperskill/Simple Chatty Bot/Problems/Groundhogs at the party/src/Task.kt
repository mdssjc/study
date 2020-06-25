import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val cups = scanner.nextInt()
    val weekend = scanner.nextBoolean()

    println(!weekend && cups >= 10 && cups <= 20 ||
            weekend && cups >= 15 && cups <= 25)
}