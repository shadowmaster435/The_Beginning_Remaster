package shadowmaster435.the_beginning.pipes;

import net.minecraft.util.StringIdentifiable;

public enum PipeSide implements StringIdentifiable {
    NONE("none"),
    CONNECTED("connected"),
    SERVO("servo");

    private final String name;

    PipeSide(String name) {
        this.name = name;
    }

    public String toString() {
        return this.name;
    }

    public String asString() {
        return this.name;
    }
}