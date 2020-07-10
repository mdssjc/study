import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)

    val a = scanner.nextInt()
    val b = scanner.nextInt()
    val n = scanner.nextInt()

    var count = 0
    for (i in a..b) {
        if (i % n == 0) {
            count++
        }
    }
    println(count)

    // println(b / n - a / n + if (a % n == 0) 1 else 0)
}