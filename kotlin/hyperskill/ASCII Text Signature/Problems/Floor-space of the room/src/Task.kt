import java.util.*
import kotlin.math.sqrt

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val type = scanner.next()

    println(when (type) {
        "triangle" -> {
            val a = scanner.nextDouble()
            val b = scanner.nextDouble()
            val c = scanner.nextDouble()
            val s = 0.5 * (a + b + c)
            sqrt(s * (s - a) * (s - b) * (s - c))
        }
        "rectangle" -> {
            val a = scanner.nextDouble()
            val b = scanner.nextDouble()
            a * b
        }
        "circle" -> {
            val r = scanner.nextDouble()
            3.14 * r * r
        }
        else -> ""
    })
}