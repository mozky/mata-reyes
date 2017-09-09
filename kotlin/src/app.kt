import java.security.InvalidParameterException

/**
* Created by moz on 09/09/2017.
*/
fun main(args: Array<String>) {
    println("MATA REYES\n")

    val deck = Deck()
    println(deck.getDeckState())
}

enum class Face(val num: Int) {
    ACE(1), TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9), TEN(10), JACK(11), QUEEN(12), KING(13);

    companion object {
        fun fromInt(num: Int): Face {
            try {
                return values()[num - 1]
            } catch (e: Exception) {
                throw InvalidParameterException("Invalid parameter for Face.fromInt(), value: " + (e.localizedMessage.toInt() + 1))
            }
        }
    }
}

enum class Suit(val num: Int) {
    HEARTS(1), DIAMONDS(2), CLUBS(3), SPADES(4);

    companion object {
        fun fromInt(num: Int): Suit {
            try {
                return values()[num - 1]
            } catch (e: Exception) {
                throw InvalidParameterException("Invalid parameter for Suit.fromInt(), value: " + (e.localizedMessage.toInt() + 1))
            }
        }
    }
}

enum class CardState {
    DECKED, OPEN, CLOSED, DEAD
}

data class Card(
        val face: Face,
        val suit: Suit,
        val state: CardState = CardState.DECKED
)

class Deck {
    init {
        println("Deck init...")
    }

    private var _cards: Array<Card> = Array(52, {
        index ->
        run {
            Card(Face.fromInt((index % 13) + 1), Suit.fromInt(index / 13 + 1))
        }
    })

    fun getDeckState(): String {
        return _cards.joinToString(separator = ", \n", transform = { "${it.face} of ${it.suit} - ${it.state}" })
    }
}