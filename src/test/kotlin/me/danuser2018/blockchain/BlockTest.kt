package me.danuser2018.blockchain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe


class BlockTest : StringSpec({
    "GenesisBlock is a block that can start a chain" {
        val now = System.currentTimeMillis()
        GenesisBlock(now).apply {
            index shouldBe 0
            proof shouldBe 1.0
            timestamp shouldBe now
            previousHash shouldBe "0"
        }
    }
})