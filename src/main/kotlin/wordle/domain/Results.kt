package wordle.domain

/**
 * Wordle 한 판에 대한 결과 목록을 관리하는 객체입니다.
 */
@JvmInline
value class Results(
    val values: List<Result>
) {
    /**
     * 정답 여부를 확인합니다.
     *
     * @return 정답 여부
     */
    fun isAnswer(): Boolean {
        return values.all { it == Result.CORRECT }
    }

    /**
     * 값을 가져옵니다.
     *
     * @return 결과 목록
     */
    fun getValues(): List<Result> {
        return values
    }
}
