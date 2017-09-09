package siren.serializers;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import siren.Relation;

import java.io.IOException;

/**
 * @author jonfreer
 * @since 9/7/17
 */
public class RelationSerializer extends StdSerializer<Relation> {

    public RelationSerializer(){this(null);}

    protected RelationSerializer(Class<Relation> t) {
        super(t);
    }

    @Override
    public void serialize(
        Relation relation,
        JsonGenerator jsonGenerator,
        SerializerProvider serializerProvider
    ) throws IOException {
        jsonGenerator.writeString(relation.toString());
    }
}
