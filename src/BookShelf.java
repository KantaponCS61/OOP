import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

public class BookShelf {
	private static TableView<Book> bookShelf = new TableView<Book>();
    public static TableView<Book> getBookShelf() {
		return bookShelf;
	}
	@SuppressWarnings("static-access")
	public void setBookShelf(TableView<Book> bookShelf) {
		this.bookShelf = bookShelf;
	}
	final static ObservableList<Book> bookData =
    		FXCollections.observableArrayList(
			        new Book("1","Book1"),
				    new Book("2","Book2"),
				    new Book("3","Book3"),
				    new Book("4","Book4"),
				    new Book("5","Book5")
		   );
    @SuppressWarnings("rawtypes")
	public TableColumn getBookNameCol() {
		return bookNameCol;
	}
	@SuppressWarnings("rawtypes")
	public void setBookNameCol(TableColumn bookNameCol) {
		BookShelf.bookNameCol = bookNameCol;
	}
	public static ObservableList<Book> getBookdata() {
		return bookData;
	}
	@SuppressWarnings("rawtypes")
	static
	TableColumn bookNameCol = new TableColumn("Book");
    @SuppressWarnings("unchecked")
	public BookShelf() {
    	bookShelf.setEditable(true);
   	 
        
    	bookNameCol.setMinWidth(100);
    	bookNameCol.setCellValueFactory(
            new PropertyValueFactory<Book, String>("bookName"));
    	bookNameCol.setCellFactory(TextFieldTableCell.forTableColumn());
    	bookNameCol.setOnEditCommit(
            new EventHandler<CellEditEvent<Book, String>>() {
                @Override
                public void handle(CellEditEvent<Book, String> t) {
                    ((Book) t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                            ).setBookName(t.getNewValue());
                }
            }
        );
        
    	bookShelf.setItems(bookData);
    	bookShelf.getColumns().addAll(bookNameCol);
    }
}