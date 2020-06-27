import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)

    val a = scanner.nextInt()
    val b = scanner.nextInt()
    val c = scanner.nextInt()

    if (a + b > c && b + c > a && c + a > b) {
        println("YES")
    } else {
        println("NO")
    }
}