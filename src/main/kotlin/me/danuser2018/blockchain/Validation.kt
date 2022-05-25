package me.danuser2018.blockchain

tailrec fun Blockchain.isValid(index: Int = this.size - 1): Boolean {
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

private infix fun Block.isLinkedTo(block: Block): Boolean = (this.previousHash == block.hash())
private infix fun Block.hasAProofFor(block: Block): Boolean = isAValidProof(this.proof, block.proof)

