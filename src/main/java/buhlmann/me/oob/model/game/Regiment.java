package buhlmann.me.oob.model.game;

import buhlmann.me.oob.model.OOBNode;

public class Regiment extends OOBNode implements Unit, Reserve {

    private String unit;
    private boolean is_reserve;

    private short experience;
    private short historical_model;

    @Override
    public void set(String key, String value) {
        super.set(key, value);

        Unit.set(this, key, value);
        Reserve.set(this, key, value);
    }

    @Override
    public String unparse() {
        final String nl = System.getProperty("line.separator");

        final StringBuilder string = new StringBuilder()
            .append("regiment = {").append(nl)
            .append("\ttype = ").append(this.type.getType()).append(nl)
            .append("\tis_reserve = ").append(this.is_reserve).append(nl)
            .append("\texperience = ").append(this.experience).append(nl)
            .append("\tname = ").append(this.getName()).append(nl)
            .append("\thistorical_model = ").append(this.historical_model).append(nl)
            .append("}").append(nl);

        return string.toString();
    }

    @Override
    public String toString() {
        return this.unparse();
    }

    @Override
    public String getUnit() {
        return unit;
    }

    @Override
    public void setUnit(String unit) {
        this.unit = unit;
    }

    @Override
    public boolean isReserve() {
        return is_reserve;
    }

    @Override
    public void setReserve(boolean is_reserve) {
        this.is_reserve = is_reserve;
    }

    @Override
    public short getExperience() {
        return experience;
    }

    @Override
    public void setExperience(short experience) {
        this.experience = experience;
    }

    @Override
    public short getHistoricalModel() {
        return historical_model;
    }

    @Override
    public void setHistoricalModel(short historicalModel) {
        this.historical_model = historicalModel;
    }

    public Regiment() {
        super(NodeType.REGIMENT);
    }
}
