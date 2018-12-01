package com.example.ilidosha.dnd.jackson;


import com.example.ilidosha.dnd.enities.Stat;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;

public class StatDeserializer extends JsonDeserializer<Stat> {

    @Override
    public Stat deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        JsonToken currentToken;
        Stat stat = null;
        while ((currentToken = p.nextValue()) != JsonToken.END_OBJECT) {
            switch (currentToken) {
                case VALUE_NUMBER_INT:
                    assert stat != null;
                    stat.setValue(p.getIntValue());
                    break;
                case VALUE_STRING:
                    stat = Stat.getStatFromString(p.getText());
                    break;
                default:
                    break;
            }
        }
        return stat;
    }
}