import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val n = scanner.nextInt()

    var isOrder = true
    var last = scanner.nextInt()
    for (i in 1 until n) {
        val current = scanner.nextInt()
        if (last > current) {
            isOrder = false
        }
        last = current
    }

    println(if (isOrder) "YES" else "NO")
}