import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)

    val begin = scanner.nextInt()
    val end = scanner.nextInt()

    for (i in begin..end) {
        val div3 = i % 3 == 0
        val div5 = i % 5 == 0

        if (div3) {
            print("Fizz")
        }
        if (div5) {
            print("Buzz")
        }
        if (!div3 && !div5) {
            print(i)
        }
        println()
    }
}