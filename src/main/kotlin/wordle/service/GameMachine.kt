package wordle.service

import wordle.domain.Results
import wordle.domain.Round
import wordle.domain.TodayWordExtractor
import wordle.domain.Word
import wordle.domain.WordBook
import wordle.domain.WordValidator
import wordle.domain.Wordle
import wordle.domain.WordleResults
import wordle.io.Printer
import wordle.io.Scanner
import wordle.translation.WordBookExtractor
import java.time.LocalDate

class GameMachine(
    private val wordBook: WordBook = WordBookExtractor.extract("words.txt"),
    private val todayWord: Word = TodayWordExtractor(wordBook).generateAnswer(LocalDate.now())
) {
    private val wordValidator: WordValidator = WordValidator(wordBook)

    fun start(count: Int) {
        // Wordle.round 호출하기
        var round = Round()
        val wordleResults = WordleResults()

        // 소개 하기
        Printer.introduce()
        while (!round.isGreaterThan(count)) {
            round = round.increment()

            val wordle = Wordle(wordValidator, todayWord)

            val results: Results = wordle.round(requestWord())

            wordleResults.add(results)

            // 게임 머신이 게임 진행 여부 판단하기
            if (results.isAnswer()) {
                break
            }

            // TODO: 마지막 판이면 viewTile 호출 X
            Printer.viewTile(wordleResults.display())
        }

        // 최종 결과 출력하기
        // TODO: Printer를 이용해 결과 출력하기
        Printer.result(count, round.value, wordleResults.display())
    }

    private fun requestWord(): Word {
        Printer.requestInput()

        return Word(Scanner.input())
    }
}