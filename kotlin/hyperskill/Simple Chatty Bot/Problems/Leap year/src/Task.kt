import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)

    val year = scanner.nextInt()
    val isLeap = year % 4 == 0 && year % 100 != 0 || year % 400 == 0

    println(if (isLeap) "Leap" else "Regular")
}