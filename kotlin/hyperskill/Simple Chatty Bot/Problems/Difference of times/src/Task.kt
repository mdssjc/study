import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val hours1 = scanner.nextInt()
    val minutes1 = scanner.nextInt()
    val seconds1 = scanner.nextInt()
    val hours2 = scanner.nextInt()
    val minutes2 = scanner.nextInt()
    val seconds2 = scanner.nextInt()

    val temp1 = hours1 * 60 * 60 + minutes1 * 60 + seconds1
    val temp2 = hours2 * 60 * 60 + minutes2 * 60 + seconds2

    println(temp2 - temp1)
}