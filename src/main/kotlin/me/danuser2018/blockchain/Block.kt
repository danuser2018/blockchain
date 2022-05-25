package me.danuser2018.blockchain

import java.io.Serializable

sealed class Block(
    open val index: Int,
    open val timestamp: Long,
    open val proof: ProofOfWork,
    open val previousHash: String
)

data class GenesisBlock(
    override val timestamp: Long
) : Block(
    index = 0,
    timestamp = timestamp,
    proof = 1.0,
    previousHash = "0"
)

data class DataBlock<T : Serializable>(
    override val index: Int,
    override val timestamp: Long,
    override val proof: ProofOfWork,
    override val previousHash: String,
    val data: T
) : Block(index, timestamp, proof, previousHash)






