package com.github.engineeringhoroscope.repository

import com.github.engineeringhoroscope.bl.model.Horoscope
import com.github.engineeringhoroscope.bl.model.Prophecy
import com.github.engineeringhoroscope.bl.ports.HoroscopeRepository
import com.mongodb.kotlin.client.coroutine.MongoClient
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.runBlocking
import org.bson.codecs.configuration.CodecRegistries
import org.springframework.beans.factory.annotation.Value

private const val PROPHECIES = "prophecies"

class MongoDBRepository(
    @Value("\${mongodb.uri}")
    private val uri: String = "mongodb://admin:admin@localhost:27017",
    @Value("\${mongodb.database}")
    private val databaseName: String = "horoscope"
) : HoroscopeRepository {

    private val mongoClient = MongoClient.create(uri)
    private val database = mongoClient.getDatabase(databaseName)
    val codecRegistry = CodecRegistries.fromCodecs(ProphecyCodec())

    override fun getProphecies(): List<Prophecy> {
        return runBlocking<List<Prophecy>> {
            database.getCollection<Prophecy>(PROPHECIES)
                .withCodecRegistry(codecRegistry)
                .find()
                .toList()
        }
    }

    override fun addProphecy(prophecy: Prophecy) {
        runBlocking {
            database.getCollection<Prophecy>(PROPHECIES)
                .withCodecRegistry(codecRegistry)
                .insertOne(prophecy)
        }
    }

    override fun getHoroscopeHistory(limit: Int): List<Horoscope> {
        TODO()
    }

    override fun addHoroscope(horoscope: Horoscope) {
        TODO()
    }
}