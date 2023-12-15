import java.lang.AssertionError
import java.lang.Exception
import kotlin.math.pow

class Utils {
    fun stringToIntArray(strNumber: String): Array<Int>{
        val splitted : Array<String> = strNumber.split(" ").toTypedArray()
        val numberList = ArrayList<Int>()
        splitted.forEach {
            try {
                numberList.add(it.toInt())
            }catch (e : Exception){
                throw AssertionError("Error an occurred : ${e.message.toString()}")
            }
        }

        return numberList.toTypedArray()
    }

    fun isValidInputCaseOne(numberArray: Array<Int>): Boolean{
        numberArray.forEach {
            if(it < 1 || it > 10.0.pow(9.0))
                return false
        }
        return true
    }

    fun isLong(strNumber: String): Boolean{
        return strNumber.toLongOrNull() != null
    }

    fun calculateRation(countNumber: Int, arraySize: Int): Double {
        return (countNumber.toDouble() / arraySize.toDouble())
    }

    fun formatNDigits(digits: Int, number:Double): String{
        return String.format("%.${digits}f", number)
    }

    fun isValidInputCaseTwo(numberArray: Array<Int>, nNumber: Int): Boolean{
        numberArray.forEach {
            if(it < -100 || it > 100)
                return false
        }

        if(numberArray.size != nNumber)
            return false

        return true
    }

    fun isValidNNumber(nInput: Int): Boolean{
        return nInput > Constanta.MIN_N && nInput < Constanta.MAX_N
    }

    fun isValidInputCaseThree(stringTime: String): Boolean{
        if(stringTime.takeLast(2) != "AM" && stringTime.takeLast(2) != "PM")
            return false

        val splittedTime = stringTime.split(":")
        if(splittedTime.size != 3)
            return false
        else{
            if(splittedTime[0].length != 2 || splittedTime[1].length != 2 || splittedTime[2].length != 4)
                return false
            try {
                if((splittedTime[0].toInt() < 0 || splittedTime[0].toInt() > 12) ||
                    (splittedTime[1].toInt() < 0 || splittedTime[1].toInt() > 59) ||
                    (splittedTime[2].take(2).toInt() < 0 || splittedTime[2].take(2).toInt() > 59))
                    return false
            }catch (e : Exception){
                return false
            }
        }

        return true
    }
}