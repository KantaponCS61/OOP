import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

public class PersonData {
	private TableView<Person> table = new TableView<Person>();
    final static ObservableList<Person> data =
            FXCollections.observableArrayList(
           );
    @SuppressWarnings("rawtypes")
	static
	TableColumn idCol = new TableColumn("ID");
    @SuppressWarnings("rawtypes")
	public TableColumn getIdCol() {
		return idCol;
	}
	@SuppressWarnings({ "rawtypes", "static-access" })
	public void setIdCol(TableColumn idCol) {
		this.idCol = idCol;
	}
	@SuppressWarnings("rawtypes")
	static
	TableColumn nameCol = new TableColumn("Name");
    @SuppressWarnings("rawtypes")
	static
	TableColumn emailCol = new TableColumn("Email");
    @SuppressWarnings("unchecked")
	public PersonData() {
    	table.setEditable(true);
   	 
    	idCol.setMinWidth(100);
    	idCol.setCellValueFactory(
            new PropertyValueFactory<Person, String>("ID"));
    	idCol.setCellFactory(TextFieldTableCell.forTableColumn());
    	idCol.setOnEditCommit(
            new EventHandler<CellEditEvent<Person, String>>() {
                @Override
                public void handle(CellEditEvent<Person, String> t) {
                    ((Person) t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                            ).setName(t.getNewValue());
                }
            }
        );
    	
        nameCol.setMinWidth(100);
        nameCol.setCellValueFactory(
            new PropertyValueFactory<Person, String>("Name"));
        nameCol.setCellFactory(TextFieldTableCell.forTableColumn());
        nameCol.setOnEditCommit(
            new EventHandler<CellEditEvent<Person, String>>() {
                @Override
                public void handle(CellEditEvent<Person, String> t) {
                    ((Person) t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                            ).setName(t.getNewValue());
                }
            }
        );
        
        emailCol.setMinWidth(200);
        emailCol.setCellValueFactory(
            new PropertyValueFactory<Person, String>("email"));
        emailCol.setCellFactory(TextFieldTableCell.forTableColumn());
        emailCol.setOnEditCommit(
            new EventHandler<CellEditEvent<Person, String>>() {
                @Override
                public void handle(CellEditEvent<Person, String> t) {
                    ((Person) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())
                        ).setEmail(t.getNewValue());
                }
            }
        );
        
        
 
        table.setItems(data);
        table.getColumns().addAll(idCol, nameCol, emailCol);
    }
	public TableView<Person> getTable() {
		return table;
	}
	public void setTable(TableView<Person> table) {
		this.table = table;
	}
	@SuppressWarnings("rawtypes")
	public TableColumn getNameCol() {
		return nameCol;
	}
	@SuppressWarnings({ "rawtypes", "static-access" })
	public void setNameCol(TableColumn nameCol) {
		this.nameCol = nameCol;
	}
	@SuppressWarnings("rawtypes")
	public TableColumn getEmailCol() {
		return emailCol;
	}
	@SuppressWarnings({ "rawtypes", "static-access" })
	public void setEmailCol(TableColumn emailCol) {
		this.emailCol = emailCol;
	}
}
