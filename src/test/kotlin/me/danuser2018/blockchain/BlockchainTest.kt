package me.danuser2018.blockchain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.should
import io.kotest.matchers.shouldBe
import io.kotest.matchers.types.beInstanceOf
import me.danuser2018.blockchain.Block.DataBlock
import me.danuser2018.blockchain.Block.GenesisBlock

class BlockchainTest : StringSpec({
    "emptyBlockChain() returns a new Blockchain with only the genesis block" {
        val now = System.currentTimeMillis()
        emptyBlockchain<String>(now).apply {
            size shouldBe 1
            this[0] should beInstanceOf<GenesisBlock<String>>()
            this[0].timestamp shouldBe now
        }
    }

    "createBlock() returns a new Blockchain with a new element" {
        val now = System.currentTimeMillis()
        val data = "Hola mundo"
        emptyBlockchain<String>(System.currentTimeMillis()).createBlock(
            timestamp = now,
            proof = 2.0,
            previousHash = "previous_hash",
            data = data
        ).apply {
            size shouldBe 2
            this[0] should beInstanceOf<GenesisBlock<String>>()
            this[1] should beInstanceOf<DataBlock<String>>()
            with (this[1] as DataBlock<String>) {
                index shouldBe 1
                timestamp shouldBe now
                proof shouldBe 2.0
                previousHash shouldBe "previous_hash"
                data shouldBe "Hola mundo"
            }
        }
    }
})