package quickverter;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.aspose.words.*;

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
    String Tipo;
    String TipoF;
    int type;

    ArrayList<String> TiposaC = new ArrayList<String>();

    public void Alarma(){
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Mensaje del Sistema");
        alert.setHeaderText(null);
        alert.setContentText("El archivo se a convertido con exito");
        alert.showAndWait();
    }

    public void AlarmaCarga(){
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Mensaje del Sistema");
        alert.setHeaderText(null);
        alert.setContentText("El archivo se cargo con exito");
        alert.showAndWait();
    }

    @FXML
    private void btnFile_action() throws IOException {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Seleccionar Archivo");
        File ruta = fileChooser.showOpenDialog(null);
        Nombre = ruta.getAbsolutePath();
        TextName.setText(Nombre);
        type = Nombre.length();
        Tipo = Nombre.substring(type-4,type);
        if(Tipo.charAt(0)=='.'&&Tipo.charAt(1)=='j'&&Tipo.charAt(2)=='p'&&Tipo.charAt(3)=='g'){
            TipoF="JPG";
        }
        if(Tipo.charAt(0)=='d'&&Tipo.charAt(1)=='o'&&Tipo.charAt(2)=='c'&&Tipo.charAt(3)=='x'){
            TipoF="DOCX";
        }
        System.out.println(Tipo);
        AlarmaCarga();
    }

    @FXML
    private void btnConvertir_action() throws Exception {
        if(typeFileFinal.getSelectionModel().getSelectedItem()=="PDF"&&TipoF=="JPG"){
            Document doc = new Document();
            DocumentBuilder builder = new DocumentBuilder(doc);
            builder.insertImage(Nombre);
            doc.save(Nombre+"Output.pdf");
            Alarma();
        }
        if(typeFileFinal.getSelectionModel().getSelectedItem()=="PDF"&&TipoF=="DOCX"){
            Document doc = new Document(Nombre);
            doc.save(Nombre+"Output.pdf");
            Alarma();
        }
        else{
            System.out.println("Seleccione un tipo de archivo valido");
        }
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        TiposaC.add("PDF");
        typeFileFinal.getItems().addAll(TiposaC);
    }
}
