package buhlmann.me.oob.model.game;

public enum NodeType {
    THEATRE("theatre"),
    ARMY_GROUP("armygroup"),
    ARMY("army"),
    CORPS("corps"),
    DIVISION("division"),
    REGIMENT("regiment"),

    // Navy
    NAVY("navy"),
    SHIP("ship"),

    UNKNOWN("");

    private final String type;

    public final String getType() {
        return this.type;
    }

    public static NodeType get(String type) {
        for (NodeType t : NodeType.values()) {
            if (t.getType().equals(type)) {
                return t;
            }
        }
        return NodeType.UNKNOWN;
    }

    NodeType(String type) {
        this.type = type;
    }
}
