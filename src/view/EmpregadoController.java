package view;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.util.converter.FormatStringConverter;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ComboBox;



public class EmpregadoController implements Initializable{

	
	
	
	@FXML
	private TextField txtNome;
	
	@FXML
	private TextField txtSalHora;
	
	@FXML
	private TextField txtHorasTrabalhada;
	
	@FXML
	private Button btnCalcular;
	
	@FXML
	private Button btnLimpar;
	
	@FXML
	private Label lblResultado;
	
	@FXML
	private RadioButton rdoManha;
	
	@FXML
	private RadioButton rdoTarde;
	
	@FXML
	private RadioButton rdoNoite;
	
	@FXML
	private ComboBox<String> cboCargo;
	
	public void onCalcularClick() {
		
		 String nome;
		 double salHora;
		 double horasTrabalhada;
		 double salario;
		 String formataSalario;
		 
		 double acrescimo= 0;
		 double comissao = 0;
		 
		 if(cboCargo.getValue().equals("Balconista") || cboCargo.getValue().equals("Caixa")){
			 comissao = 200.00;
		 }else {
			 comissao =100.00;
		 }
		 
		 
		 
		 if(rdoManha.isSelected()) {
			 acrescimo = 1.10;
		 }else if(rdoTarde.isSelected()) {
			 acrescimo = 1.20;
		 }else if(rdoNoite.isSelected()) {
			 acrescimo = 1.30; 
		 }
		 
		nome = txtNome.getText();
		salHora = Double.parseDouble(txtSalHora.getText());
		horasTrabalhada = Double.parseDouble(txtHorasTrabalhada.getText());
		
		salario = salHora * horasTrabalhada * acrescimo + comissao;
		formataSalario = String.format("%.2f", salario);
		
		lblResultado.setText("Valor de: " + formataSalario + "Salário de: " + nome);
		
	}
	
	public void onBtnLimparClick() {
		txtNome.setText("");
		txtSalHora.setText("");
		txtHorasTrabalhada.setText("");
		lblResultado.setText("Resultado");
		
		btnCalcular.setDisable(true);
		btnLimpar.setDisable(true);
	}
	
	public void onKeyReleased() {
		boolean calcular;
		boolean limpar;
		
		
		calcular = (txtSalHora.getText().isEmpty() || txtHorasTrabalhada.getText().isEmpty());
		btnCalcular.setDisable(calcular);
		
		limpar = (txtSalHora.getText().isEmpty() && txtSalHora.getText().isEmpty() && txtNome.getText().isEmpty());
		btnLimpar.setDisable(limpar);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		cboCargo.getItems().addAll("Balconista", "Caixa", "Copeiro", "Cozinheira");
		cboCargo.getItems().add("Confeiteiro");
		cboCargo.getItems().add("Padeiro");
	}
}
