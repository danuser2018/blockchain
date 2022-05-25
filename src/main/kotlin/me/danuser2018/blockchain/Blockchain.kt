package me.danuser2018.blockchain

import java.io.Serializable

typealias Blockchain = List<Block>

fun emptyBlockchain(timestamp: Long) = listOf(GenesisBlock(timestamp))

fun <T : Serializable> Blockchain.createBlock(timestamp: Long, proof: ProofOfWork, previousHash: String, data: T): Blockchain =
    toMutableList() + DataBlock(
        index = size,
        timestamp = timestamp,
        proof = proof,
        previousHash = previousHash,
        data
    )




