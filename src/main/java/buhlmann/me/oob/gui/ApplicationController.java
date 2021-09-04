package buhlmann.me.oob.gui;

import buhlmann.me.oob.OOBEditor;
import buhlmann.me.oob.model.OOBNode;
import buhlmann.me.oob.model.game.Regiment;
import buhlmann.me.oob.model.game.Unit;
import buhlmann.me.oob.util.ParseUtils;
import buhlmann.me.oob.util.StringUtils;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;
import java.util.ResourceBundle;

public class ApplicationController implements Initializable {
    @FXML
    protected TreeView<String> oob;

    @Override
    public void initialize(URL url, ResourceBundle resources) {
        final String theatre = StringUtils.load("test/theatre.txt");
    }

    private TreeItem<String> leaf(OOBNode node, TreeItem<String> parent) {
        String s = "[" + node.getType() + "] " + node.getName();

        if (node instanceof Unit) {
            s = s + " (" + ((Unit) node).getUnit() + ")";
        }

        final TreeItem<String> leaf = new TreeItem<>(s);

        if (node.getChildren().size() > 0) {
            for (OOBNode child : node.getChildren()) {
                leaf.getChildren().add(leaf(child, leaf));
            }
        }

        return leaf;
    }

    @FXML
    protected void menu_onFileLoad() throws IOException {
        FileChooser selector = new FileChooser();
        selector.setTitle("Select Order-Of-Battle Definition...");
        selector.setInitialDirectory(new File("G:\\Steam\\steamapps\\common\\Hearts of Iron 3\\tfh\\mod\\WW1Mod_v1.0\\history\\units"));

        selector.getExtensionFilters().add(new FileChooser.ExtensionFilter("txt files (*.txt)", "*.txt"));

        final File file = selector.showOpenDialog(OOBEditor.STAGE);
        final String data = Files.readString(file.toPath(), StandardCharsets.ISO_8859_1);
        List<OOBNode> nodes = ParseUtils.parse(data);

        if (nodes != null) {
            System.out.println(nodes.size());

            // to tree view
            oob.setRoot(new TreeItem<>("root"));
            oob.setShowRoot(false);

            for (OOBNode node : nodes) {
                oob.getRoot().getChildren().add(leaf(node, oob.getRoot()));
            }

        }
    }


}
