package com.alvarisi.unittestpresentation.rockpaperscissor

class RockPaperScissors {
    private val players = mutableMapOf<Player, Move>(
        Player.ONE to Move.UNDEFINED,
        Player.TWO to Move.UNDEFINED
    )

    fun addEvent(player: Player, move: Move) {
        players[player] = move
    }

    fun getWinner(): Player {
        if (players[Player.ONE] != null && players[Player.TWO] != null) {
            val result = players[Player.ONE]!!.fight(players[Player.TWO]!!)
            return result?.let {
                when (result) {
                    players[Player.ONE] -> {
                        Player.ONE
                    }
                    players[Player.TWO] -> {
                        Player.TWO
                    }
                    else -> {
                        Player.UNKNOWN
                    }
                }
            } ?: Player.UNKNOWN
        } else {
            return Player.UNKNOWN
        }
    }

}

private val rules = mapOf(
    Move.ROCK to Move.SCISSORS,
    Move.PAPER to Move.ROCK,
    Move.SCISSORS to Move.PAPER
)

enum class Move {
    ROCK, PAPER, SCISSORS, UNDEFINED;

    fun fight(other: Move): Move? {
        if (rules[this] == other) {
            return this
        }
        if (rules[other] == this) {
            return other
        }
        return null
    }
}

enum class Player {
    ONE, TWO, UNKNOWN;

}