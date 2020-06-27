import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)

    val x1 = scanner.nextInt()
    val y1 = scanner.nextInt()
    val z1 = scanner.nextInt()

    val x2 = scanner.nextInt()
    val y2 = scanner.nextInt()
    val z2 = scanner.nextInt()

    val xEquals = x1 == x2 && y1 == y2 && z1 == z2 ||
            x1 == x2 && y1 == z2 && z1 == y2
    val yEquals = x1 == y2 && y1 == x2 && z1 == z2 ||
            x1 == y2 && y1 == z2 && z1 == x2
    val zEquals = x1 == z2 && y1 == y2 && z1 == x2 ||
            x1 == z2 && y1 == x2 && z1 == y2

    val xLessThan = x1 <= x2 && y1 <= y2 && z1 <= z2 ||
            x1 <= x2 && y1 <= z2 && z1 <= y2
    val yLessThan = x1 <= y2 && y1 <= x2 && z1 <= z2 ||
            x1 <= y2 && y1 <= z2 && z1 <= x2
    val zLessThan = x1 <= z2 && y1 <= y2 && z1 <= x2 ||
            x1 <= z2 && y1 <= x2 && z1 <= y2

    val xGreaterThan = x1 >= x2 && y1 >= y2 && z1 >= z2 ||
            x1 >= x2 && y1 >= z2 && z1 >= y2
    val yGreaterThan = x1 >= y2 && y1 >= x2 && z1 >= z2 ||
            x1 >= y2 && y1 >= z2 && z1 >= x2
    val zGreaterThan = x1 >= z2 && y1 >= y2 && z1 >= x2 ||
            x1 >= z2 && y1 >= x2 && z1 >= y2

    if (xEquals || yEquals || zEquals) {
        println("Box 1 = Box 2")
    } else if (xLessThan || yLessThan || zLessThan) {
        println("Box 1 < Box 2")
    } else if (xGreaterThan || yGreaterThan || zGreaterThan) {
        println("Box 1 > Box 2")
    } else {
        println("Incomparable")
    }
}