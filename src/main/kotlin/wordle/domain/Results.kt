package wordle.domain

@JvmInline
value class Results(
    private val values: List<Result>
) {
    fun isAnswer(): Boolean {
        return values.all { it == Result.CORRECT }
    }

    fun getValues(): List<Result> {
        return values
    }
}