package wordle

import wordle.domain.WordBook

class WordValidator(
    private val wordBook: WordBook
) {
    fun validate(word: Word) {
        require(word.value.length == 5) { "입력값은 5글자여야 합니다." }

        require(REGEX.matches(word.value)) { "입력값은 영어여야 합니다." }

        require(wordBook.exists(word)) { "입력값은 단어장에 존재하는 단어여야합니다." }
    }

    companion object {
        private val REGEX = Regex("^[a-zA-Z]*$")
    }
}
