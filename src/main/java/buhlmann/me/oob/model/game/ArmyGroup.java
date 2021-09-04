package buhlmann.me.oob.model.game;

import buhlmann.me.oob.model.MapNode;

public class ArmyGroup extends MapNode {
    public ArmyGroup() {
        super(NodeType.ARMY_GROUP,
            // allowed children
            NodeType.ARMY,
            NodeType.CORPS,
            NodeType.DIVISION,
            NodeType.REGIMENT,
            NodeType.NAVY
        );
    }
}
