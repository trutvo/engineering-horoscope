package com.github.engineeringhoroscope.repository

import com.github.engineeringhoroscope.bl.model.Prophecy
import org.bson.BsonReader
import org.bson.BsonType
import org.bson.BsonWriter
import org.bson.codecs.Codec
import org.bson.codecs.DecoderContext
import org.bson.codecs.EncoderContext

class ProphecyCodec : Codec<Prophecy> {
    override fun encode(writer: BsonWriter, value: Prophecy, context: EncoderContext) {
        writer.writeStartDocument()
        writer.writeName("uuid")
        writer.writeString(value.uuid)
        writer.writeName("text")
        writer.writeString(value.text)
        writer.writeEndDocument()
    }

    override fun getEncoderClass(): Class<Prophecy> = Prophecy::class.java

    override fun decode(reader: BsonReader, context: DecoderContext): Prophecy {
        var prophecy = Prophecy(text = "")
        reader.readStartDocument()
        while (reader.readBsonType() != BsonType.END_OF_DOCUMENT) {
            when (reader.readName()) {
                "uuid" -> prophecy = prophecy.copy(uuid = reader.readString())
                "text" -> prophecy = prophecy.copy(text = reader.readString())
                "_id" -> reader.readObjectId()
                else -> reader.skipValue()
            }
        }
        reader.readEndDocument()
        return prophecy
    }
}