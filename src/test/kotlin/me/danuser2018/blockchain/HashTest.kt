package me.danuser2018.blockchain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import me.danuser2018.blockchain.Block.DataBlock

class HashTest: StringSpec({

    "Block's hash should be the result of apply SHA256 over a base64 of a json version of the block" {
        val block = DataBlock(
            index = 1,
            timestamp = 0L,
            proof = 1.0,
            previousHash = "0",
            data = "Hola mundo"
        )

        val expected = "41a4e16eb4f5380d6f1bb44a56cdb5189feee7939763a86744000f38562571e0"

        block.hash() shouldBe expected
    }

    "ProofOfWork's hash should be the result of apply SHA256 over a string version of the block" {
        val proof = 1.0
        val expected = "842f0ffb120a57d8304e656ea205e4d26c8f172d70a4431948523f14049418e6"

        proof.hash() shouldBe expected
    }

})