package wordle

import wordle.domain.Results
import wordle.domain.Word
import wordle.domain.WordBook
import wordle.domain.TodayWordExtractor
import wordle.domain.WordValidator
import wordle.io.Printer
import wordle.io.Scanner
import wordle.translation.WordBookExtractor
import java.time.LocalDate


class GameMachine(
    private val count: Int
) {

    fun start() {
        // 오늘 단어를 단어장에서 추출
        val wordBook: WordBook = WordBookExtractor.extract(WORDS_FILE_NAME)
        val todayWordExtractor = TodayWordExtractor(wordBook)
        val todayWord: Word = todayWordExtractor.generateAnswer(LocalDate.now())

        // 소개 하기
        Printer.introduce()

        // Wordle.round 호출하기
        var currentCount: Int = 0
        val wordleResults = WordleResults()
        while (currentCount < count) {
            currentCount++

            // TODO: Printer랑 Scanner를 합친 객체가 있으면 어떨지
            // 입력 요청 메세지 (Scanner vs Printer)
            Printer.requestInput()
            // 게임머신에서 사용자 입력 받기
            val input = Word(Scanner.input())
            // 입력값 검증하기
            try {
                WordValidator(wordBook).validate(input)
            } catch (e: Exception) {
                continue
            }

            val resolver: WordResolver = WordResolver(todayWord)
            val results: Results = Wordle(resolver).round(input)
            wordleResults.add(results)

            // 게임 머신이 게임 진행 여부 판단하기
            if (results.isAnswer()) {
                break
            }

            Printer.viewTile(wordleResults.display())
        }

        // 최종 결과 출력하기
        Printer.result(count, currentCount, wordleResults.display())
    }

    companion object {
        const val WORDS_FILE_NAME = "words.txt"
    }
}
