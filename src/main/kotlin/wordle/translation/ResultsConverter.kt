package wordle.translation

import wordle.domain.Result
import wordle.domain.Results

class ResultsConverter {

    companion object {
        fun convert(results: Results): String {
            val builder = StringBuilder()
            for (result in results.getValues()) {
                builder.append(when (result) {
                    Result.ABSENT -> "⬜"
                    Result.PRESENT -> "🟨"
                    else -> "🟩"
                })
            }
            return builder.toString()
        }
    }
}