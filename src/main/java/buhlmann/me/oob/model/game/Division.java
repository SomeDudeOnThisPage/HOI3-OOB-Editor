package buhlmann.me.oob.model.game;

import buhlmann.me.oob.model.MapNode;
import buhlmann.me.oob.util.StringUtils;

public class Division extends MapNode implements Reserve {

    private boolean is_reserve;

    @Override
    public boolean isReserve() {
        return this.is_reserve;
    }

    @Override
    public void setReserve(boolean reserve) {
        this.is_reserve = reserve;
    }

    @Override
    public void set(String key, String value) {
        super.set(key, value);

        if (key.equals("is_reserve")) {
            this.is_reserve = StringUtils.parseParadoxBoolean(value);
        }
    }

    public Division() {
        super(NodeType.DIVISION, /* allowed children */ NodeType.REGIMENT);
    }
}
