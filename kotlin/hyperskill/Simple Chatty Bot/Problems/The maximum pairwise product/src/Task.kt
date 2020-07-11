import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val n = scanner.nextInt()

    var a = 1
    var b = 1

    for (i in 1..n) {
        val x = scanner.nextInt()

        if (x > a) {
            a = x
        } else if (x > b) {
            b = x
        }
    }

    println(a * b)
}