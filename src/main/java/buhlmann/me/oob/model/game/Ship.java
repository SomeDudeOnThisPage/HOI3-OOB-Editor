package buhlmann.me.oob.model.game;

import buhlmann.me.oob.model.OOBNode;

public class Ship extends OOBNode implements Unit {

    private String unit;
    private short experience;
    private short historical_model;

    public Ship() {
        super(NodeType.SHIP);
    }

    @Override
    public void set(String key, String value) {
        super.set(key, value);

        Unit.set(this, key, value);
    }

    @Override
    public short getExperience() {
        return this.experience;
    }

    @Override
    public void setExperience(short experience) {
        this.experience = experience;
    }

    @Override
    public short getHistoricalModel() {
        return this.historical_model;
    }

    @Override
    public void setHistoricalModel(short historicalModel) {
        this.historical_model = historicalModel;
    }

    @Override
    public String getUnit() {
        return this.unit;
    }

    @Override
    public void setUnit(String unit) {
        this.unit = unit;
    }
}
