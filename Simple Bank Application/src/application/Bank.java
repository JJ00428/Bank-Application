package application;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Bank extends Application{
	
	private double balanceAmount = 0;
	private Label balance;
	private Label depositBalance;
	private Label withdrawBalance;
	private Button deposit;
	private Button withdraw;
	private Button exit;
	private TextField depositAmount;
	private Button insertdeposit;
	private Label dwarning;
	private TextField withdrawAmount;
	private Button insertwithdraw;
	private Label wwarning;
	private Button dback;
	private Button wback;
	private static Stage window;
	Scene scene,depositscene,withdrawscene;
	
	
	
	public static void main(String[] args) {
		
		launch(args);
	}
	
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		window = primaryStage;
		balance = new Label("Balance: "+ balanceAmount +"$");
		deposit = new Button ("Deposit");
		withdraw = new Button ("Withdraw");
		exit = new Button ("End Session");
		
		
		//scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
		
		deposit.setStyle("-fx-background-color: #5D7698;-fx-text-fill:White");
        withdraw.setStyle("-fx-background-color: #5D7698;-fx-text-fill:White");
        exit.setStyle("-fx-background-color: #5D7698;-fx-text-fill:White");
        
        
        applyHoverEffect(deposit);
        applyHoverEffect(withdraw);
        applyHoverEffect(exit);
		
		
		
		
		VBox V = new VBox(20);
		V.getChildren().addAll(balance,deposit,withdraw,exit);
		V.setAlignment(Pos.CENTER);
		
		scene = new Scene(V,1000,500);
		
		
		
		
		depositBalance = new Label("Balance: "+ balanceAmount +"$");
		depositAmount = new TextField();
		insertdeposit = new Button("Deposit Money");
		dback = new Button("Back to Main Menu");
		dwarning = new Label();
		
		
		
		
		insertdeposit.setStyle("-fx-background-color: #5D7698;-fx-text-fill:White");
		dback.setStyle("-fx-background-color: #5D7698;-fx-text-fill:White");
		
		
		applyHoverEffect(insertdeposit);
        applyHoverEffect(dback);
		
		
		
		
		depositAmount.setMaxWidth(130);
		dwarning.setStyle("-fx-font-size: 20px;; -fx-font-weight: bold;;-fx-text-fill: #D74A48  ");
		
		
		
		VBox D = new VBox(20);
		D.getChildren().addAll(depositBalance,depositAmount,insertdeposit,dback,dwarning);
		D.setAlignment(Pos.CENTER);
		
		depositscene= new Scene(D,1000,500);
		
		
		insertdeposit.setOnAction(e -> {
								try{
						            double damount = Double.parseDouble(depositAmount.getText());
						            String in = depositAmount.getText();
						            if(damount<0 || in.isEmpty()){dwarning.setText("Invalid Deposit Amount");}
						            else{
						            	dwarning.setText("");
						            	balanceAmount += damount;
						            	depositBalance.setText("Balance: $" + balanceAmount);
						            	withdrawBalance.setText("Balance: $" + balanceAmount);
						            	balance.setText("Balance: $" + balanceAmount);
						            	}
									} catch (NumberFormatException e1) {
								        dwarning.setText("Invalid input,Please enter a valid number.");
								    }
						            depositAmount.clear();
						        });
		
		
		
		
		
		
		withdrawBalance = new Label("Balance: "+ balanceAmount +"$");
		withdrawAmount = new TextField();
		insertwithdraw = new Button("Withdraw Money");
		wback = new Button("Back to Main Menu");
		wwarning = new Label();
		
		
		
		insertwithdraw.setStyle("-fx-background-color: #5D7698;-fx-text-fill:White");
		wback.setStyle("-fx-background-color: #5D7698;-fx-text-fill:White");
		
		
		applyHoverEffect(insertwithdraw);
        applyHoverEffect(wback);
		
		
		withdrawAmount.setMaxWidth(130);
		wwarning.setStyle("-fx-font-size: 20px;; -fx-font-weight: bold;;-fx-text-fill: #D74A48  ");
		
		
		
		
		VBox W = new VBox(20);
		W.getChildren().addAll(withdrawBalance,withdrawAmount,insertwithdraw,wback,wwarning);
		W.setAlignment(Pos.CENTER);
		
		withdrawscene= new Scene(W,1000,500);
		
		
		insertwithdraw.setOnAction(e -> {
			try{
	            double wamount = Double.parseDouble(withdrawAmount.getText());
	            String win = withdrawAmount.getText();
	            if(wamount<0 || win.isEmpty()){ wwarning.setText("Invalid Withdraw Amount");
	            			 }
	            else if( 
	            		wamount>balanceAmount){wwarning.setText("Sorry, Your Account Does Not Have Enough Money.");
	            		}
	            else{ 	wwarning.setText("");
	            		balanceAmount -= wamount;
	            		withdrawBalance.setText("Balance: $" + balanceAmount);
	            		depositBalance.setText("Balance: $" + balanceAmount);
	            		balance.setText("Balance: $" + balanceAmount);
	            	}
				} catch (NumberFormatException e1) {
			        wwarning.setText("Invalid input,Please enter a valid number.");
			    }
	         withdrawAmount.clear();
            
        });
		
		
		
		
		
		
		balance.setStyle("-fx-font-weight: bold; -fx-font-size: 30px; -fx-text-fill: white;");
		depositBalance.setStyle("-fx-font-weight: bold; -fx-font-size: 30px; -fx-text-fill: white;");
		withdrawBalance.setStyle("-fx-font-weight: bold; -fx-font-size: 30px; -fx-text-fill: white;");
		
		
		
		
		
		
		
		
		Image bg= new Image("bg1.jpg");
		BackgroundSize bgSize = new BackgroundSize(1.0, 1.0, true, true, false, false);
		BackgroundImage bg1= new BackgroundImage(bg, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
        BackgroundPosition.DEFAULT, bgSize);
		V.setBackground(new Background(bg1));
		D.setBackground(new Background(bg1));
		W.setBackground(new Background(bg1));
		
		
		
		
		
		
		
		deposit.setOnAction(e -> { 
			window.setScene(depositscene);
			//window.setFullScreen(true); 
			});
		
		
		withdraw.setOnAction(e -> { 
			window.setScene(withdrawscene);
			//window.setFullScreen(true); 
			});
		
		dback.setOnAction(e -> { 
			window.setScene(scene);
			//window.setFullScreen(true); 
			});
		
		wback.setOnAction(e -> { 
			window.setScene(scene);
			//window.setFullScreen(true); 
			});
		
		exit.setOnAction(e -> window.close());
		
		
		//window.setFullScreen(true);
		window.setScene(scene);
		window.setTitle("Bank");
		window.show();
		
		
	}
	
	
	 private void applyHoverEffect(Button button) {
	        DropShadow shadow = new DropShadow();
	        shadow.setColor(javafx.scene.paint.Color.WHITE); // Set shadow color to white
	        button.setOnMouseEntered(e -> button.setEffect(shadow));
	        button.setOnMouseExited(e -> button.setEffect(null));
	    }

}
