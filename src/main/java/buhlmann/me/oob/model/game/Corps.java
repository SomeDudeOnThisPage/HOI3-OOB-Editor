package buhlmann.me.oob.model.game;

import buhlmann.me.oob.model.MapNode;

public class Corps extends MapNode {
    public Corps() {
        super(NodeType.CORPS,
            // allowed children
            NodeType.DIVISION,
            NodeType.REGIMENT,
            NodeType.NAVY
        );
    }
}
