package com.alvarisi.unittestpresentation.rockpaperscissor

import org.assertj.core.api.Assertions
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe

class RockPaperScissorsSpekParameterizedTest : Spek({
    val rockPaperScissors by memoized {
        RockPaperScissors()
    }

    val testCases = mapOf(
        Pair(Move.ROCK, Move.SCISSORS) to Player.ONE,
        Pair(Move.ROCK, Move.PAPER) to Player.TWO
    )

    testCases.forEach { moves, winner ->
        describe("${moves.first} ${moves.second}") {
            before {
                rockPaperScissors.addMove(Player.ONE, moves.first)
                rockPaperScissors.addMove(Player.TWO, moves.second)
            }

            it("winner is $winner") {
                Assertions.assertThat(
                    rockPaperScissors.getWinner()
                ).isEqualTo(
                    winner
                )
            }
        }
    }
})