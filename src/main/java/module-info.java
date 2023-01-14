module quickverter {
    requires javafx.controls;
    requires javafx.fxml;
	requires com.aspose.words;

    opens quickverter to javafx.fxml;
    exports quickverter;
}
