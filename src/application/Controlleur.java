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
import javafx.scene.Node;
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
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Polygon;
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
	private Pane currentPane;
	private int cornerSize=13;
	
	@FXML
	private Pane root;
	//private ContextMenu menuPic;
	//private MenuItem loadPicture;
	
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
	private Pane pane_Layout3;
	@FXML
	private Button buttonCancel;
	

	@FXML 
	private Button buttonChangeText;
	@FXML 
	private Button buttonChangeShape;
	@FXML
	private Pane paneTextEdit;
	@FXML
	private Pane paneShapeEdit;
	@FXML
	private TextField textEdit;
	@FXML
	private Slider sliderTextSize;
	@FXML
	private Slider sliderCorner;
	@FXML
	private Slider sliderMargin;
	@FXML
	private Slider sliderOuterMargin;
	@FXML
	private ColorPicker colorPickerText;
	@FXML
	private Button buttonAddText;
	@FXML
	private ListView<String> listViewFonts;
	@FXML
	private FileChooser fileChooser;
	@FXML
	private Button buttonSave;
	@FXML
	private ColorPicker colorPickerBG;
	@FXML
	private Pane paneCadrePrincipalDefault;
	@FXML
	private Pane pane_Layout1;
	@FXML
	private Rectangle rectangleLayoutDef;
	@FXML
	private Rectangle rectangle1Layout1;
	@FXML
	private Rectangle rectangle2Layout1;
	@FXML
	private Polygon polyBasGaucheLayout2;
	@FXML
	private Polygon polyHautLayout2;
	@FXML
	private Polygon polyBasDroitLayout2;
	@FXML
	private Polygon trapezeGaucheLayout3;
	@FXML
	private Polygon trapezeHautLayout3;
	@FXML
	private Polygon trapezeBasLayout3;
	@FXML
	private Polygon trapezeDroiteLayout3;
	@FXML
	private Rectangle carreCentreLayout3;
	@FXML
	private StackPane stackPane1_Layout2;
	@FXML
	private StackPane stackPane2_Layout2;
	@FXML
	private StackPane stackPane3_Layout2;
	@FXML
	private BorderPane borderPane_Layout3;
	@FXML
	private StackPane stackPane1_Layout3;
	@FXML
	private StackPane stackPane2_Layout3;
	@FXML
	private StackPane stackPane3_Layout3;
	@FXML
	private StackPane stackPane4_Layout3;
	@FXML
	private StackPane stackPane5_Layout3;
	@FXML
	private ImageView imageView1_Layout1;
	@FXML
	private ImageView imageView2_Layout1;
	@FXML
	private Pane pane1_LayoutDef;
	@FXML
	private ImageView imageView1_LayoutDef;
	@FXML
	private ImageView imageView1_Layout2;
	@FXML
	private Pane pane_Layout2;
	@FXML
	private Pane pane1_Layout2;
	@FXML
	private Pane pane2_Layout2;
	@FXML
	private ImageView imageView2_Layout2;
	@FXML
	private Pane pane3_Layout2;
	@FXML
	private ImageView imageView3_Layout2;
	@FXML
	private Pane pane1_Layout3;
	@FXML
	private Pane pane2_Layout3;
	@FXML
	private Pane pane3_Layout3;
	@FXML
	private Pane pane4_Layout3;
	@FXML
	private Pane pane5_Layout3;
	@FXML 
	private ImageView imageView1_Layout3;
	@FXML 
	private ImageView imageView2_Layout3;
	@FXML 
	private ImageView imageView3_Layout3;
	@FXML 
	private ImageView imageView4_Layout3;
	@FXML 
	private ImageView imageView5_Layout3;
	@FXML
	private Button buttonCloseShapeEdit;
	
	public Controlleur(){		
		/*
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
	
	*/
		this.listFontFamilies = javafx.scene.text.Font.getFamilies();
	}
	
	/**
	 * Permet de sauvegarder le cadre de photos réaliser par l'utilisateur
	 * @param event
	 */
	@FXML
	public void save (ActionEvent event){
		
		SnapshotParameters parameters = new SnapshotParameters();
		WritableImage wi = new WritableImage((int) this.paneCadrePrincipalDefault.getWidth(),(int) this.paneCadrePrincipalDefault.getHeight());
		WritableImage snapshot = this.paneCadrePrincipalDefault.snapshot(parameters, wi);
              
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
		this.currentPane = this.pane_LayoutDef;
		
		this.paneCadrePrincipalDefault.getChildren().add(newLabel);
		
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
		System.out.print("ImageView clicked !");
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
		this.textFont = this.listViewFonts.getSelectionModel().getSelectedItem().toString();
	}
	
	/**
	 * Appelée lorsque l'utilisateur clique sur le bouton "Shape"
	 * Affiche la fenetre d'édition des bordures du cadre
	 * @param e
	 */
	@FXML
	public void changeFrameShape(ActionEvent e){
		this.paneShapeEdit.setVisible(true);
	}
	
	/**
	 * Appelée lorsque l'utilisateur clique sur le bouton "Texte"
	 * Affiche la fenetre d'édition de texte
	 * @param e
	 */
	@FXML
	public void changeText(ActionEvent e){
		this.paneTextEdit.setVisible(true);
	}
	
	/**
	 * Appelée lorsque l'utilisateur clique sur le bouton "Add" après avoir modifier son texte
	 * Applique les transformations (choisies par l'utilisateur) au texte  
	 * @param e
	 */
	@FXML
	public void addText(ActionEvent e){
		newLabel.setText(this.textEdit.getText());
		
		newLabel.setStyle("-fx-font-size: "+this.textSize+"px;"); // mise à jour de la taille
		
		newLabel.setTextFill(this.textColor); // mise à jour de la couleur
		
		newLabel.setFont(Font.font(this.textFont)); // mise à jour du Font
		
		// puis on referme la fenetre d'édition et réaffiche le layout courant
		this.currentPane.setVisible(true); 
		this.paneTextEdit.setVisible(false);
		
		/****** Gestion du drag and drop du texte ajouté  *****/ 
		
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
	
	/**
	 *  Appelée lorsque l'utilisateur choisit d'afficher le layoutDefault (clique)
	 * @param e
	 */
	@FXML
	public void displayLayoutDefault(ActionEvent e){
		this.currentPane = this.pane_LayoutDef;
		
		this.pane_LayoutDef.setVisible(true);	
		this.pane_Layout1.setVisible(false);
		this.pane_Layout2.setVisible(false);
		this.pane_Layout3.setVisible(false);
	}
	
	/**
	 *  Appelée lorsque l'utilisateur choisit d'afficher le layout1 (clique)
	 * @param e
	 */
	@FXML
	public void displayLayout1(ActionEvent e){
		this.currentPane = this.pane_Layout1;
		
		this.pane_LayoutDef.setVisible(false);
		this.pane_Layout1.setVisible(true);
		this.pane_Layout2.setVisible(false);
		this.pane_Layout3.setVisible(false);
	}
	
	/**
	 *  Appelée lorsque l'utilisateur choisit d'afficher le layout2 (clique)
	 * @param e
	 */
	@FXML
	public void displayLayout2(ActionEvent e){
		this.currentPane = this.pane1_Layout2;
		
		this.pane_LayoutDef.setVisible(false);
		this.pane_Layout1.setVisible(false);
		this.pane_Layout2.setVisible(true);
		this.pane_Layout3.setVisible(false);
	}
	
	/**
	 * Appelée lorsque l'utilisateur choisit d'afficher le layout3 (clique)
	 * @param e
	 */
	@FXML
	public void displayLayout3(ActionEvent e){
		this.currentPane = this.pane1_Layout3;
		
		this.pane_LayoutDef.setVisible(false);
		this.pane_Layout1.setVisible(false);
		this.pane_Layout2.setVisible(false);
		this.pane_Layout3.setVisible(true);
	}
	
	/**
	 * Ferme la fenetre qui permet d'ajouter un texte
	 * @param e
	 */
	@FXML
	public void closeTextEditWindow(ActionEvent e){
		this.paneTextEdit.setVisible(false);
		}	

/**
 * Ferme la fenetre qui permet de parametrer les bordures
 * @param e
 */
	@FXML
	public void closeShapeEditWindow(ActionEvent e){
		this.paneShapeEdit.setVisible(false);
	}	

	@FXML
	public void changeCorner(MouseEvent e){
		//récupérer les StackPane enfants de currentPane et appliquer : 
		//setStyle("-fx-border-radius:"+this.sliderCorner.getValue()+"px");
		//setStyle("-fx-background-radius:"+this.sliderCorner.getValue()+"px");
	}
	
	@FXML
	public void changeMargin(MouseEvent e){
		//récupérer les StackPane enfants de currentPane et appliquer : 
		//setStyle("-fx-border-width:"+this.sliderCorner.getValue()+"px");
	}
}




