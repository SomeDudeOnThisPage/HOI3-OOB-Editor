package buhlmann.me.oob.model;

import buhlmann.me.oob.model.game.NodeType;

/**
 * "Playable" Unit that is on the map, can have a leader.
 * => Everything except a regiment, sub-naval or sub-air basically.
 * The stuff you click around.
 */
public class MapNode extends OOBNode {

    private int location;
    private String leader;

    public void set(String key, String value) {
        super.set(key, value);

        switch (key) {
            case "location":
                this.location = Integer.parseInt(value);
                break;
            case "leader":
                this.leader = value;
                break;
        }
    }

    public void setLocation(int location) {
        this.location = location;
    }

    public int getLocation() {
       return this.location;
    }

    public String getLeader() {
        return leader;
    }

    public void setLeader(String leader) {
        this.leader = leader;
    }

    public MapNode(NodeType type, NodeType... allowed) {
        super(type, allowed);
    }

    public MapNode(NodeType type) {
        super(type);
    }
}
