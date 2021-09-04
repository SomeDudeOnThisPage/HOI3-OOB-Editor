package buhlmann.me.oob.model;

import buhlmann.me.oob.model.game.NodeType;

import java.util.ArrayList;
import java.util.List;

public class OOBNode implements Parseable {

    public NodeType type;

    private String name;

    private final List<OOBNode> children;
    private final List<String> data;

    private NodeType[] allowed;

    public List<OOBNode> getChildren() {
        return this.children;
    }

    public void set(String key, String value) {
        if (key.equals("name")) {
            // replace quotes => don't forget to add them back when unparsing...
            this.name = value.replaceAll("^\"|\"$", "");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getData() {
        return this.data;
    }

    public NodeType getType() {
        return this.type;
    }

    public OOBNode(NodeType type, NodeType... allowed) {
        this(type);
        this.allowed = allowed;
    }

    public OOBNode(NodeType type) {
        this.type = type;
        this.children = new ArrayList<>();
        this.data = new ArrayList<>();
    }

    @Override
    public String unparse() {
        return null;
    }
}
