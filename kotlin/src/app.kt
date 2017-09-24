import java.security.InvalidParameterException

/**
* Created by moz on 09/09/2017.
*/
fun main(args: Array<String>) {
    println("MATA REYES\n")

    val deck = Deck()

    println(deck.drawCard("moz"))
    println(deck.drawCard("berny"))

    println(deck.getDeckState())

}

