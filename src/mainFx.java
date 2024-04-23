import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
public class mainFx extends Application {
	private TableView<RentObject> rentTable = new TableView<RentObject>();
	private TableView<Book> bookTable = new TableView<Book>();
   	@SuppressWarnings("rawtypes")
   	private TableColumn bookIDCol = new TableColumn("Book ID");
   	@SuppressWarnings("rawtypes")
   	private TableColumn bookNameCol = new TableColumn("Book Name");
   	final static ObservableList<Book> rentData =
    		FXCollections.observableArrayList(
			
		   );
	final ObservableList<RentObject> rentData2 =
    		FXCollections.observableArrayList(
			
		   );
	private void restart(Stage stage) {
		try {
			start(stage);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
    final HBox hb = new HBox();
    final HBox bookHB = new HBox();
	    @SuppressWarnings({ "unchecked", "rawtypes" })
		public void start(Stage stage) throws Exception {
	    	TableView<Book>  bs2 = BookShelf.getBookShelf();
	    	BookShelf bs3 = new BookShelf();
	    	PersonData ps = new PersonData();
	    	Scene scene = new Scene(new Group());
	        stage.setTitle("Table View Sample");
	        stage.setWidth(700);
	        stage.setHeight(550);
	        
	        final Label label = new Label("Address Book");
	        final Label bookListLabel = new Label("Book List");
	        label.setFont(new Font("Arial", 20));
	        
	        
	 
	        final TextField addName = new TextField();
	        addName.setPromptText("Name");
	        addName.setMaxWidth(ps.getNameCol().getPrefWidth());
	        final TextField addID = new TextField();
	        addID.setPromptText("ID");
	        addID.setMaxWidth(ps.getNameCol().getPrefWidth());
	        final TextField addID2 = new TextField();
	        addID2.setPromptText("ID");
	        addID2.setMaxWidth(ps.getNameCol().getPrefWidth());
	        final TextField addEmail = new TextField();
	        addEmail.setMaxWidth(ps.getEmailCol().getPrefWidth());
	        addEmail.setPromptText("Email");
	 
	        final Button addButton = new Button("Add");
	        addButton.setOnAction(new EventHandler<ActionEvent>() {
	            @Override
	            public void handle(ActionEvent e) {
	                PersonData.data.add(new Person(
	                		addID.getText(),
	                        addName.getText(),
	                        addEmail.getText()));
	                addName.clear();
	                addEmail.clear();
	            }
	        });
	 

	        
	        
	        
	        Button rentConfirm= new Button("Rent");  
		      rentConfirm.setOnAction(new EventHandler<ActionEvent>() {
		            @SuppressWarnings({ })
					@Override
		            public void handle(ActionEvent e) {
		            	
		            	String id = addID2.getText();	
		            	Book item = bs2.getItems().get(Integer.parseInt(id)-1);
		            	String name = (String) bs3.getBookNameCol().getCellObservableValue(item).getValue();
		            	
		            	RentObject ro = new RentObject(id,name);
		            	System.out.println(ro.getName());
		            	rentData2.add(ro);
		            	
		            	
		            }
		                		
		        });
	        
		    TableColumn rentCol = new TableColumn("Rent Data");
		    rentCol.setMinWidth(25);
		    rentCol.setCellValueFactory(
		        new PropertyValueFactory<RentObject, String>("name"));
		      
		    rentTable.setItems(rentData2);
		    rentTable.getColumns().addAll(rentCol);    
		    
		    
		    
		   
		    
	        final Button rentMenuButton = new Button("Rent");
	        rentMenuButton.setOnAction(new EventHandler<ActionEvent>() {
	            @Override
	            public void handle(ActionEvent e) {
	    	        
	            	GridPane bookRentPane = new GridPane();
		            bookRentPane.add(bookListLabel, 1, 4); 
		           
		            
		            bookIDCol.setMinWidth(100);
				    bookIDCol.setCellValueFactory(
				          new PropertyValueFactory<Book, String>("ID"));
				        
				      //Column for showing food ID	 
				      
				    bookNameCol.setMinWidth(100);
				    bookNameCol.setCellValueFactory(
				          new PropertyValueFactory<Book, String>("bookName"));
				    
				    bookTable.setItems(BookShelf.bookData);
				    bookTable.getColumns().addAll(bookIDCol,bookNameCol);   	
	            	
				    bookRentPane.add(bookTable, 1, 5);
		            bookRentPane.add(addID2, 1, 6); 
		            bookRentPane.add(rentConfirm, 1, 7); 
		            Scene secondScene = new Scene(bookRentPane, 500,500);
		            Stage secondStage = new Stage();
		            secondStage.setScene(secondScene);
		            secondStage.setTitle("Book List");
		            secondStage.show();
	            }
	        });
	        
		      
	        
	       
	        hb.getChildren().addAll(addID,addName, addEmail, addButton,rentMenuButton);
	        hb.setSpacing(3);			

	        final VBox vbox = new VBox();
	        vbox.setSpacing(5);
	        vbox.setPadding(new Insets(10, 0, 0, 10));
	        vbox.getChildren().addAll(label, ps.getTable(), hb);
	        
	        final VBox vbox2 = new VBox();
	        vbox2.setSpacing(5);
	        vbox2.setPadding(new Insets(35, 0, 0, 400));
	        vbox2.getChildren().addAll(rentTable);
	        
 
	        ((Group) scene.getRoot()).getChildren().addAll(vbox, vbox2);
	 
	        stage.setScene(scene);
	        stage.show();
	    }
	    
	    public static void main(String[] args) {
		launch(args);

	}
	   

}
