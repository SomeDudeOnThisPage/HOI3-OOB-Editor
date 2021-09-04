package buhlmann.me.oob.model.game;

public interface Unit {

    short getExperience();
    void setExperience(short experience);
    short getHistoricalModel();
    void setHistoricalModel(short historicalModel);

    String getUnit();
    void setUnit(String unit);

    static void set(Unit unit, String key, String value) {
        switch(key) {
            case "experience":
                unit.setExperience(Short.parseShort(value));
                break;
            case "historical_model":
                unit.setHistoricalModel(Short.parseShort(value));
                break;
            case "type":
                unit.setUnit(value);
                break;
        }
    }
}
