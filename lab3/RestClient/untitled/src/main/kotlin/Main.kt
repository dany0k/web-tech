class Calculator(val first: Int, val second: Int) {
    fun res(): Int {
        return  first + second
    }
}

fun Calculator.res() : Int {
    return first * second
}


fun main(args: Array<String>) {
    val calc = Calculator(4, 5)
    println(calc.res().toString())
    println("Resuly from ${calc.first.toString()} and ${calc.second.toString()} is {$calc.res().toString}")
}