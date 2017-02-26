package application;



import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JPopupMenu;

import javafx.collections.FXCollections;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.SnapshotParameters;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.CustomMenuItem;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;

public class Controlleur {
	
	private int textSize=13;
	private Color textColor=new Color(0, 0, 0, 0);
	private List<String> listFontFamilies;
	private String textFont;
	private double positionTextX,positionTextapresdropX=0;
	private double positionTextY,positionTextapresdropY=0;
	private Label newLabel= new Label();
	
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
	@FXML
	private Button buttonAddText;
	@FXML
	private ListView listViewFonts;
	@FXML
	private FileChooser fileChooser;
	@FXML
	private Button buttonSave;
	@FXML
	private ColorPicker colorPickerBG;
	@FXML
	private Pane paneCadrePrincipalDefault;
	
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
			
			 File file = fileChooser.showOpenDialog(null);
             
	            try {
	                BufferedImage bufferedImage = ImageIO.read(file);
	                Image image = SwingFXUtils.toFXImage(bufferedImage, null);
	                pic.setImage(image);
	            } catch (IOException ex) {
	     
	            }
			
		}}
	});
	
	this.listFontFamilies = javafx.scene.text.Font.getFamilies();
	
	
		
	}
	
	@FXML
	public void save (ActionEvent event){
		
		SnapshotParameters parameters = new SnapshotParameters();
		/**** A CHANGER to pane cadre principal !! */
		WritableImage wi = new WritableImage((int) pane_LayoutDef.getWidth(),(int) pane_LayoutDef.getHeight());
		WritableImage snapshot = pane_LayoutDef.snapshot(parameters, wi);
		/******************/
              
		FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save Image");
	    //System.out.println(pic.getId());
	    File file = fileChooser.showSaveDialog(null);if (file != null) {
	    	try {
	    		
	    		ImageIO.write(SwingFXUtils.fromFXImage(snapshot,
	                        null), "png", new File(file.getAbsolutePath()+".png"));
	    	} catch (IOException ex) {
	                    System.out.println(ex.getMessage());
	    	}
	    }
	}
	
	@FXML
	private void initialize(){
		/***** A CHANGER to cadre principal ****/
		this.stackPane_LayoutDef.getChildren().add(newLabel);
		/*********************/
		for(String s : this.listFontFamilies){
			this.listViewFonts.setItems(FXCollections.observableList(this.listFontFamilies));
		}

	}
	
	/*
	@FXML
	public void clicked (MouseEvent e){
		
			menuPic.show(pic,e.getScreenX(), e.getScreenY());
			System.out.println("pressed");
		
		
		}
		*/
	
	@FXML
	public void clicked (MouseEvent e){
		
		 fileChooser= new FileChooser(); 
			if (fileChooser!= null){
			fileChooser.setTitle("Open Resource File");
			
			fileChooser.getExtensionFilters().addAll(
	                new FileChooser.ExtensionFilter("JPG", "*.jpg"),
	                new FileChooser.ExtensionFilter("PNG", "*.png")
	            );
			
			 File file = fileChooser.showOpenDialog(null);
          
	            try {
	                BufferedImage bufferedImage = ImageIO.read(file);
	                Image image = SwingFXUtils.toFXImage(bufferedImage, null);
	                ImageView images=(ImageView) e.getSource();
	                images.setImage(image);
	            } catch (IOException ex) {
	     
	            }
	 }
	 }
	
	 
	/**
	 * appelée lors du clique sur un des layouts proposé dans le menu
	 * permet de changer l'agencement des cadres secondaires
	 * @param e
	 */
	@FXML
	public void changeLayout(ActionEvent e){
		/**** A CHANGER : mettre une methode par layout *******/
		
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
		this.textColor = this.colorPickerText.getValue();
	}
	
	@FXML
	public void changeTextSize(MouseEvent e){
		this.textSize = (int) this.sliderTextSize.getValue();
	}
	
	@FXML
	public void changeTextFont(MouseEvent e){
		System.out.print("font changed !");
		this.textFont = this.listViewFonts.getSelectionModel().getSelectedItem().toString();
	}
	
	@FXML
	public void changeText(ActionEvent e){
		this.paneTextEdit.setVisible(true);
	}
	
	@FXML
	public void addText(ActionEvent e){
		//Label newLabel = new Label(this.textEdit.getText());
		newLabel.setText(this.textEdit.getText());
		
		newLabel.setStyle("-fx-font-size: "+this.textSize+"px;"); // mise à jour de la taille
		
		newLabel.setTextFill(this.textColor); // mise à jour de la couleur
		
		newLabel.setFont(Font.font(this.textFont));
		
		/******* A CHANGER : ajouter le label au cadre/StackPane COURANT layout def ou layout1, 2 ..... ) ****/
		//this.stackPane_LayoutDef.getChildren().add(newLabel);
		this.pane_LayoutDef.setVisible(true);
		this.paneTextEdit.setVisible(false);
		/************************************/
		newLabel.setOnMousePressed(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				
				positionTextX=event.getSceneX();
				positionTextY=event.getSceneY();
				// TODO Auto-generated method stub
				
			}
				});
		newLabel.setOnMouseDragged(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				if(positionTextapresdropX-positionTextX+event.getSceneX() >stackPane_LayoutDef.getWidth()/2 || positionTextapresdropX-positionTextX+event.getSceneX() <-stackPane_LayoutDef.getWidth()/2
						||positionTextapresdropY-positionTextY+event.getSceneY()>stackPane_LayoutDef.getHeight()/2 || positionTextapresdropY-positionTextY+event.getSceneY()<-stackPane_LayoutDef.getHeight()/2 )
				{
					return;
				}
				newLabel.setTranslateX(positionTextapresdropX-positionTextX+event.getSceneX());
				newLabel.setTranslateY(positionTextapresdropY-positionTextY+event.getSceneY());
				
				
			
			}
				});
		newLabel.setOnMouseReleased(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				positionTextapresdropX=newLabel.getTranslateX();
				positionTextapresdropY=newLabel.getTranslateY();
				
				
			}
				});

		
	}
	
	/**
	 * appelée lors du clique sur le color picker du menu
	 * permet de changer la couleur de fond du cadre principal
	 * @param e
	 */
	@FXML
	public void changeBackgroundColor(ActionEvent e){
		Paint fill = this.colorPickerBG.getValue();
		BackgroundFill backgroundFill = new BackgroundFill(fill, CornerRadii.EMPTY, Insets.EMPTY);
		Background background = new Background(backgroundFill);
		this.paneCadrePrincipalDefault.setBackground(background);
		}
	
	}




