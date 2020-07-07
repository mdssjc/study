import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val n = scanner.nextInt()

    var maximumElement = 0
    repeat(n) {
        val x = scanner.nextInt()
        if (x % 4 == 0 && x > maximumElement) {
            maximumElement = x
        }
    }

    println(maximumElement)
}