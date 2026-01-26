package wordle

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import wordle.domain.TodayWordExtractor
import wordle.domain.Word
import wordle.translation.WordBookExtractor
import java.time.LocalDate

class TodayWordExtractorTest {
    val fileName: String = "testWord.txt"
    val wordBookExtractor = WordBookExtractor.create(fileName)

    @Test
    fun 오늘의_단어를_반환한다() {
        // arrange
        val todayWordExtractor = TodayWordExtractor(wordBookExtractor)
        val today: LocalDate = LocalDate.of(2021, 6, 19)
        val expected = Word("zin")

        // act
        val sut: Word = todayWordExtractor.generateAnswer(today)

        // assert
        assertThat(sut).isEqualTo(expected)
    }
}
