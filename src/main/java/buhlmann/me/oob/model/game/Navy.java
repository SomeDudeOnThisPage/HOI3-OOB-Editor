package buhlmann.me.oob.model.game;

import buhlmann.me.oob.model.MapNode;

public class Navy extends MapNode {

    private int base;

    public void set(String key, String value) {
        super.set(key, value);

        if (key.equals("base")) {
            this.base = Integer.parseInt(value);
        }
    }

    public int getBase() {
        return base;
    }

    public void setBase(int base) {
        this.base = base;
    }

    public Navy() {
        super(NodeType.NAVY, /* allowed children */ NodeType.SHIP);
    }
}
