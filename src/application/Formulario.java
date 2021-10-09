package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Formulario extends Application {
	@Override
	public void start(Stage stage) {
		try {
		
		
			Parent p = FXMLLoader.load(getClass().getResource("/view/Empregado.fxml"));
			// Parent e uma superclasse do objeto AnchoPane
			//Por isso e possivel carregar (Load) empregado.fxml que é achorPane como Parent
			Scene scene = new Scene(p);
			//Scenne e uma classe que seu construtor recebe um parent como parametro
			stage.setScene(scene);
			// Observe que o stage recebe um atributo do tipo Scene, por isso o encapsulamento do atributo Scene
			stage.show();
			// O metodo show da class Stage (que é o palco) mostra o formulario
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

