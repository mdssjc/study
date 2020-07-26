import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val size = scanner.nextInt()
    val elements = IntArray(size)

    for (i in elements.indices) {
        elements[i] = scanner.nextInt()
    }

    var count = 0
    for (i in 0..elements.lastIndex - 2) {
        if (elements[i] - elements[i + 1] == -1 &&
                elements[i + 1] - elements[i + 2] == -1) {
            count++
        }
    }

    println(count)
}