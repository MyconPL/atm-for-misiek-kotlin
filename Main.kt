import java.util.Scanner
// Code by mrherbat (MyconPL on GitHub)
var value: Float = 0f
var transactionType: Int = 0

fun transaction_types() {
    println("\nSelect transaction type:")
    println("1. Deposit")
    println("2. Withdraw")
    println("3. Exit")
}

class User {
    private var accountBalance: Float = 0f

    fun setAccountBalance(setterValue: Float) {
        accountBalance = setterValue
    }

    fun getAccountBalance(): Float {
        return accountBalance
    }

    fun withdraw(transactionValue: Float) {
        if (withdrawalSufficientFunds(transactionValue)) {
            accountBalance -= transactionValue
        } else {
            println("Insufficient funds")
        }
    }

    fun deposit(transactionValue: Float) {
        accountBalance += transactionValue
    }

    private fun withdrawalSufficientFunds(transactionValue: Float): Boolean {
        return accountBalance > transactionValue
    }
}

fun userContinuesTransaction(): Boolean { // stops program when user selects option 3 (exit program)
    return transactionType != 3
}

fun main() {
    val scanner = Scanner(System.`in`)

    // Code by mrherbat (MyconPL on GitHub)
    println("************** TAMUS-FINANCES *************")

    val tomek = User()
    tomek.setAccountBalance(300f) // bieda bo studia

    do {
        transaction_types()
        print("Type: ")
        transactionType = scanner.nextInt()

        when (transactionType) {
            1 -> { // deposit
                println("How much you want to deposit?")
                value = scanner.nextFloat()
                if (value >= 0) {
                    tomek.deposit(value)
                    println("Your current account balance is ${tomek.getAccountBalance()}")
                } else {
                    println("Invalid value. Please enter correct transaction value")
                }
            }
            2 -> { // withdraw
                println("How much you want to withdraw?")
                value = scanner.nextFloat()
                if (value >= 0) {
                    tomek.withdraw(value)
                    println("Your current account balance is ${tomek.getAccountBalance()}")
                } else {
                    println("Invalid value. Please enter correct transaction value")
                }
            }
            3 -> { // exit
                break
            }
            else -> {
                println("Invalid transaction type. Please enter correct number")
            }
        }
    } while (userContinuesTransaction())
}
