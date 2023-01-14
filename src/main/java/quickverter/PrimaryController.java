package quickverter;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.aspose.words.Document;
import com.aspose.words.DocumentBuilder;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.FileChooser;

public class PrimaryController implements Initializable{

    @FXML private Label TextName;
    @FXML private ComboBox typeFile;
    @FXML private ComboBox typeFileFinal;
    
    String Nombre;

    ArrayList<String> TiposC = new ArrayList<String>();
    ArrayList<String> TiposaC = new ArrayList<String>();

    public void Alarma(){
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Mensaje del Sistema");
        alert.setHeaderText(null);
        alert.setContentText("El archivo se a convertido con exito");
        alert.showAndWait();
    }

    @FXML
    private void btnFile_action() throws IOException {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Seleccionar Archivo");
        File ruta = fileChooser.showOpenDialog(null);
        Nombre = ruta.getAbsolutePath();
        TextName.setText(Nombre);
    }

    @FXML
    private void btnConvertir_action() throws Exception {
        if(typeFile.getSelectionModel().getSelectedItem()==".JPG (Imagen)"&&typeFileFinal.getSelectionModel().getSelectedItem()=="PDF"){
            Document doc = new Document();
            DocumentBuilder builder = new DocumentBuilder(doc);
            builder.insertImage(Nombre);
            doc.save(Nombre+"Output.pdf");
            Alarma();
        }
        if(typeFile.getSelectionModel().getSelectedItem()==".DOCX (Documento Word)"){
            System.out.println("DOCX a PDF");
        }
        else{
            System.out.println("Seleccione un tipo de archivo valido");
        }
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        TiposC.add(".JPG (Imagen)");
        TiposC.add(".DOCX (Documento Word)");
        TiposaC.add("PDF");
        typeFile.getItems().addAll(TiposC);
        typeFileFinal.getItems().addAll(TiposaC);
    }
}
