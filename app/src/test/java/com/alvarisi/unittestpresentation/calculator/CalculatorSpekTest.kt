package com.alvarisi.unittestpresentation.calculator

import org.assertj.core.api.Assertions
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe

internal class CalculatorSpekTest : Spek({
    describe("a calculator") {

        val calculator by memoized { Calculator() }

        describe("addition") {
            val result by memoized { calculator.add(2, 4) }
            it("2 + 4 = 6") {
                Assertions.assertThat(result)
                    .isEqualTo(6)
            }
        }

        describe("divider"){

        }
    }
})