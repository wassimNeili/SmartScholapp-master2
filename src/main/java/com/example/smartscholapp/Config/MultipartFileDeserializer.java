package com.example.smartscholapp.Config;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public class MultipartFileDeserializer extends StdDeserializer<MultipartFile> {

    protected MultipartFileDeserializer() {
        super(MultipartFile.class);
    }

    @Override
    public MultipartFile deserialize(JsonParser parser, DeserializationContext context) throws IOException {
        JsonNode node = parser.getCodec().readTree(parser);
        // Implémentez ici la logique de désérialisation du champ MultipartFile
        // par exemple, en créant une instance de DiskFileItem à partir des données JSON
        // et en renvoyant un objet MultipartFile correspondant
        // Assurez-vous d'ajouter les dépendances nécessaires pour DiskFileItem
        return null;
    }

    public void serialize(MultipartFile value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeString(value.getName());
    }
}