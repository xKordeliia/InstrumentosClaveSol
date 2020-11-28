package Controlador;


import javafx.fxml.FXML;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import org.hibernate.*;
import java.net.URL;
import java.util.ResourceBundle;
import Modelo.Instrumentos;
import Modelo.InstrumentosDAO;


public class Controller {

	@FXML
	private TextField tf1nref;
	@FXML
	private TextField tf2nins;
	@FXML
	private TextField tf3peso;
	@FXML
	private TextField tf4date;
	@FXML
	private TextField tf5trans;
	@FXML
	private TextField tf6obs;
	@FXML
	private Button btnenvio, btneliminar;
	 Modelo.Instrumentos instrumentos = new Modelo.Instrumentos();
	 Modelo.InstrumentosDAO instrumentoDAO = new Modelo.InstrumentosDAO();
	
	 public void initialize() {
		 btnenvio.setOnAction(e ->{
			 System.out.println("Hola");
			 instrumentos.setVnumSerieInst(tf1nref.getText());
			 instrumentos.setVnInst(tf2nins.getText());
			 instrumentos.setVpeso(tf3peso.getText());
			 instrumentos.setVfechaRecep(tf4date.getText());
			 instrumentos.setVtransportista(tf5trans.getText());
			 instrumentos.setVobservaciones(tf6obs.getText());
			 Instrumentos nuevopedidoinstrumento= new Modelo.Instrumentos (instrumentos.getVnumSerieInst(), instrumentos.getVnInst(), instrumentos.getVpeso(), instrumentos.getVfechaRecep(), instrumentos.getVtransportista(), instrumentos.getVobservaciones());
			 instrumentoDAO.insertarInstrumento(nuevopedidoinstrumento);
			 clearFields();});
		 
		 btneliminar.setOnAction(e ->{
			 clearFields();});
		 
}

	private void clearFields() {
		tf1nref.clear();
		tf2nins.clear();
		tf3peso.clear();
		tf4date.clear();
		tf5trans.clear();
		tf6obs.clear();
	}
}
