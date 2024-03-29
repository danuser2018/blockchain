package me.danuser2018.blockchain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class ValidationTest : StringSpec({
    "isValid() returns false for an empty list" {
        val chain = emptyList<Block<String>>()
        chain.isValid() shouldBe false
    }

    "isValid() returns true for an empty chain (only has a genesis block)" {
        val chain = emptyBlockchain<String>(System.currentTimeMillis())
        chain.isValid() shouldBe true
    }

    "isValid() returns false for an empty chain where the only element is not a genesis block" {
        val chain = emptyList<Block<String>>().createBlock(
            System.currentTimeMillis(),
            2.0,
            "a hash",
            "Hola mundo"
        )
        chain.isValid() shouldBe false
    }

    "isValid() returns true for a valid chain" {
        val chain = with(emptyBlockchain<String>(System.currentTimeMillis())) {
            this.createBlock(
                timestamp = System.currentTimeMillis(),
                proof = 57870.0,
                previousHash = this[0].hash(),
                data = "Hola mundo"
            )
        }
        chain.isValid() shouldBe true
    }

    "isValid() returns false if the link is broken" {
        val chain = with(emptyBlockchain<String>(System.currentTimeMillis())) {
            this.createBlock(
                timestamp = System.currentTimeMillis(),
                proof = 57870.0,
                previousHash = "previous_hash",
                data = "hola mundo"
            )
        }
        chain.isValid() shouldBe false
    }

    "isValid() returns false if there is not a valid proof of work" {
        val chain = with(emptyBlockchain<String>(System.currentTimeMillis())) {
            this.createBlock(
                timestamp = System.currentTimeMillis(),
                proof = 5.0,
                previousHash = this[0].hash(),
                data = "Hola mundo"
            )
        }
        chain.isValid() shouldBe false
    }
})