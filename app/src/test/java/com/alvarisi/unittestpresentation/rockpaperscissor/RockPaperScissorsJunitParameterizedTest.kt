package com.alvarisi.unittestpresentation.rockpaperscissor

import com.annimon.stream.Stream
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.*

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class RockPaperScissorsJunitParameterizedTest {
    private val rockPaperScissors: RockPaperScissors = RockPaperScissors()


    private fun testCases() = Arrays.stream(
        arrayOf(
            PlayingEvent(Move.ROCK, Move.SCISSORS, Player.ONE)
        )
    )


    @ParameterizedTest
    @MethodSource("testCases")
    fun `player playing rock paper scissor`(playingEvent: PlayingEvent) {
        rockPaperScissors.addMove(Player.ONE, playingEvent.playerOneMove)
        rockPaperScissors.addMove(Player.TWO, playingEvent.playerTwoMove)
        Assertions.assertThat(
            rockPaperScissors.getWinner()
        ).isEqualTo(
            playingEvent.winner
        )
    }
}

data class PlayingEvent(
    val playerOneMove: Move,
    val playerTwoMove: Move,
    val winner: Player
)