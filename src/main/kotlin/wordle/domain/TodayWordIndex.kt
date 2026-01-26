package wordle.domain

import java.time.LocalDate

data class TodayWordIndex(
    val value: Int
) {
    companion object {
        private const val MIN_INDEX: Int = 0
        private val BASE_DATE: LocalDate = LocalDate.of(2021, 6, 19)

        fun create(date: LocalDate, arraySize: Int): TodayWordIndex {
            return extract(date, arraySize)
        }

        private fun extract(date: LocalDate, arraySize: Int): TodayWordIndex {
            val result = calculate(date, arraySize)

            if (result < MIN_INDEX) {
                return TodayWordIndex(MIN_INDEX)
            }

            return TodayWordIndex(result)
        }

        private fun calculate(date: LocalDate, arraySize: Int): Int {
            return ((date.toEpochDay() - BASE_DATE.toEpochDay()) % arraySize).toInt()
        }
    }
}