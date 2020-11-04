import java.lang.NumberFormatException
import java.text.NumberFormat

class Expression {
    private var op: Char? = null

    fun analyze(exp: String) {
        when {
            exp.contains('+', ignoreCase = true) -> op = '+'
            exp.contains('-', ignoreCase = true) -> op = '-'
            exp.contains('*', ignoreCase = true) -> op = '*'
            exp.contains('/', ignoreCase = true) -> op = '/'
        }

        try {
            val exp1: Double = exp.substringBefore(delimiter = op.toString(), missingDelimiterValue = "").toDouble()
            val exp2: Double = exp.substringAfter(delimiter = op.toString(), missingDelimiterValue = "").toDouble()


            when (op) {
                '+' -> sum(exp1, exp2)
                '-' -> diff(exp1, exp2)
                '*' -> pro(exp1, exp2)
                '/' -> div(exp1, exp2)
            }
        } catch (e: NumberFormatException) {
            print("Wrong input!")
        }
    }

    private fun sum(exp1: Double, exp2: Double) {
        val ans = exp1 + exp2

        print("${NumberFormat.getInstance().format(exp1)} + ${NumberFormat.getInstance().format(exp2)} = ${NumberFormat.getInstance().format(ans)}")
    }

    private fun diff(exp1: Double, exp2: Double) {
        val ans = exp1 - exp2
        print("${NumberFormat.getInstance().format(exp1)} - ${NumberFormat.getInstance().format(exp2)} = ${NumberFormat.getInstance().format(ans)}")
    }

    private fun pro(exp1: Double, exp2: Double) {
        val ans = exp1 * exp2
        print("${NumberFormat.getInstance().format(exp1)} * ${NumberFormat.getInstance().format(exp2)} = ${NumberFormat.getInstance().format(ans)}")

    }

    private fun div(exp1: Double, exp2: Double) {
        val ans = exp1 / exp2
        print("${NumberFormat.getInstance().format(exp1)} / ${NumberFormat.getInstance().format(exp2)} = ${NumberFormat.getInstance().format(ans)}")
    }
}


fun main() {

    print("Enter an expression of two operands and an operator : ")
    val ch: String = readLine()!!
    if (ch.contains(' ', ignoreCase = true))
        print("White spaces detected!")
    else {
        val expression = Expression()
        expression.analyze(ch)
    }
}