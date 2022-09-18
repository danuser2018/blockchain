package me.danuser2018.blockchain

import me.danuser2018.blockchain.Block.DataBlock
import me.danuser2018.blockchain.Block.GenesisBlock
import java.io.Serializable

typealias Blockchain<T> = List<Block<T>>

fun <T : Serializable> emptyBlockchain(timestamp: Long) = listOf(GenesisBlock<T>(timestamp))

fun <T : Serializable> Blockchain<T>.createBlock(
    timestamp: Long,
    proof: ProofOfWork,
    previousHash: String,
    data: T
): Blockchain<T> =
    toMutableList() + DataBlock(
        index = size,
        timestamp = timestamp,
        proof = proof,
        previousHash = previousHash,
        data
    )




