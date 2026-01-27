package wordle.domain

/**
 * 현재 라운드를 의미합니다.
 */
@JvmInline
value class Round(
    private val value: Int = 1
) {
    init {
        require(0 < value) { "라운드는 1보다 커야합니다." }
    }

    /**
     * Round 증감을 합니다.
     *
     * @return 현재 Round에서 1이 증감된 값
     */
    fun next(): Round {
        return Round(this.value + 1)
    }

    /**
     * 이 라운드 값이 전달된 라운드보다 큰지 여부를 반환합니다.
     *
     * @param round 비교 대상이 되는 라운드 값
     * @return 이 라운드 값이 round보다 크면 true
     */
    fun isGreaterThanRound(round: Int): Boolean {
        return this.value > round
    }

    /**
     * 해당 라운드의 값을 반환합니다.
     */
    fun getValue(): Int {
        return value
    }
}
