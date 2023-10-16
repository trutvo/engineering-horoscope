package com.github.engineeringhoroscope.bl.model

import java.util.UUID

data class Prophecy(
        val uuid: String = UUID.randomUUID().toString(),
        val text: String)
