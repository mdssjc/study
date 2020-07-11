import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val n = scanner.nextInt()

    var minimum = scanner.nextInt()
    for (i in 1 until n) {
        val current = scanner.nextInt()
        if (current < minimum) {
            minimum = current
        }
    }
    println(minimum)
}