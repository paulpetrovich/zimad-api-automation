package Utils;

import java.util.UUID;
import com.fasterxml.uuid.Generators;

public class UUIDGenerator {

    private UUID uuid;

    public UUIDGenerator() {

        uuid =  Generators.timeBasedGenerator().generate();

    }

    public UUID getUuid() {
        return uuid;
    }
}
