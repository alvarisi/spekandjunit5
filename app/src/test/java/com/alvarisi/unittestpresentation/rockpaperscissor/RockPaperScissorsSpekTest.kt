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
                rockPaperScissors.addMove(Player.ONE, Move.ROCK)
            }

            context("When Player Two Playing Paper") {
                beforeEachTest {
                    rockPaperScissors.addMove(Player.TWO, Move.PAPER)
                }

                it(description = "Declare Player Two Win") {
                    Assertions.assertThat(
                        rockPaperScissors.getWinner()
                    ).isEqualTo(
                        Player.TWO
                    )
                }
            }

            context("When Player two playing scissors") {
                beforeEachTest {
                    rockPaperScissors.addMove(Player.TWO, Move.SCISSORS)
                }

                it(description = "Declare Player One Win") {
                    Assertions.assertThat(
                        rockPaperScissors.getWinner()
                    ).isEqualTo(
                        Player.ONE
                    )
                }
            }
        }

        context("When Player One Playing Paper"){
            beforeEach {
                rockPaperScissors.addMove(Player.ONE, Move.PAPER)
            }

            context("When Player Two Playing Rock") {
                beforeEachTest {
                    rockPaperScissors.addMove(Player.TWO, Move.ROCK)
                }

                it(description = "Declare Player One Win") {
                    Assertions.assertThat(
                        rockPaperScissors.getWinner()
                    ).isEqualTo(
                        Player.ONE
                    )
                }
            }
        }

        context("When Player One Playing Paper"){
            beforeEach {
                rockPaperScissors.addMove(Player.ONE, Move.PAPER)
            }

            context("When Player Two Playing Rock") {
                beforeEachTest {
                    rockPaperScissors.addMove(Player.TWO, Move.ROCK)
                }

                it(description = "Declare Player One Win") {
                    Assertions.assertThat(
                        rockPaperScissors.getWinner()
                    ).isEqualTo(
                        Player.ONE
                    )
                }
            }
        }
    }
})