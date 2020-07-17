package signature

fun main() {
    println(" _____________")
    println("| Hyper Skill |")
    println(" ¯¯¯¯¯¯¯¯¯¯¯¯¯")

    val fullName = readLine()!!

    if (fullName != null && fullName.length > 2) {
        val name = fullName.split(" ")
        printName(name[0], name[1])
    }
}

fun printName(firstName: String, lastName: String) {
    val size = firstName.length + lastName.length + 5
    printSymbol(size)
    println("* $firstName $lastName *")
    printSymbol(size)
}

fun printSymbol(size: Int) {
    repeat(size) {
        print("*")
    }
    println()
}
