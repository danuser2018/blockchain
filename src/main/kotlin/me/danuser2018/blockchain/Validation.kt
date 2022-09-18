package me.danuser2018.blockchain

import me.danuser2018.blockchain.Block.GenesisBlock
import java.io.Serializable

tailrec fun <T : Serializable> Blockchain<T>.isValid(index: Int = this.size - 1): Boolean {
    val isValid = when {
        this.isEmpty() -> false
        index == 0 -> this[index] is GenesisBlock
        else -> {
            val curr = this[index]
            val prev = this[index - 1]
            (curr isLinkedTo prev) and (curr hasAProofFor prev)
        }
    }
    return if (isValid && index > 0) this.isValid(index - 1) else isValid
}

private infix fun <T : Serializable> Block<T>.isLinkedTo(block: Block<T>): Boolean = (this.previousHash == block.hash())
private infix fun <T : Serializable> Block<T>.hasAProofFor(block: Block<T>): Boolean =
    isAValidProof(this.proof, block.proof)

