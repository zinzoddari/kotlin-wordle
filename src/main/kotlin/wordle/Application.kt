package wordle

class Application {

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            GameMachine().start(6)
        }
    }
}
