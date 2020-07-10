import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val n = scanner.nextInt()

    var last = 0
    var count = 0
    var maxCount = 1
    for (i in 1..n) {
        val current = scanner.nextInt()

        if (last <= current) {
            count++
        } else {
            count = 1
        }

        if (count > maxCount) {
            maxCount = count
        }

        last = current
    }

    println(maxCount)
}