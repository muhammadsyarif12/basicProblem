import java.sql.Time
import java.util.*
import kotlin.math.pow

private val service = Service()
fun main(args: Array<String>) {

    //Problem #1 - 1
    println("=============== Problem Solving Basic #1 =============== ")
    print("input number : ")
    val numString: String = readln()
    service.miniMaxSumFromInput(numString)
    //explanation
    service.sumEverythingExceptN(numString)
    println("============================== ")


    //Problem #2 - 1
    println()
    println("=============== Problem Solving Basic #2 =============== ")
    print("input n number : ")
    val nNumber: Int = readln().toInt()
    service.validateNInput(nNumber)
    print("input number : ")
    val inLineNumber: String = readln()
    service.plusMinusFromInput(inLineNumber, nNumber)
    println("============================== ")

    //Problem #3
    println()
    println("=============== Problem Solving Basic #2 =============== ")
    val strTime = "07:05:45PM"
    service.convertTimeFormat(strTime)
    println("============================== ")
}