package com.alvarisi.unittestpresentation.calculator

class Calculator {
    fun add(x: Int, y: Int) = x + y
    fun subtract(x: Int, y: Int) = x - y
    fun divide(x: Int, y: Int): Int {
        if (y == 0) {
            throw IllegalArgumentException()
        }
        return x / y
    }
}