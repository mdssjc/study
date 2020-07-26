import java.util.*
import kotlin.math.abs

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val size = scanner.nextInt()
    val numbers = IntArray(size)

    for (i in numbers.indices) {
        numbers[i] = scanner.nextInt()
    }

    val n = scanner.nextInt()
    val m = scanner.nextInt()

    var positionN = -10
    var positionM = -10
    var result = true
    for (i in numbers.indices) {
        if (numbers[i] == n) {
            positionN = i
            result = result && abs(positionN - positionM) > 1
        }
        if (numbers[i] == m) {
            positionM = i
            result = result && abs(positionN - positionM) > 1
        }
    }

    println(if (result) "NO" else "YES")
}