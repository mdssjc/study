import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)

    val hours = scanner.nextInt()
    val minutes = scanner.nextInt()
    val seconds = scanner.nextInt()

    val day = scanner.nextInt()
    val month = scanner.nextInt()
    val year = scanner.nextInt()

    println("$hours:$minutes:$seconds $day/$month/$year")
}