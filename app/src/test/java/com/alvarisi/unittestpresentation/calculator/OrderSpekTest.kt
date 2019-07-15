package com.alvarisi.unittestpresentation.calculator

import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe

class OrderSpekTest : Spek({
    beforeGroup {
        println("A")
    }

    describe("some group"){
        beforeEachTest {
            println("B")
        }
        beforeEach {
            println("C")
        }
        it("some test"){
            println("D")
        }
        it("another test"){
            println("E")
        }
        afterEachTest {
            println("F")
        }
    }

    afterGroup {
        println("H")
    }
})