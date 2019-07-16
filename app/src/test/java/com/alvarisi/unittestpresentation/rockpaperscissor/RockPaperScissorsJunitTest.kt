package com.alvarisi.unittestpresentation.rockpaperscissor

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.*

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class RockPaperScissorsJunitTest {
    private val rockPaperScissors: RockPaperScissors = RockPaperScissors()
    @Nested
    @DisplayName("Two People playing Rock Paper Scissor")
    inner class PlayingRockPaperScissor {
        @Nested
        @DisplayName("When Player One Playing Rock")
        inner class PlayerOnePlayingRock {
            @BeforeEach
            fun `set up player one move rock`() {
                println("Set up player one")
                rockPaperScissors.addMove(Player.ONE, Move.ROCK)
            }

            @Nested
            @DisplayName("When player Two Playing Paper")
            inner class PlayerTwoPlayingPapper {
                @BeforeEach
                fun `set up player two move papper`() {
                    println("Set up player two")
                    rockPaperScissors.addMove(Player.TWO, Move.PAPER)
                }

                @Test
                fun `Declare player two win`() {
                    println("The test")
                    Assertions.assertThat(rockPaperScissors.getWinner())
                        .isEqualTo(Player.TWO)
                }
            }
        }
    }
}