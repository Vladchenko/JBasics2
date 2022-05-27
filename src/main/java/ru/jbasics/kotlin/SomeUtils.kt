package ru.jbasics.kotlin

import java.lang.Double.NEGATIVE_INFINITY
import kotlin.math.pow

/**
 * Do not know how to check if this code is correct, since cannot run it in terminal.
 */
object SomeUtils {

    @Throws(IllegalArgumentException::class)
    fun calculateTwoNumbers(): Double {
        val argument1 = retrieveNumber(readLine())
        val argument2 = retrieveNumber(readLine())
        val operation = readLine()
        val availableOperations = "%^&|*-+"
        return calculateTwoNumbers(argument1, argument2, operation, availableOperations)
    }

    @Throws(IllegalArgumentException::class)
    fun calculateTwoNumbers(
        argument1: Double,
        argument2: Double,
        operation: String?,
        availableOperations: String
    ): Double {
        checkOperation(operation, availableOperations)
        return when (operation) {
            "%" -> argument1 % argument2
            "^" -> argument1.pow(argument2)
            "&" -> (argument1.toInt() and argument2.toInt()).toDouble()
            "|" -> (argument1.toInt() or argument2.toInt()).toDouble()
            "-" -> argument1 - argument2
            "+" -> argument1 + argument2
            "*" -> argument1 * argument2
            else -> NEGATIVE_INFINITY
        }
    }

    @Throws(IllegalArgumentException::class)
    private fun retrieveNumber(argument: String?) =
        argument.toString().toDoubleOrNull() ?: throw IllegalArgumentException("Argument is not a number")

    @Throws(IllegalArgumentException::class)
    private fun checkOperation(operation: String?, availableOperations: String) =
        if (operation.isNullOrBlank() && operation.toString() !in availableOperations) {
            throw IllegalArgumentException("Wrong operation")
        } else {
            true
        }
}
