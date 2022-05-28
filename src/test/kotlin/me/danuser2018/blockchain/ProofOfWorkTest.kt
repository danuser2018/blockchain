package me.danuser2018.blockchain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.string.shouldStartWith
import org.apache.commons.codec.digest.DigestUtils
import java.lang.Math.random
import kotlin.math.pow

class ProofOfWorkTest : StringSpec({
    "proofOfWork() returns a value that meet the expectations" {
        val seed = random()
        proofOfWork(
            seed = seed,
            f = { a, b -> (a.pow(2) - b.pow(2)).let { DigestUtils.sha256Hex(it.toString()) } },
            isValid = { it.startsWith("0000") }
        ).apply {
            val hash = (this.pow(2) - seed.pow(2)).let { DigestUtils.sha256Hex(it.toString()) }
            hash shouldStartWith "0000"
        }
    }

    "proofOfWork() with default functions returns a value that meet the expectations" {
        val seed = random()
        proofOfWork(seed = seed).apply {
            hashWith4Zeros(powerOf2Diff(this, seed)) shouldBe true
        }
    }

    "isAValidProof returns true with valid values" {
        isAValidProof(
            curr = 16.0,
            prev = 0.18493704122436794,
            f = { a, b -> (a.pow(2) - b.pow(2)).let { DigestUtils.sha256Hex(it.toString()) } },
            isValid = { it.startsWith("0000") }
        ) shouldBe true
    }

    "isAValidProof returns false with an invalid combination of values" {
        isAValidProof(
            curr = 16.0,
            prev = 0.19,
            f = { a, b -> (a.pow(2) - b.pow(2)).let { DigestUtils.sha256Hex(it.toString()) } },
            isValid = { it.startsWith("0000") }
        ) shouldBe false
    }

    "powerOf2Diff returns the hash of the difference between the squares of a and b" {
        powerOf2Diff(5.0, 2.0) shouldBe "49f7c1eb16994765833543f9c55f9c9274a6ace9e1b5e426999bce7677c67b82"
    }

    "hashWith4Zeros returns true only if the string passed as parameter starts with four zeros" {
        hashWith4Zeros("") shouldBe false
        hashWith4Zeros("0") shouldBe false
        hashWith4Zeros("00") shouldBe false
        hashWith4Zeros("000") shouldBe false
        hashWith4Zeros("10000") shouldBe false
        hashWith4Zeros(" 0000") shouldBe false
        hashWith4Zeros(" 000") shouldBe false
        hashWith4Zeros("0000") shouldBe true
        hashWith4Zeros("000023412323") shouldBe true

    }
})