package buhlmann.me.oob.model.game;

import buhlmann.me.oob.model.MapNode;

public class Army extends MapNode {
    public Army() {
        super(NodeType.ARMY,
            // allowed children
            NodeType.CORPS,
            NodeType.DIVISION,
            NodeType.REGIMENT,
            NodeType.NAVY
        );
    }
}
