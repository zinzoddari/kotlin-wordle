package wordle

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import wordle.domain.Results
import wordle.domain.Word
import wordle.domain.WordResolver
import wordle.domain.Wordle

class WordleTest {

    val answer = Word("apple")
    val resolver: WordResolver = WordResolver(answer)

    @Test
    @DisplayName("전달받은 단어로 결과를 반환한다")
    fun test01() {
        // arrange
        val wordle = Wordle(resolver)
        val word = Word("testt")

        val expected: Results = Results(
            listOf(
                wordle.domain.Result.ABSENT,
                wordle.domain.Result.PRESENT,
                wordle.domain.Result.ABSENT,
                wordle.domain.Result.ABSENT,
                wordle.domain.Result.ABSENT
            )
        )

        // act
        val sut: Results = wordle.round(word)

        // assert
        assertThat(sut).isEqualTo(expected)
    }
}
