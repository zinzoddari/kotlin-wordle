package wordle

import wordle.domain.Results
import wordle.domain.Word

class Wordle(
    private val resolver: WordResolver
) {
    fun round(word: Word): Results {
        return Results(resolver.check(word))
    }
}
