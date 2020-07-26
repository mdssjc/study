import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val n = scanner.nextInt()

    val ns = IntArray(n)
    for (i in 0..ns.lastIndex) {
        ns[i] = scanner.nextInt()
    }

    val m = scanner.nextInt()

    var hasValue = false
    for (value in ns) {
        if (value == m) {
            hasValue = true
        }
    }

    println(if (hasValue) "YES" else "NO")
}