import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val n = scanner.nextInt()

    var count = 0
    repeat(n) {
        val x = scanner.nextInt()
        if (x > 0) {
            count++
        }
    }

    println(count)
}