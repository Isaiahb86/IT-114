package asst2;

//===================================================  
// Name       :  Tsagan Garyaeva
// SID        :  31483539 
// Course     :  IT-114  
// Section    :  452 
// Instructor :  Maura Deek 
// T.A        :   
//===================================================   
//===================================================  
// Assignment # :  2  
// Date         :  02/24/2019 
//===================================================   
//===================================================  
//Create a GUI that will allow a user to reserve seats 




import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;

public class Movie extends Application{

	private ComboBox<String> prices;
	private ComboBox<String> movies;
	private ComboBox<String> seats;

	
	TextArea order;
	TextField name = new TextField();
	ToggleGroup delGroup = new ToggleGroup();
	private Button orderit, clearit;
	private Label lb_order;
	
	

	private ObservableList<String> price =FXCollections.observableArrayList ("Adult-$10.50",
	"Child-$5.25");

	private ObservableList<String> movie =FXCollections.observableArrayList ("HOW TO TRAIN YOUR DRAGON: THE HIDDEN WORLD",
	"ALITA: BATTLE ANGEL","FIGHTING WITH MY FAMILY", "ISN'T IT ROMANTIC");
	
   private ObservableList<String> seat =FXCollections.observableArrayList ("1", "2", "3", "4", "5");

   	
	// vars	  
	String result3 =""; 
	double topCost;
   double cost;
	double total;
	double subtotal;
	final double TAXRATE = 0.07 ;
	double tax;
   int TOTAL_SEATS = 300;
	
   
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void start(Stage window) throws Exception {
		
		// area to place the various components
		BorderPane pane = new BorderPane();
		
		//VBox with movies types
		VBox movies_pane = new VBox(30);
		movies = new ComboBox(movie);
		movies.setValue("Movie: "); 
		movies.setMaxWidth(300);
		movies_pane.getChildren().add(movies);
		
		
		
		
		// VBox with prices
		VBox prices_pane = new VBox(30);		
		prices = new ComboBox(price);
		prices.setValue("Price:"); 
		prices.setMaxWidth(300);
		prices_pane.getChildren().add(prices);
		
		
		// VBox with seats
		VBox seats_pane = new VBox(30);		
		seats = new ComboBox(seat);
		seats.setValue("Seat: "); 
		seats.setMaxWidth(300);
		seats_pane.getChildren().add(seats);
		

		
		
	   // main pane
		HBox main = new HBox(20);
		main.getStyleClass().add("main");
		main.getChildren().addAll(prices_pane,movies_pane, seats_pane);
		main.setAlignment(Pos.TOP_CENTER);
		main.setPadding(new Insets(10, 10, 10, 10));
		main.setStyle("-fx-background-color:#7408d8; -fx-text-fill:#7408d8;-fx-font-size: 17;-fx-padding: 10px;");
		
	
		
		
				
		// Summary pane 
		VBox order_pane = new VBox(10);
		lb_order = new Label("Summary of your order: ");
		lb_order.setStyle("-fx-text-fill:#ffc87b; -fx-text-fill:#f9fafc; -fx-font-size: 17;-fx-padding: 10px;");
		order = new TextArea();
		order.setEditable(false);
		order.setPrefColumnCount(10);
		order.setMinWidth(700);
		order.setMinHeight(200);
		order_pane.getChildren().addAll(lb_order, order);
		
		
		HBox order_pane2 = new HBox(10);
		order_pane2.getChildren().addAll(order_pane);
		order_pane2.setAlignment(Pos.TOP_CENTER);
		
		// Bottom section with buttons
		HBox btn_pane = new HBox(20);
		btn_pane.setAlignment(Pos.BOTTOM_CENTER);
		orderit = new Button("Place Order");
		clearit = new Button("Cancel Order");
		btn_pane.getChildren().addAll(orderit, clearit);
		btn_pane.setPadding(new Insets(10, 10, 10, 10));
		
		
		//VBox with orderpane and buttons
		VBox b_section = new VBox(10);
		b_section.setPadding(new Insets(10, 10, 10, 10));
		b_section.getChildren().addAll(order_pane2, btn_pane);
		btn_pane.setStyle("-fx-background-color:#7408d8; -fx-text-fill:#c44b27;-fx-font-size: 17;-fx-padding: 10px;");
		order_pane2.setStyle("-fx-background-color:#7408d8; -fx-text-fill:#f9fafc;-fx-font-size: 17;-fx-padding: 10px;");
		
		//form  top section
		HBox form = new HBox();
		VBox labels = new VBox();
		VBox inputs = new VBox(10);
		form.setAlignment(Pos.TOP_CENTER);
		form.setStyle("-fx-background-color:#7408d8; -fx-text-fill:#7408d8;-fx-font-size: 17;-fx-padding: 10px;");
		Label text  = new Label("Xscape Theatres");
		text.setFont(new Font("Arial",30));
		text.setStyle("-fx-text-fill: #7408d8"); 
		Label lblform  = new Label("Welcome!!!");
		lblform.setStyle("-fx-text-fill:#7408d8; -fx-font-size: 20px;");
		VBox welcome = new VBox(10);
		welcome.getChildren().addAll(text, lblform);
		welcome.setAlignment(Pos.TOP_CENTER);
		
		
		// define width limits
		name.setMinWidth(350);
		Label lblname= new Label("Enter Your Name: ");
		lblname.setStyle(" -fx-text-fill:#f9fafc");
		name.setPromptText("Name");
		labels.getChildren().add(lblname);
		
		inputs.getChildren().add(name);
		form.getChildren().addAll(labels, inputs);
		form.setPadding(new Insets(10, 10, 10, 10));
		
		VBox f_form = new VBox();
		f_form.setPadding(new Insets(10, 10, 10, 10));
		f_form.getChildren().addAll(welcome, form);
		
		
		
		// Subscribe for when the user clicks the buttons
		OrderHandler oh = new OrderHandler();
		orderit.setOnAction(oh);
		clearit.setOnAction(oh);
		clearit.setOnAction(e -> clear());
		
				
		// Add all to the main pane
		pane.setTop( f_form );
		pane.setBottom(b_section);
		pane.setCenter(main);
	
		// the main window 
		Scene scene = new Scene(pane, 900, 600);
		window.setTitle("Xscape Theatres");
		window.setScene(scene);
		window.show();
		
	}
	
