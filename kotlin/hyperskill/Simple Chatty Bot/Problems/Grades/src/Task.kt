import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val n = scanner.nextInt()

    var a = 0
    var b = 0
    var c = 0
    var d = 0
    repeat(n) {
        val grade = scanner.nextInt()

        if (grade == 5) {
            a++
        } else if (grade == 4) {
            b++
        } else if (grade == 3) {
            c++
        } else if (grade == 2) {
            d++
        }
    }

    print("$d $c $b $a")
}