import java.lang.AssertionError
import java.lang.Exception
import java.time.LocalTime
import java.time.format.DateTimeFormatter

class Service {
    private val utils = Utils()

    //Problem Solving Basic - Test 1
    fun miniMaxSum(numArray: Array<Int>){
        if(numArray.size != Constanta.MAX_NUM_COUNT){
            println("Array must have ${Constanta.MAX_NUM_COUNT} numbers")
        }else{
            var minSum = 0L
            var maxSum = 0L
            val sorted = numArray.sortedArray()

            var i = 0
            while (i < sorted.size){
                if (i != 0)
                    maxSum += sorted.get(i).toLong()
                if (i != sorted.size-1)
                    minSum += sorted.get(i).toLong()
                i++
            }

            println("$minSum $maxSum")
        }
    }

    fun miniMaxSumFromInput(inputNumber: String){
        val intArray = utils.stringToIntArray(inputNumber)

        if(intArray.size != Constanta.MAX_NUM_COUNT){
            println("Input must have ${Constanta.MAX_NUM_COUNT} numbers")
        }else{
            if(utils.isValidInputCaseOne(intArray))
                miniMaxSum(intArray)
            else
                throw AssertionError("Error an occurred : invalid inputted number")
        }
    }

    fun sumEverythingExceptN(inputNumber: String){
        val intArray = utils.stringToIntArray(inputNumber)
        var i=0
        while (i < intArray.size){
            var j=0
            var output = "${i+1}. Sum everything except ${intArray[i]}, the sum is "
            var result = 0L
            while (j < intArray.size){
                if (i != j){
                    // condition (i == longArray.size-1 && j== longArray.size -2 ) is special case for latest number
                    output += if(j == (intArray.size-1)
                                    || (i == intArray.size-1 && j== intArray.size -2 ))
                        "${intArray[j]} = "
                    else{
                        "${intArray[j]} + "
                    }
                    result += intArray[j].toLong()
                }
                j++
            }
            output += "$result"
            println(output)
            i++
        }
    }

    //Problem Solving Basic - Test 2
    fun plusMinus(numArray: Array<Int>){
        var positiveNumber = 0
        var negativeNumber = 0
        var zeroNumber = 0

        numArray.forEach {
            if(it > 0)
                positiveNumber += 1
            else if(it < 0)
                negativeNumber += 1
            else
                zeroNumber += 1
        }

        val positiveRatio = utils.calculateRation(positiveNumber, numArray.size)
        println(utils.formatNDigits(6, positiveRatio))
        val negativeRatio = utils.calculateRation(negativeNumber, numArray.size)
        println(utils.formatNDigits(6, negativeRatio))
        val zeroRatio = utils.calculateRation(zeroNumber, numArray.size)
        println(utils.formatNDigits(6, zeroRatio))
    }

    fun plusMinusFromInput(inputNumber: String, nNumber: Int){
        var intArray = utils.stringToIntArray(inputNumber)
        if(utils.isValidInputCaseTwo(intArray, nNumber)){
            plusMinus(intArray)
        }else{
            throw AssertionError("Error an occurred : Invalid inputted number array")
        }
    }

    fun validateNInput(nInput: Int){
        if(!utils.isValidNNumber(nInput))
            throw AssertionError("Error an occurred : n number must be more than ${Constanta.MIN_N} " +
                    "and less than ${Constanta.MAX_N}")
    }

    fun convertTimeFormat(strTime: String){
        if(utils.isValidInputCaseThree(strTime)){
            try {
                val pattern = DateTimeFormatter.ofPattern("h:mm:ssa")
                val patternResult = DateTimeFormatter.ofPattern("HH:mm:ss")
                val dateTime = LocalTime.parse(strTime, pattern)

                println(dateTime.format(patternResult).toString())
            }catch (e: Exception){
                throw AssertionError("Error an occurred : ${e.message.toString()}")
            }
        }else{
            throw AssertionError("Error an occurred : invalid inputted time")
        }
    }
}