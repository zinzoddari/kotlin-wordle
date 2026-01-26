package wordle.domain

class Wordle(
    private val validator: WordValidator,
    private val todayWord: Word
) {
    fun round(word: Word): Results {
        validator.validate(word)

        return WordResolver(todayWord).check(word)
    }
}