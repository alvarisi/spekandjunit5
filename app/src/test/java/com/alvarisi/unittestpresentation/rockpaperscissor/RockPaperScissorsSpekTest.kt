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
            beforeEachTest {
                rockPaperScissors.addMove(Player.ONE, Move.ROCK)
            }
            context("And Player Two Playing Paper") {
                beforeEach {
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

            context("And Player two playing scissors") {
                beforeEach {
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

            context("And Player two playing rock") {
                beforeEach {
                    rockPaperScissors.addMove(Player.TWO, Move.ROCK)
                }
                it(description = "No one won") {
                    Assertions.assertThat(
                        rockPaperScissors.getWinner()
                    ).isEqualTo(
                        Player.UNKNOWN
                    )
                }
            }

            context("And Player Two not playing yet") {
                it(description = "No one won") {
                    Assertions.assertThat(
                        rockPaperScissors.getWinner()
                    ).isEqualTo(
                        Player.UNKNOWN
                    )
                }
            }
        }

        context("When Player One Playing Paper") {
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

            context("When Player Two Playing Paper") {
                beforeEachTest {
                    rockPaperScissors.addMove(Player.TWO, Move.PAPER)
                }

                it(description = "No one won") {
                    Assertions.assertThat(
                        rockPaperScissors.getWinner()
                    ).isEqualTo(
                        Player.UNKNOWN
                    )
                }
            }

            context("When Player Two Playing Scissor") {
                beforeEachTest {
                    rockPaperScissors.addMove(Player.TWO, Move.SCISSORS)
                }

                it(description = "Declare Player Two Win") {
                    Assertions.assertThat(
                        rockPaperScissors.getWinner()
                    ).isEqualTo(
                        Player.TWO
                    )
                }
            }


            context("And Player Two not playing yet") {
                it(description = "No one won") {
                    Assertions.assertThat(
                        rockPaperScissors.getWinner()
                    ).isEqualTo(
                        Player.UNKNOWN
                    )
                }
            }
        }
    }
})