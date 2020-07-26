import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val companies = scanner.nextInt()
    val incomes = IntArray(companies)
    val taxes = IntArray(companies)
    val results = IntArray(companies)

    for (i in 0..incomes.lastIndex) {
        incomes[i] = scanner.nextInt()
    }

    for (i in 0..taxes.lastIndex) {
        taxes[i] = scanner.nextInt()
    }

    for (i in 0..results.lastIndex) {
        results[i] = incomes[i] * taxes[i]
    }

    var maximum = 0
    for (i in 1..results.lastIndex) {
        if (results[i] > results[maximum]) {
            maximum = i
        }
    }

    println(maximum + 1)
}