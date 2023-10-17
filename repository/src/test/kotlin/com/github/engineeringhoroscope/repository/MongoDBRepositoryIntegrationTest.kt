package com.github.engineeringhoroscope.repository

import com.github.engineeringhoroscope.bl.model.Prophecy

fun main() {
    val m = MongoDBRepository()
    println("adding prophecy:")
    m.addProphecy(Prophecy(text = "FooBar"))
    println("existing prophecies:")
    println(m.getProphecies())
}