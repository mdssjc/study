import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)

    val x1 = scanner.nextInt()
    val y1 = scanner.nextInt()
    val x2 = scanner.nextInt()
    val y2 = scanner.nextInt()

    if (Math.abs(x1 - x2) == 2 && Math.abs(y1 - y2) == 1 ||
            Math.abs(y1 - y2) == 2 && Math.abs(x1 - x2) == 1) {
        println("YES")
    } else {
        println("NO")
    }
}