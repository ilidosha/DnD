package com.example.ilidosha.dnd.jackson;

import com.example.ilidosha.dnd.enities.Stat;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public class StatSerializer extends JsonSerializer<Stat> {

    class StatObject{
        StatObject(String stat, int value) {
            this.stat = stat;
            this.value = value;
        }

        String stat;
        int value;
    }

    @Override
    public void serialize(Stat value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeObject(new StatObject(value.toString(),value.getValue()));
    }
}
