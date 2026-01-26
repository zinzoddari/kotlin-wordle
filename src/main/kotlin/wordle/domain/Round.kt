package wordle.domain

@JvmInline
value class Round(
    val value: Int = 1
) {

    fun increment(): Round {
        return Round(this.value + 1)
    }

    fun isGreaterThan(currentRound: Int): Boolean {
        return currentRound < this.value
    }
}