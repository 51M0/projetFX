package application;



import java.io.File;

import javax.swing.JPopupMenu;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.CustomMenuItem;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.FileChooser;

public class Controlleur {
	
	@FXML
	private Pane root;
	private ContextMenu menuPic;
	private MenuItem loadPicture;
	
	@FXML
	private ImageView pic;
	@FXML
	private Button _button_LayoutDef;
	@FXML
	private Button _button_Layout1;
	@FXML
	private Button _button_Layout2;
	@FXML
	private Button _button_Layout3;
	@FXML
	private StackPane stackPane_LayoutDef;
	@FXML
	private StackPane stackPane1_Layout1;
	@FXML
	private StackPane stackPane2_Layout1;
	@FXML
	private Pane pane_LayoutDef;
	@FXML
	private Pane pane1_Layout1;
	@FXML
	private Pane pane2_Layout1;
	@FXML
	private Pane pane1_Layout2;
	@FXML 
	private Button buttonChangeText;
	@FXML
	private Pane paneTextEdit;
	@FXML
	private TextField textEdit;
	@FXML
	private Slider sliderTextSize;
	@FXML
	private ColorPicker colorPickerText;
	
	public Controlleur(){		
		menuPic=new ContextMenu();
		loadPicture= new MenuItem("Load Picture");
	menuPic.getItems().add(loadPicture);
	loadPicture.setOnAction(new EventHandler<ActionEvent>() {
		
		@Override
		public void handle(ActionEvent event) {
			FileChooser fileChooser = new FileChooser(); 
			if (fileChooser!= null){
			fileChooser.setTitle("Open Resource File");
			
			fileChooser.getExtensionFilters().addAll(
	                new FileChooser.ExtensionFilter("JPG", "*.jpg"),
	                new FileChooser.ExtensionFilter("PNG", "*.png")
	            );
			fileChooser.showOpenDialog(menuPic);
			
			// TODO Auto-generated method stub
			
		}}
	});
	
	
		
	}
	
	@FXML
	private void initialize(){

	}
	
	@FXML
	public void clicked (MouseEvent e){
		
			menuPic.show(pic,e.getScreenX(), e.getScreenY());
			System.out.println("pressed");
		
		
		}
	
	 
	/**
	 * appelée lors du clique sur un des layouts proposé dans le menu
	 * @param e
	 */
	@FXML
	public void changeLayout(ActionEvent e){
		
		Button clickedLayout = (Button) e.getSource();
		System.out.println("change layout to "+clickedLayout.getId().substring(clickedLayout.getId().indexOf("_")+1));
		String layoutName = clickedLayout.getId().substring(clickedLayout.getId().indexOf("_")+1);
		
		//test pour un cas
		this.pane_LayoutDef.setVisible(false);
		this.pane2_Layout1.setVisible(true);
		this.pane1_Layout1.setVisible(true);
		}
	
	@FXML
	public void changeTextColor(ActionEvent e){

	}
	
	@FXML
	public void changeTextSize(MouseEvent e){
		
	}
	
	@FXML
	public void changeText(ActionEvent e){
		this.paneTextEdit.setVisible(true);
	}
	
	}




