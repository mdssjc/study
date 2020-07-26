import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val n = scanner.nextInt()
    val ns = IntArray(n)

    for (i in ns.indices) {
        ns[i] = scanner.nextInt()
    }

    val m = scanner.nextInt()

    var count = 0
    for (x in ns) {
        if (x == m) {
            count++
        }
    }

    println(count)
}