	// Cancel the order method
	public void clear() {
		order.setText("");
		name.clear();
      TOTAL_SEATS = 300;
		prices.setValue("Pick a Ticket Price"); 
		movies.setValue("Pick a Movie"); 
      seats.setValue("Pick a Seat"); 
	}
	
	
   
	class OrderHandler implements EventHandler<ActionEvent> {
		
		public void handle(ActionEvent e) {
      
			// validate name
			String name_n = name.getText();
        
		   				
			if (name_n.isEmpty())
			{
				name.setText("Enter your name");
				name.setStyle("-fx-text-fill: red; -fx-font-size: 16;");	
				order.setText("Please, fill the form above.");
				order.setStyle("-fx-text-fill: red; -fx-font-size: 16;");
				return;
			} 
			
			 // if event occurs
			if (e.getSource() == orderit) {
				// price
				String result = prices.getValue();
				// movies types
				String result2 = movies.getValue();
			   // movies seats
				String result3 = seats.getValue();
            
            
		    // Cost of tickets             
			if (prices.getValue().equals("Adult-$10.50")){
					cost = 10.50;
				}
			else if(prices.getValue().equals("Child-$5.25")){
					cost = 5.25;
				}
         if(result3.equals(null)){
					result3= "";
				} 				
			   //Cost of seats
			if (result3.contains("1")){
               topCost=1;             
               TOTAL_SEATS-=1;
				}
			if (result3.contains("2")){
					 topCost=2;
					TOTAL_SEATS-=2;
				}
			if (result3.contains("3")){
					topCost=3;
					TOTAL_SEATS-=3;
				}
         if (result3.contains("4")){
					 topCost=4;
					TOTAL_SEATS-=4;
				}
			if (result3.contains("5")){
					topCost=5;
					TOTAL_SEATS-=5;
				}

            
         if (result3.contains("")){
               order.setText("Please, pick a seat.");
            }
			

				//System.out.println(cost);
            
				subtotal = (cost*topCost);
				total = (subtotal* TAXRATE) + subtotal;
            total = Math.round(total);
				
				order.setText( 
						 					"Name: " + name.getText() + "\n" + 
                                 "Movie type: "	+ result2  + " \n"+
                                 "Total seats you ordered: " + result3 + "\n" + 
                                 "Price: "+ result  + " \n"+ 
						 					"Total due (includes 7% taxes): " + "$"+ total + "\n" + 
                                 "Total seats remain: " + TOTAL_SEATS + "\n" +
						 					"Enjoy the movie!");
						 
				} // end of logic for orderit button
			
			else 
			{	
			order.setText("Please, enter your name");
			name.clear();
						
			}
		}
	
	}
	
	
	// main method
	public static void main(String[] args) {
		Application.launch(args);
	}
}
