import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val duration = scanner.nextInt()
    val foodCost = scanner.nextInt()
    val flightCost = scanner.nextInt()
    val nightCost = scanner.nextInt()

    println(duration * foodCost + flightCost * 2 + (duration - 1) * nightCost)
}