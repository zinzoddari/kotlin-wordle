package wordle

import wordle.domain.Results
import wordle.translation.ResultsConverter

class WordleResults(
    private val value: MutableList<Results> = mutableListOf()
) {
    fun add(results: Results) {
        value.add(results)
    }

    fun display(): String {
        val stringBuilder: StringBuilder = StringBuilder()

        value.forEach { stringBuilder.append(ResultsConverter.convert(it)).append("\n") }

        return stringBuilder.toString().trim()
    }
}
