package com.alvarisi.unittestpresentation.rockpaperscissor

import org.assertj.core.api.Assertions
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe


internal class RockPaperScissorsSpekTest : Spek({
    describe("Two People playing Rock Paper Scissor") {
        val rockPaperScissors by memoized {
            RockPaperScissors()
        }
        context("When Player One Playing Rock") {
            beforeEach {
                rockPaperScissors.addEvent(Player.ONE, Move.ROCK)
            }

            context("When Player Two Playing Paper") {
                beforeEachTest {
                    rockPaperScissors.addEvent(Player.TWO, Move.PAPER)
                }

                it(description = "Declare Player Two Win") {
                    Assertions.assertThat(
                        rockPaperScissors.getWinner()
                    ).isEqualTo(
                        Player.TWO
                    )
                }
            }
        }
    }
})