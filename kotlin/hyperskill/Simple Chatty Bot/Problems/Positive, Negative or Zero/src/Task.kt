import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val n = scanner.nextInt()

    println(if (n < 0) {
        "negative"
    } else if (n > 0) {
        "positive"
    } else {
        "zero"
    })
}