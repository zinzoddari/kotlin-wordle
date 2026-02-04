package wordle.io

interface Printer {
    fun introduce()

    fun requestInput()

    fun viewTile(tile: String)

    fun result(count: Int, currentCount: Int, tile: String)

    fun error(message: String)
}
