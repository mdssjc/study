import java.util.*
import kotlin.math.abs

fun getLastDigit(n: Int) = abs(n % 10)

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val a = scanner.nextInt()
    println(getLastDigit(a))
}