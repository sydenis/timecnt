const val SEC_IN_MINUTE = 60U
val SEC_IN_HOUR = SEC_IN_MINUTE * SEC_IN_MINUTE
val SEC_IN_DAY = SEC_IN_HOUR * 24U

fun main() {
    agoToText(SEC_IN_MINUTE - 1U)
    agoToText(SEC_IN_HOUR - 9U * SEC_IN_MINUTE)
    agoToText(SEC_IN_DAY - 2U * SEC_IN_HOUR)
    agoToText(2U * SEC_IN_DAY - 1U)
    agoToText(3U * SEC_IN_DAY - 1U)
    agoToText(4U * SEC_IN_DAY)
}

fun agoToText(ago: UInt) {
    val delay =  when {
        (ago <= SEC_IN_MINUTE) -> "только что"
        (ago <= SEC_IN_HOUR) -> agoToMin(ago)
        (ago <= SEC_IN_DAY) -> agoToHour(ago)
        (ago <= 2U * SEC_IN_DAY) -> "сегодня"
        (ago <= 3U * SEC_IN_DAY) -> "вчера"
        else -> "давно"
    }

    println("Был $delay")
}

fun agoToMin(ago: UInt): String {
    val result = ago / SEC_IN_MINUTE

    val term = when (result % 10U) {
        1U -> "у"
        2U,3U,4U -> "ы"
        else -> ""
    }

    return "$result минут$term назад"
}

fun agoToHour(ago: UInt): String {
    val result = ago / SEC_IN_HOUR

    val term = when (result % 10U) {
        1U -> ""
        2U,3U,4U -> "а"
        else -> "ов"
    }

    return "$result час$term назад"
}
