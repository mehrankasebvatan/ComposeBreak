package ir.kasebvatan.ext_functions

val Int.minutes: Int
    get() = this / 60


val Int.seconds: Int
    get() = this % 60