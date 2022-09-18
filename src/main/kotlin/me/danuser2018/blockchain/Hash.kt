package me.danuser2018.blockchain

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.apache.commons.codec.binary.Base64
import org.apache.commons.codec.digest.DigestUtils
import java.io.Serializable

private val mapper by lazy {
    jacksonObjectMapper()
}

private val b64encoder by lazy {
    Base64()
}

fun <T : Serializable> Block<T>.hash(): String = DigestUtils.sha256Hex(
    b64encoder.encodeToString(
        mapper.writeValueAsBytes(this)
    )
)

fun ProofOfWork.hash(): String = DigestUtils.sha256Hex(
    b64encoder.encodeToString(
        this.toString().toByteArray()
    )
)

