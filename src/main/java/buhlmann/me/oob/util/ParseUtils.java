package buhlmann.me.oob.util;

import buhlmann.me.oob.model.MapNode;
import buhlmann.me.oob.model.game.*;
import buhlmann.me.oob.model.OOBNode;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParseUtils {
    private static final Pattern TYPE = Pattern.compile("(\\w)+\\s*=\\s*\\{");
    private static final Pattern END = Pattern.compile("\\s*}");

    private static int start;

    private static OOBNode createNode(String type) {
        NodeType node = NodeType.get(type);
        switch(node) {
            case REGIMENT:
                return new Regiment();
            case DIVISION:
                return new Division();
            case CORPS:
                return new Corps();
            case ARMY:
                return new Army();
            case ARMY_GROUP:
                return new ArmyGroup();
            case THEATRE:
                return new Theatre();
            case NAVY:
                return new Navy();
            case SHIP:
                return new Ship();
            default:
                return new OOBNode(NodeType.UNKNOWN);
        }
    }

    private static void addData(final OOBNode node, final String data) {
        try {
            if (StringUtils.isNullOrEmpty(data.trim()) || data.trim().startsWith("#")) {
                return;
            }

            String key = StringUtils.key(data);
            String value = StringUtils.value(data);

            if (!StringUtils.isNullOrEmpty(key, value)) {
                node.set(key, value);
            }

        } catch(ParseException e) {
            e.printStackTrace();
        }
    }

    /**
     * Finds start and end of an OOBNode.
     */
    private static void parseOOBNode(List<String> lines, Stack<OOBNode> stack, List<OOBNode> nodes) throws ParseException {
        for (; ParseUtils.start < lines.size(); ParseUtils.start++) {

            final String line = lines.get(ParseUtils.start).trim().replace("\t", "");
            Matcher m = TYPE.matcher(line);
            Matcher m2 = END.matcher(line);

            if (m.find()) {
                // create new node when found
                OOBNode current = ParseUtils.createNode(StringUtils.key(line));

                // push new node onto stack
                stack.push(current);

                // do the dew
                ParseUtils.start++;
                ParseUtils.parseOOBNode(lines, stack, nodes);

            } else if (m2.find()) {
                // found end
                if (stack.size() > 1) {
                    // pop latest
                    OOBNode child = stack.pop();
                    // add as child to previous highest
                    stack.peek().getChildren().add(child);

                } else {
                    if (stack.size() == 1) {
                        // top-level node
                        nodes.add(stack.pop());
                        return;
                    }
                }
            } else {
                if (!stack.empty()) {
                    ParseUtils.addData(stack.peek(), line);
                }
            }
        }
    }

    /**
     * Parses string data and returns a list of top-level OOBNodes with their children set accordingly.
     * @return top-level OOBNodes.
     */
    public static List<OOBNode> parse(String str) {
        List<String> lines = new ArrayList<>(Arrays.asList(str.split("[\\r?\\n]+")));

        try {
            final List<OOBNode> nodes = new ArrayList<>();
            ParseUtils.start = 0;
            ParseUtils.parseOOBNode(lines, new Stack<>(), nodes);
            return nodes;
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return null;
    }
}
