import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val size = scanner.nextInt()
    val elements = IntArray(size)

    for (i in elements.indices) {
        elements[i] = scanner.nextInt()
    }

    var position = 0
    for (i in 1..elements.lastIndex) {
        if (elements[i] > elements[position]) {
            position = i
        }
    }

    println(position)
}