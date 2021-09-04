package buhlmann.me.oob.model.game;

import buhlmann.me.oob.util.StringUtils;

public interface Reserve {
    boolean isReserve();
    void setReserve(boolean reserve);

    static void set(Reserve reserve, String key, String value) {
        if (key.equals("is_reserve")) {
            reserve.setReserve(StringUtils.parseParadoxBoolean(value));
        }
    }
}
