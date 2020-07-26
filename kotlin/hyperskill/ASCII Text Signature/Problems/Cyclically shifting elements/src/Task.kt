import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val n = scanner.nextInt()

    val a = IntArray(n)
    for (i in 0..a.lastIndex) {
        a[i] = scanner.nextInt()
    }

    for (i in 0..a.lastIndex) {
        print(a[(a.lastIndex + i) % n].toString() + " ")
    }
}