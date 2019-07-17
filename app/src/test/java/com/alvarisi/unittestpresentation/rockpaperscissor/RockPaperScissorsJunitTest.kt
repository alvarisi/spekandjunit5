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
                rockPaperScissors.addMove(Player.ONE, Move.ROCK)
            }

            @Nested
            @DisplayName("When Player Two Playing Scissors")
            inner class PlayerTwoPlayingScissors{
                @BeforeEach
                fun `set up player two move scissors`(){
                    rockPaperScissors.addMove(Player.TWO, Move.SCISSORS)
                }

                @Test
                fun `Declare player One win`() {
                    Assertions.assertThat(rockPaperScissors.getWinner())
                        .isEqualTo(Player.ONE)
                }
            }

            @Nested
            @DisplayName("When Player Two Playing Paper")
            inner class PlayerTwoPlayingPapper {
                @BeforeEach
                fun `set up player two move papper`() {
                    rockPaperScissors.addMove(Player.TWO, Move.PAPER)
                }

                @Test
                fun `Declare player two win`() {
                    Assertions.assertThat(rockPaperScissors.getWinner())
                        .isEqualTo(Player.TWO)
                }
            }

            @Nested
            @DisplayName("When Player Two Playing Rock ")
            inner class PlayerTwoPlayingRock {
                @BeforeEach
                fun `set up player two move rock`() {
                    rockPaperScissors.addMove(Player.TWO, Move.ROCK)
                }

                @Test
                fun `Declare no one wins`() {
                    Assertions.assertThat(rockPaperScissors.getWinner())
                        .isEqualTo(Player.UNKNOWN)
                }
            }

        }
    }
}