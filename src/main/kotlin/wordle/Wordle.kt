package wordle

import wordle.domain.Results
import wordle.domain.Word
import wordle.domain.WordResolver

class Wordle(
    private val resolver: WordResolver
) {
    fun round(word: Word): Results {
        return resolver.check(word)
    }
}
