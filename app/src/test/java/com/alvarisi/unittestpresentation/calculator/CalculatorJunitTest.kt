package com.alvarisi.unittestpresentation.calculator

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.*

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CalculatorJunitTest {
    val calculator: Calculator = Calculator()

    @Nested
    @DisplayName("Addition Schenario")
    inner class Addition {
        @Test
        fun `2 + 4 = 6`() {
            val result = calculator.add(2, 4)
            Assertions.assertThat(result).isEqualTo(6)
        }
    }
}

