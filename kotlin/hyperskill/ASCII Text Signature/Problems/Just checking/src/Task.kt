import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val number = scanner.nextInt()

    println(when (number) {
        2 -> "Yes!"
        1, 3, 4 -> "No!"
        else -> "Unknown number"
    })
}