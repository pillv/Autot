import kotlin.math.max

const val ERROR_LIMIT = -1.0
const val ERROR_TYPE = -2.0

fun main() {
    println(transaction("Mastercard", 450, 6000))
}
fun transaction (card: String, transfersEarlier: Int = 0, amount: Int): Int {
    if (amount > 150000 || transfersEarlier+amount > 6000000 || card =="VK Pay"&&( transfersEarlier+amount > 4000000)) return -1

    return when (card) {
        "Mastercard", "Maestro" -> if (transfersEarlier+amount in 300..75000) 0 else (amount*0.0006+20).toInt()
        "Visa", "Мир" -> (max(amount*0.0075, 35.0)).toInt()
        "VK Pay" -> 0
        else -> -2
    }

}