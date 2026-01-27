package wordle

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import wordle.domain.Word
import wordle.translation.WordBookExtractor
import java.time.LocalDate

class WordGeneratorTest {
    val fileName: String = "testWord.txt"
    val wordExtractor = WordBookExtractor.extract(fileName)

    @Test
    fun 오늘의_단어를_반환한다() {
        // arrange
        val wordGenerator = WordGenerator(wordExtractor)
        val today: LocalDate = LocalDate.of(2021, 6, 19)
        val expected = Word("zin")

        // act
        val sut: Word = wordGenerator.generateAnswer(today)

        // assert
        assertThat(sut).isEqualTo(expected)
    }
}
