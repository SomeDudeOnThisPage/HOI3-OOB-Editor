package buhlmann.me.oob.model.game;

import buhlmann.me.oob.model.MapNode;

public class Theatre extends MapNode {
    public Theatre() {
        super(NodeType.THEATRE,
            // allowed children
            NodeType.ARMY_GROUP,
            NodeType.ARMY,
            NodeType.CORPS,
            NodeType.DIVISION,
            NodeType.REGIMENT,
            NodeType.NAVY
        );
    }
}
