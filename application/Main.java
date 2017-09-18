//Name: Wei Liu
//Student ID: R00139080
package application;
	

import java.io.*;
import java.sql.Date;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;


public class Main extends Application {
	Stage window;	
	Date invoiceDate;
	Date paymentDate;
	
	ArrayList<Patient> patientList = new ArrayList<Patient>();
	ComboBox<String> patientInv;
	ComboBox<String> patientPro;
	ComboBox<String> invoicePro;
	ComboBox<String> invoicePay;
	ComboBox<String> patientPay;
	ComboBox<String> patientRemInv;
	ComboBox<String> invoiceRemInv;
	ComboBox<String> patientRemPro;
	ComboBox<String> invoiceRemPro;
	ComboBox<String> procedureRem;
	ComboBox<String> patientSortbyName;
 	ListView<String> list;
	Patient p; 
	Invoice i;
	Procedure pro;
	Payment pay;
	double getPrice;
	String pN;
	String Y;
	
	int patientCounter = 1; 
	int invoiceCounter = 1;
	int procedureCounter = 1;
	int paymentCounter = 1;
	
	@Override
    public void start(Stage primaryStage) throws Exception{
        window = primaryStage;   
		primaryStage.setTitle("Dentist Program");
		window.getIcons().add(new Image("images/icon.jpg"));
        Scene scene1, scene2, scene3, scene4, scene5, scene6, scene7;
        TextArea welcomeBox = new TextArea();
        TextArea removeDisBox = new TextArea();
        TextArea disPBox = new TextArea();
        TextArea searchBox = new TextArea();
        TextArea allBox = new TextArea();
        disPBox.setMaxSize(500, 500);
        removeDisBox.setId("textField");
        disPBox.setId("textField");
        searchBox.setId("textField");
        welcomeBox.setId("textField1");
        allBox.setId("textField");
        
         
        
        BorderPane mm = new BorderPane();
        mm.setId("login");
        
        BorderPane removeP = new BorderPane();
        removeP.setId("pane1");
        
        BorderPane searchP = new BorderPane();
        searchP.setId("pane1");
        
        FlowPane reportPane = new FlowPane();
        reportPane.setAlignment(Pos.CENTER);
        reportPane.setOrientation(Orientation.VERTICAL);
        reportPane.setVgap(10);
        reportPane.setHgap(10);
        reportPane.setPrefWrapLength(5);
        reportPane.setId("login");
        
        FlowPane payPane = new FlowPane();
        payPane.setAlignment(Pos.CENTER);
        payPane.setOrientation(Orientation.VERTICAL);
        payPane.setVgap(10);
        payPane.setHgap(10);
        payPane.setPrefWrapLength(5);
        payPane.setId("pane");
        
        FlowPane disP = new FlowPane();
        disP.setAlignment(Pos.CENTER);
        disP.setOrientation(Orientation.VERTICAL);
        disP.setVgap(10);
        disP.setHgap(10);
        disP.setPrefWrapLength(5);
        disP.setId("pane1");
      
        FlowPane flow = new FlowPane();
        flow.setAlignment(Pos.CENTER);
        flow.setOrientation(Orientation.VERTICAL);
        flow.setVgap(10);
        flow.setHgap(10);
        flow.setPrefWrapLength(5);
        flow.setId("pane");
        
        FlowPane flow1 = new FlowPane();
        flow1.setAlignment(Pos.CENTER);
        flow1.setOrientation(Orientation.VERTICAL);
        flow1.setVgap(10);
        flow1.setHgap(10);
        flow1.setPrefWrapLength(5);
        flow1.setId("pane1");
      
  
        TabPane tabPane = new TabPane();
        
        tabPane.setTabMinHeight(50);
        BorderPane mainPane = new BorderPane();
        mainPane.setId("pane");
        
        
       
       
        Tab exit = new Tab();
        exit.setText("Save and Exit");
        VBox exit_vBox = new VBox();
        exit_vBox.setAlignment(Pos.CENTER);
        Button tabBack = new Button("Save and Exit");
        tabBack.setId("label");
        exit_vBox.getChildren().add(tabBack);
        exit.setContent(exit_vBox);
        
        mainPane.setCenter(tabPane);
        tabPane.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);
       
     
        Button addPatientMenu = new Button("Add Patient");
        addPatientMenu.setPrefSize(100, 20);
       
        Button removePatientBtn = new Button("Remove Patient");
        removePatientBtn.setPrefSize(110, 20); 
   
        Button dispP = new Button("Display Patient");
        dispP.setPrefSize(100, 20);

        Button searP = new Button("Search Patient");
        searP.setPrefSize(100, 20);

        Button btn5 = new Button("Quit");
        btn5.setPrefSize(110, 20);
        
        Button btn6 = new Button("Add Payment");
        btn6.setPrefSize(100, 20);
        
        Button btn7 = new Button("Add Procedure");
        btn7.setPrefSize(100, 20);
        
        Button btn8 = new Button("Patient Menu");
        btn8.setPrefSize(180, 30);
        
        Button btn9 = new Button("Back");
        btn9.setPrefSize(100, 20);
        Button btn90 = new Button("Back");
        btn90.setPrefSize(100, 20);
        Button btn91 = new Button("Back");
        btn91.setPrefSize(130, 30);
        Button btn92 = new Button("Back");
        btn92.setPrefSize(130, 30);
        Button backFromRepbtn = new Button("Back");
        btn92.setPrefSize(130, 30);
        Button backToMenu = new Button("Back");
        backToMenu.setPrefSize(110, 20);
        backToMenu.setId("label");
        backToMenu.setAlignment(Pos.CENTER);
       
        Button addPay = new Button("Pay");
    	addPay.setPrefSize(110, 20);
        addPay.setId("label");
        addPay.setAlignment(Pos.CENTER);
        
        Button btn10 = new Button("Save");
        btn10.setPrefSize(100, 20);
      
        Button removePatient = new Button("Remove");
        removePatient.setPrefSize(100,  20);
        
        Button searchPatient = new Button("Search");
        searchPatient.setPrefSize(100,  20);
        
        Button invandproBtn = new Button("Invoice/Procedure Menu");
        invandproBtn.setPrefSize(180, 30);
        
        Button payMenuBtn = new Button("Payment Menu");
        payMenuBtn.setPrefSize(180, 30);
        
        Button btn13 = new Button("Report");
        btn13.setPrefSize(180, 30);
        
        Button startBtn = new Button("Start");
	    startBtn.setPrefSize(120, 34);
	    startBtn.setId("glass-grey"); 
	    Button showP = new Button("Display All");
	    showP.setPrefSize(130, 30);
	    Button showR = new Button("Display All Information Of Patient");
	    showP.setPrefSize(130, 30);
       
	    
	    DropShadow dropShadow = new DropShadow();
        dropShadow.setRadius(7.0);
        dropShadow.setOffsetX(5.0);
        dropShadow.setOffsetY(5.0);
        dropShadow.setColor(Color.color(0.4, 0.5, 0.5));
        
        Label patientTitle = new Label("Welcome to Patient Menu");
        patientTitle.setPadding(new Insets(8 ,40 , 40 ,130));
        patientTitle.setFont(Font.font ("Tohoma",FontWeight.BOLD, 30));
        patientTitle.setTextFill(Color.YELLOW);
        patientTitle.setEffect(dropShadow);;
       
        HBox hbox = new HBox();
        hbox.setPadding(new Insets(5,20,20,90));
        hbox.setMinWidth(100);
        hbox.setSpacing(60);
        hbox.getChildren().addAll(addPatientMenu,removePatientBtn, dispP);
       
        HBox hbox2 = new HBox();
        hbox2.setPadding(new Insets(8,40,40,170));
        hbox2.setSpacing(60);
        hbox2.getChildren().addAll(searP, btn5);
       
        HBox hbox3 = new HBox(welcomeBox);
        hbox3.setPadding(new Insets(11,60,60,70));
       
        HBox disPatient = new HBox(disPBox);
        disPatient.setPadding(new Insets(0,0,0,0));
        
        
        HBox disPbtn = new HBox();
        disPbtn.setPadding(new Insets(5,20,20,100));
        disPbtn.setMinWidth(100);
        disPbtn.setSpacing(60);
        disPbtn.getChildren().addAll(showP, btn91);
        
        VBox vbox = new VBox();
        vbox.setAlignment(Pos.CENTER);
        vbox.setSpacing(30);
        vbox.setPrefWidth(5);
        vbox.setId("login");
        
        HBox hbox4 = new HBox();
        hbox4.setPadding(new Insets(18,40,40,80));
        hbox4.setSpacing(60);
        hbox4.getChildren().addAll(btn9, btn10);
        
        VBox vbox2 = new VBox();
        vbox2.setPadding(new Insets(8,40,40,85));
        vbox2.setSpacing(50);
        
        VBox vbox3 = new VBox();
        vbox3.setPadding(new Insets(8,130,40,0));
        vbox3.setSpacing(50);
       
        HBox removeBox = new HBox();
        removeBox.setPadding(new Insets(110,10,10,20));
        removeBox.setAlignment(Pos.TOP_CENTER);
        removeBox.setSpacing(10);
        
        ToggleGroup group = new ToggleGroup();
        RadioButton rdo1 = new RadioButton("Remove By Name");
        rdo1.setToggleGroup(group);
        RadioButton rdo2 = new RadioButton("Remove By ID");
        rdo2.setToggleGroup(group);
  
        removeBox.getChildren().addAll(rdo1, rdo2);
        removeP.setTop(removeBox);
        
        HBox removeBox1 = new HBox();
        removeBox1.setPadding(new Insets(10,10,10,10));
        removeBox1.setSpacing(10);
        removeBox1.setAlignment(Pos.CENTER);
        removeP.setCenter(removeBox1);
        
        HBox hbox5 = new HBox(removeDisBox);
        hbox5.setPadding(new Insets(11,60,60,70));
        removeP.setBottom(hbox5);
	    
        HBox searpatientInv = new HBox();
        searpatientInv.setPadding(new Insets(110,10,10,20));
        searpatientInv.setAlignment(Pos.TOP_CENTER);
        searpatientInv.setSpacing(10);
    
        ToggleGroup group1 = new ToggleGroup();
        RadioButton searrdo1 = new RadioButton("Search By Name");
        searrdo1.setToggleGroup(group1);
        RadioButton searrdo2 = new RadioButton("Search By ID");
        searrdo2.setToggleGroup(group1);
  
        searpatientInv.getChildren().addAll(searrdo1, searrdo2);
        searchP.setTop(searpatientInv);
        
        HBox searchBox1 = new HBox();
        searchBox1.setPadding(new Insets(10,10,10,10));
        searchBox1.setSpacing(10);
        searchBox1.setAlignment(Pos.CENTER);
        searchP.setCenter(searchBox1);
        
        HBox hbox6 = new HBox(searchBox);
        hbox6.setPadding(new Insets(11,60,60,70));
        searchP.setBottom(hbox6);
        
        
        
	    Label wel = new Label("WELCOME");
	    wel.setFont(Font.font ("Tohoma", FontWeight.BOLD, 30));
	    wel.setTextFill(Color.YELLOW);
	    vbox.getChildren().add(wel);
	    vbox2.getChildren().addAll(btn8, invandproBtn);
	    vbox3.getChildren().addAll(payMenuBtn, btn13);
	    
	    Label menu = new Label("Management Menu");
	    menu.setAlignment(Pos.CENTER);
	    menu.setPadding(new Insets(8 ,40 , 40 ,160));
	    menu.setFont(Font.font("Tohoma",FontWeight.BOLD, 30));
	    menu.setTextFill(Color.YELLOW);
	    mm.setTop(menu);
	    mm.setLeft(vbox2);;
	    mm.setRight(vbox3);
	    
	    
	    
	   
	    scene1 = new Scene(vbox , 200, 400);
	    scene2 = new Scene(mm, 200, 300);
	    scene3 = new Scene(flow, 600 ,500);
	    scene4 = new Scene(flow1, 600 ,500);
	    scene5 = new Scene(removeP, 600, 500);
	    scene6 = new Scene(disP, 600, 500);
	    scene7 = new Scene(searchP, 600 ,500);
	    Scene invproscene = new Scene(mainPane, 600, 500);
	    Scene payscene = new Scene(payPane, 600,500);
	    Scene reportScene = new Scene(reportPane, 1600, 1500);
	   
	    
	    
	      
	    addPatientMenu.setOnAction(e -> window.setScene(scene4));
	    removePatientBtn.setOnAction(e -> window.setScene(scene5));
	    dispP.setOnAction(e -> window.setScene(scene6));
	    searP.setOnAction(e -> window.setScene(scene7));
	    btn5.setOnAction(e -> window.setScene(scene2));
	    btn8.setOnAction(e -> window.setScene(scene3));
	    btn9.setOnAction(e -> goBack(scene3));
	    btn13.setOnAction(e -> window.setScene(reportScene));
	    btn90.setOnAction(e -> goBack(scene3));
	    btn91.setOnAction(e -> goBack(scene3));
	    btn92.setOnAction(e -> goBack(scene3));
	    invandproBtn.setOnAction(e -> window.setScene(invproscene));
	    payMenuBtn.setOnAction(e -> window.setScene(payscene));
	    tabBack.setOnAction(e -> {
	    	saveData();
	    	window.setScene(scene2);
	    	
	    });
	    backToMenu.setOnAction(e -> window.setScene(scene2));
	    showR.setOnAction(e -> {
	    	readData();
	    	int b = patientSortbyName.getSelectionModel().getSelectedIndex();
	    	for(int c = 0; c <patientList.size(); c++ )
	    	{
	    		
	    	  allBox.setText(patientList.get(b).toString());
	    	}
	    });
	    backFromRepbtn.setOnAction(e -> window.setScene(scene2));
 
	    flow.getChildren().addAll(patientTitle, hbox, hbox2, hbox3);
	    
	       
	    Label userName = new Label("User Name:");
        vbox.getChildren().add(userName);
        TextField denName = new TextField();
	    denName.setPromptText("Name Only");
        vbox.getChildren().add(denName);
        denName.setMinHeight(35);
        denName.setMaxWidth(200);
        denName.setId("textField");
       
        reportPane.getChildren().addAll(sortByName(), showR,backFromRepbtn, allBox);
        
        startBtn.setOnAction(e -> {
        	readData();
        	try{
        		for(int m=0; m < patientList.size(); m++)
	        {
	          patientInv.getItems().add(patientList.get(m).Name);    		
			  patientPro.getItems().add(patientList.get(m).Name);
			  patientPay.getItems().add(patientList.get(m).Name);
			  patientRemInv.getItems().add(patientList.get(m).Name);
			  patientRemPro.getItems().add(patientList.get(m).Name);
			  patientSortbyName.getItems().add(patientList.get(m).Name);
			
	        	
	        }
	
        		  patientPro.valueProperty().addListener(new ChangeListener<String>() {
  		        	public void changed(ObservableValue<? extends String> observable, String old, String newv) {
  		        		
  		        		invoicePro.getItems().clear();
  		        		int iTmp = patientPro.getSelectionModel().getSelectedIndex();
  		        	
  		        		ArrayList<Invoice> tmp_invoice = patientList.get(iTmp).getp_invoiceList();
  		        		
  		        		
  		        				for(int ii = 0; ii < tmp_invoice.size(); ii++) 
  		        				{
  		        				 String tmp_invoice_number = Integer.toString( tmp_invoice.get(ii).getinvoiceNo() );
  		        				 invoicePro.getItems().add(tmp_invoice_number);
  		        				}
  		        		
  		        	}
  		        });
        		  patientPay.valueProperty().addListener(new ChangeListener<String>() {
		        	    public void changed(ObservableValue<? extends String> observable, String old1, String newv1) {
		        		
		        		invoicePay.getItems().clear();
		        		
		        		int iTmp1 = patientPay.getSelectionModel().getSelectedIndex();
		        	
		        		ArrayList<Invoice> tmp_invoice1 = patientList.get(iTmp1).getp_invoiceList();
		        		
		        		
		        				for(int iii = 0; iii < tmp_invoice1.size(); iii++) 
		        				{
		        				 String tmp_invoice_number1 = Integer.toString( tmp_invoice1.get(iii).getinvoiceNo() );
		        				 invoicePay.getItems().add(tmp_invoice_number1);    				 
		        				}
		        				
		        	}
		        });
	    			  patientRemInv.valueProperty().addListener(new ChangeListener<String>() {
	  		        	    public void changed(ObservableValue<? extends String> observable, String old1, String newv1) {
	  		        		
	  		        	    	invoiceRemInv.getItems().clear();
	  		        		
	  		        		int iTmp1 = patientRemInv.getSelectionModel().getSelectedIndex();
	  		        	
	  		        		ArrayList<Invoice> tmp_invoice1 = patientList.get(iTmp1).getp_invoiceList();
	  		        		
	  		        		
	  		        				for(int iiii = 0; iiii < tmp_invoice1.size(); iiii++) 
	  		        				{
	  		        				 String tmp_invoice_number2 = Integer.toString( tmp_invoice1.get(iiii).getinvoiceNo() );
	  		        				invoiceRemInv.getItems().add(tmp_invoice_number2);    				 
	  		        				}
	  		        				
	  		        	}
	  		        });
	    			  patientRemPro.valueProperty().addListener(new ChangeListener<String>() {
	  		        	    public void changed(ObservableValue<? extends String> observable, String old1, String newv1) {
	  		        		
	  		        	    	invoiceRemPro.getItems().clear();
	  		        		
	  		        		int iTmp1 = patientRemPro.getSelectionModel().getSelectedIndex();
	  		        	
	  		        		ArrayList<Invoice> tmp_invoice1 = patientList.get(iTmp1).getp_invoiceList();
	  		        		
	  		        		
	  		        				for(int iiii = 0; iiii < tmp_invoice1.size(); iiii++) 
	  		        				{
	  		        				 String tmp_invoice_number2 = Integer.toString( tmp_invoice1.get(iiii).getinvoiceNo() );
	  		        				invoiceRemPro.getItems().add(tmp_invoice_number2);    				 
	  		        				}
	  		        				
	  		        	}
	  		        });
        	}catch(ArrayIndexOutOfBoundsException v)
	        {
	        	
	        }
	        welcomeBox.setText("Welcome Doctor: " + denName.getText());
	        if(denName.getText().isEmpty())
 	       {
 		    Alert error = new Alert(AlertType.ERROR, "Please Enter Name", ButtonType.CLOSE);
 		    error.showAndWait();
 	       }
	     else
	       {
	    	  window.setScene(scene2);
	       }
	    
	    }); 
         
        Label passw = new Label("Password:");
        vbox.getChildren().add(passw);
        TextField passwd = new TextField();
	    passwd.setPromptText("Password");
        vbox.getChildren().add(passwd);
        passwd.setMinHeight(35);
        passwd.setMaxWidth(200);
      
        vbox.getChildren().add(startBtn);
        
        Label PatientName = new Label("Patient Name: *");
        flow1.getChildren().add(PatientName);
        TextField pName = new TextField();
        pName.setPromptText("Required");
        flow1.getChildren().add(pName);
        pName.setMinHeight(35);
        pName.setMaxWidth(200);
          
        Label address = new Label("Address: *");
        flow1.getChildren().add(address);
        TextField adds = new TextField();
        adds.setPromptText("Required");
        flow1.getChildren().add(adds);
        adds.setMinHeight(35);
        adds.setMaxWidth(200);
        
        Label contactNum = new Label("Contact Number: *");
        flow1.getChildren().add(contactNum);
        TextField contactNumText = new TextField();
        contactNumText.setPromptText("Required");
        flow1.getChildren().add(contactNumText);
        contactNumText.setMinHeight(35);
        contactNumText.setMaxWidth(200);
        
        flow1.getChildren().addAll(hbox4);
        
        TextField removeF = new TextField();
        removeF.setPromptText("Name or ID");
        removeBox1.getChildren().addAll(removeF,removePatient, btn90);
        
        TextField searchF = new TextField();
        searchF.setPromptText("Name or ID");
        searchBox1.getChildren().addAll(searchF,searchPatient, btn92);
        
        Label show = new Label();
        disP.getChildren().addAll(show,disPbtn, disPatient);
        
        TextField payAmt = new TextField();
    	payAmt.setDisable(true);
    	payAmt.setId("textField");
    	 
    	
    	TextField enterPayAmt = new TextField();
    	enterPayAmt.setPromptText("Enter Amount To Pay");
        enterPayAmt.setId("textField");
      
    	tabPane.getTabs().addAll(invTab(), proTab(payAmt), removeInvoiceTab(),removeProcedureTab(), exit); 
        addPayment(addPay,payAmt, enterPayAmt);
        payScene(payPane, backToMenu, addPay, payAmt, enterPayAmt);
        addPatientBtn(btn10, pName, adds, contactNumText);
        showPatient(showP, disPBox);
        removeRadioBtn(group,removePatient,removeF,rdo2, rdo1, removeDisBox);
        searchRadioBtn(group1,searchPatient,searchF,searrdo2, searrdo1, searchBox);
        getStylesheet(reportScene, payscene, invproscene, scene1, scene2, scene3, scene4, scene5, scene6, scene7);
        windowStyle(scene1);
        window.setOnCloseRequest(e -> saveData());
        
        
       
	}
	public Tab invTab(){
		
		    Tab addInvTab = new Tab();
		    addInvTab.setText("Add Invoice");

	        FlowPane addInv = new FlowPane();
	        addInv.setAlignment(Pos.CENTER);
	        addInv.setOrientation(Orientation.VERTICAL);
	        addInv.setVgap(10);
	        addInv.setHgap(10);
	        addInv.setPrefWrapLength(5);
	         	
	        Label totalAmount = new Label("Amount To Paid: ");
	        
	        TextField disInvAmount = new TextField();
	        disInvAmount.setDisable(true);
	        disInvAmount.setMaxHeight(15);
	        disInvAmount.setMaxWidth(200);
	        disInvAmount.setId("textField");
	        disInvAmount.setText("0");
	        
	        VBox invP = new VBox();
	        invP.setAlignment(Pos.CENTER);
	        invP.setSpacing(25);
	       
	        HBox radioPaid = new HBox();
	        ToggleGroup invGroup = new ToggleGroup();
	        RadioButton paid = new RadioButton("Paid");
	        paid.setToggleGroup(invGroup);
	        RadioButton unPaid = new RadioButton("UnPaid");
	        unPaid.setToggleGroup(invGroup);
	  
	        radioPaid.setAlignment(Pos.CENTER);
	        radioPaid.setSpacing(25);
	        radioPaid.getChildren().addAll(paid, unPaid);
	        	
	        HBox btnForInv = new HBox();
	        btnForInv.setAlignment(Pos.CENTER);
	        btnForInv.setSpacing(25);
	        
	        Button addInvoice = new Button("Add Invoice");
	        addInvoice.setAlignment(Pos.CENTER);
	        addInvoice.setId("label");
	        
	        btnForInv.getChildren().add(addInvoice);
	        
	        
	        
            invP.getChildren().add(addPatientToInv());
            invP.getChildren().addAll(totalAmount, disInvAmount);
	        addInv.getChildren().addAll(invP,radioPaid, btnForInv);

	        addInvoice(addInvoice, disInvAmount);
	        addInvTab.setContent(addInv);
		return addInvTab;
		
	}
	public Tab proTab(TextField payAmt){
		Tab addProTab  = new Tab();
        addProTab.setText("Add Procedure");
       
        
        FlowPane addPro = new FlowPane();
        addPro.setAlignment(Pos.CENTER);
        addPro.setOrientation(Orientation.VERTICAL);
        addPro.setVgap(10);
        addPro.setHgap(10);
        addPro.setPrefWrapLength(5);
                
        Label Name = new Label("Procedures: "); 
        Name.setAlignment(Pos.CENTER);
        Name.setId("label");
        Name.setFont(Font.font("Tohoma",FontWeight.BOLD, 40));
        
        Button addProBtn = new Button("Add");
        addProBtn.setPrefSize(110, 20);
        addProBtn.setId("label");
        addProBtn.setAlignment(Pos.CENTER);
        
        HBox buttonBox = new HBox(addProBtn);
        buttonBox.setAlignment(Pos.CENTER);
        
         
        VBox listView = new VBox();
       
      
        listView.setPadding(new Insets(-50,0,0,0));
        listView.setMaxHeight(250);
        listView.setAlignment(Pos.CENTER);
        listView.setSpacing(10);
        list = new ListView<String>();
        ObservableList<String> items =FXCollections.observableArrayList ("Braces", "Bridges and Implants", "Gum Surgery", 
        		"Oral Cancer Examination", "Teeth Whitening", "Sealants", "Veneers", "Extractions");
        list.setItems(items);
        list.setId("list");      
    
        
        listView.getChildren().addAll(addPatientToPro(),addinvoicePro(),list);

        TextField price = new TextField();
        price.setDisable(true);
        price.setId("textField");
        listView.getChildren().add(price);
       
     
        addProToInv(price, addProBtn, payAmt);
        
        
        addPro.getChildren().addAll(listView, buttonBox);
        addProTab.setContent(addPro);
              
        
        return addProTab;
		
	}
    public Tab removeInvoiceTab(){
    	
    	Tab removeInvTab = new Tab();
	    removeInvTab.setText("Remove Invoice");
	    
	    FlowPane remInv = new FlowPane();
        remInv.setAlignment(Pos.CENTER);
        remInv.setOrientation(Orientation.VERTICAL);
        remInv.setVgap(10);
        remInv.setHgap(10);
        remInv.setPrefWrapLength(5);
        
        TextArea disRemInv = new TextArea();
    
        VBox remInvBox = new VBox();
        remInvBox.setAlignment(Pos.CENTER);
        remInvBox.setSpacing(25);
        
        Button removeInvBtn = new Button("Remove Invoice");
        removeInvBtn.setAlignment(Pos.CENTER);
        removeInvBtn.setId("label");
        
        VBox remArea = new VBox();
        remArea.getChildren().add(disRemInv);
        remArea.setAlignment(Pos.CENTER);
        remArea.setSpacing(25);
        
        
        
        
        removeInv(removeInvBtn, disRemInv);
        remInvBox.getChildren().addAll(addPatientToRemInv(), addInvocieToRemInv(),removeInvBtn);
        remInv.getChildren().addAll(remInvBox, remArea);
        removeInvTab.setContent(remInv);
        
		return removeInvTab;
    	
    }
    public Tab removeProcedureTab(){
    	
    	Tab removeProTab = new Tab();
	    removeProTab.setText("Remove Procedure");
	    
	    FlowPane remPro = new FlowPane();
	    remPro.setAlignment(Pos.CENTER);
	    remPro.setOrientation(Orientation.VERTICAL);
	    remPro.setVgap(10);
	    remPro.setHgap(10);
	    remPro.setPrefWrapLength(5);
        
        TextArea disRemPro = new TextArea();
          
        VBox remProBox = new VBox();
        remProBox.setAlignment(Pos.CENTER);
        remProBox.setSpacing(25);
        
        Button removeProBtn = new Button("Remove Procedure");
        removeProBtn.setAlignment(Pos.CENTER);
        removeProBtn.setId("label");
        
        VBox remArea = new VBox();
        remArea.getChildren().add(disRemPro);
        remArea.setAlignment(Pos.CENTER);
        remArea.setSpacing(25);
        
        
        
        
        removePro(removeProBtn, disRemPro);
        remProBox.getChildren().addAll(addPatientToRemPro(), addInvocieToRemPro(),addProcedureToRem(), removeProBtn);
        remPro.getChildren().addAll(remProBox, remArea);
        removeProTab.setContent(remPro);
        
		return removeProTab;
    	
    }
    public void addInvoice(Button addInvoice, TextField disInvAmount){
		
    	
    	    addInvoice.setOnAction(e -> {
    	    if(patientList.size() > 0)
    	{	
   
        	int o =	patientInv.getSelectionModel().getSelectedIndex();
        	
        	double x = 0;
        	 try{	
			    	i = new Invoice(invoiceDate, x); 
			    }
		    	catch (NumberFormatException nfe) {     
		         JOptionPane.showMessageDialog(null,"Input must be a number.");
		    	}
        	
             try{
        	 if(patientInv.getSelectionModel().isSelected(o))
	    	   {
 
        		   i.invoiceNo = invoiceCounter;

	    		   Alert alert2 = new Alert(AlertType.CONFIRMATION, "Are You Sure To Save This Invoice" +  " ?", ButtonType.YES, ButtonType.NO);
	    		   Image image1 = new Image("/images/smile.jpg");
	    	       ImageView imageView = new ImageView(image1);
	    	       alert2.setGraphic(imageView);
	    		   alert2.showAndWait();

	    		   if (alert2.getResult() == ButtonType.YES)
	    		   {	    			 
	    			
	    				if(patientList.get(o).p_invoiceList.isEmpty())
	    				{  
		    				 invoiceCounter = 1;
		    				 i.invoiceNo = invoiceCounter;
	    				} 
	    			   invoiceCounter++;
	    			  
		    		  patientList.get(o).p_invoiceList.add(i);
		    			  	  
	    			  patientPro.valueProperty().addListener(new ChangeListener<String>() {
	    		        	public void changed(ObservableValue<? extends String> observable, String old, String newv) {
	    		        		
	    		        		invoicePro.getItems().clear();
	    		        		int iTmp = patientPro.getSelectionModel().getSelectedIndex();
	    		        	
	    		        		ArrayList<Invoice> tmp_invoice = patientList.get(iTmp).getp_invoiceList();
	    		        		
	    		        		
	    		        				for(int ii = 0; ii < tmp_invoice.size(); ii++) 
	    		        				{
	    		        				 String tmp_invoice_number = Integer.toString( tmp_invoice.get(ii).getinvoiceNo() );
	    		        				 invoicePro.getItems().add(tmp_invoice_number);
	    		        				}
	    		        		
	    		        	}
	    		        });
	    			  patientPay.valueProperty().addListener(new ChangeListener<String>() {
  		        	    public void changed(ObservableValue<? extends String> observable, String old1, String newv1) {
  		        		
  		        		invoicePay.getItems().clear();
  		        		
  		        		int iTmp1 = patientPay.getSelectionModel().getSelectedIndex();
  		        	
  		        		ArrayList<Invoice> tmp_invoice1 = patientList.get(iTmp1).getp_invoiceList();
  		        		
  		        		
  		        				for(int iii = 0; iii < tmp_invoice1.size(); iii++) 
  		        				{
  		        				 String tmp_invoice_number1 = Integer.toString( tmp_invoice1.get(iii).getinvoiceNo() );
  		        				 invoicePay.getItems().add(tmp_invoice_number1);    				 
  		        				}
  		        				
  		        	}
  		        });
	    			  patientRemInv.valueProperty().addListener(new ChangeListener<String>() {
	  		        	    public void changed(ObservableValue<? extends String> observable, String old1, String newv1) {
	  		        		
	  		        	    	invoiceRemInv.getItems().clear();
	  		        		
	  		        		int iTmp1 = patientRemInv.getSelectionModel().getSelectedIndex();
	  		        	
	  		        		ArrayList<Invoice> tmp_invoice1 = patientList.get(iTmp1).getp_invoiceList();
	  		        		
	  		        		
	  		        				for(int iiii = 0; iiii < tmp_invoice1.size(); iiii++) 
	  		        				{
	  		        				 String tmp_invoice_number2 = Integer.toString( tmp_invoice1.get(iiii).getinvoiceNo() );
	  		        				invoiceRemInv.getItems().add(tmp_invoice_number2);    				 
	  		        				}
	  		        				
	  		        	}
	  		        });
	    			  patientRemPro.valueProperty().addListener(new ChangeListener<String>() {
	  		        	    public void changed(ObservableValue<? extends String> observable, String old1, String newv1) {
	  		        		
	  		        	    	invoiceRemPro.getItems().clear();
	  		        		
	  		        		int iTmp1 = patientRemPro.getSelectionModel().getSelectedIndex();
	  		        	
	  		        		ArrayList<Invoice> tmp_invoice1 = patientList.get(iTmp1).getp_invoiceList();
	  		        		
	  		        		
	  		        				for(int iiii = 0; iiii < tmp_invoice1.size(); iiii++) 
	  		        				{
	  		        				 String tmp_invoice_number2 = Integer.toString( tmp_invoice1.get(iiii).getinvoiceNo() );
	  		        				invoiceRemPro.getItems().add(tmp_invoice_number2);    				 
	  		        				}
	  		        				
	  		        	}
	  		        });
  
	    			    
	    			  
	    			  Alert confirm1 = new Alert(AlertType.INFORMATION, "Invoice Saved", ButtonType.CLOSE);
	    			  Image image2 = new Image("/images/tick.png");
		    	      ImageView imageView1 = new ImageView(image2);
		    	      confirm1.setGraphic(imageView1);
	    			  confirm1.showAndWait();
	    			  
	    			 
	    			  if(confirm1.getResult() == ButtonType.CLOSE){
	    				
	    			  }
	    		   }
	    		   else if (alert2.getResult() == ButtonType.NO)
	    		   {
	    			  alert2.close();
	    		   }
	    	   }
	    	   else if(!patientInv.getSelectionModel().isSelected(o))
	    	   {
	    		   Alert error1 = new Alert(AlertType.ERROR, "Please Enter Required", ButtonType.CLOSE);
	    		   error1.showAndWait();
	    	   }
             } catch(ArrayIndexOutOfBoundsException l)
             {
            	 Alert error2 = new Alert(AlertType.WARNING, "No Patient Added, Please Add New Patient!!", ButtonType.CLOSE);
       		     error2.showAndWait();
             }catch(NullPointerException y)
             {
            	 
             }
        	
        	}else
        	{
        		Alert error2 = new Alert(AlertType.WARNING, "No Patient Added, Please Add New Patient!!", ButtonType.CLOSE);
      		    error2.showAndWait();
        	}
    	
    	
     });
    	
    	    
	}
	public void addProToInv(TextField price, Button addProBtn, TextField payAmt){
	
	
		list.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
			
			if(newValue == "Braces")
		     {
				price.setText("Price: ву100");
				getPrice = 100;
				pN = "Braces";
		     }
		    else if (newValue == "Teeth Whitening")
			 {
		    	price.setText("Price: ву70");
		    	getPrice = 70;
				pN = "Teeth Whitening";
			 }
			else if (newValue == "Bridges and Implants")
			 {
				price.setText("Price: ву120");
				getPrice = 120;
				pN = "Bridges and Implants";
			 }
		    else if (newValue == "Gum Surgery")
			 {
		    	price.setText("Price: ву110");
		    	getPrice = 110;
				pN = "Gum Surgery";
			 }
		    else if (newValue == "Oral Cancer Examination")
			 {
		    	price.setText("Price: ву200");
		    	getPrice = 200;
				pN = "Oral Cancer Examination";
			 }			 
		    else if (newValue ==  "Sealants")
			 {
		    	price.setText("Price: ву50");
		    	getPrice = 50;
				pN = "Sealants";
			 }
		    else if (newValue ==  "Veneers")
			 {
		    	price.setText("Price: ву40");
		    	getPrice = 40;
				pN = "Veneers";
			 }
		    else if (newValue == "Extractions")
			 {
		    	price.setText("Price: ву60");
		    	getPrice = 60;
				pN = "Extractions";
			 }
			
		  
		});
		addProBtn.setOnAction(e -> {
       
		try {
			
			int o =	patientPro.getSelectionModel().getSelectedIndex();
            int inv = invoicePro.getSelectionModel().getSelectedIndex();
        	int po = list.getSelectionModel().getSelectedIndex();
			ArrayList<Invoice> tmp_invoice1 = patientList.get(o).getp_invoiceList();
			
            
        	

        	  pro = new Procedure(pN, getPrice);
        	
        	
        	 if(patientPro.getSelectionModel().isSelected(o) && list.getSelectionModel().isSelected(po) )
	    	   {

      		       pro.procNo = procedureCounter;

	    		   Alert alert3 = new Alert(AlertType.CONFIRMATION, "Are You Sure To Save This Procedure" +  " ?", ButtonType.YES, ButtonType.NO);
	    		   Image image2 = new Image("/images/smile.jpg");
	    	       ImageView imageView = new ImageView(image2);
	    	       alert3.setGraphic(imageView);
	    		   alert3.showAndWait();

	    		   if (alert3.getResult() == ButtonType.YES)
	    		   {
	    			  
	    		  	    	        
	    		  	      if(patientList.get(getPatientPos()).p_invoiceList.get(inv).in_procList.isEmpty())
	 	    			 {  
	 	    				 procedureCounter = 1;
	 	    				 pro.procNo = procedureCounter;
	 	    			 }
	    		  	      
	    		  	      procedureCounter++;
	    		  	    
	    		  	        
	    		  	    		       for(int ii = 0; ii < tmp_invoice1.size(); ii++) 
	    		  	    		        {
			 
	    		  	    		        	if(inv == tmp_invoice1.get(ii).getinvoiceNo()-1)
	    		  	    		        		{
	    		  	    		        		     tmp_invoice1.get(ii).in_procList.add(pro);
	    		  	    		        		    
	    		  	    		        		}  
	    		  	    		        } 
	    		  	    		     invoiceRemPro.valueProperty().addListener(new ChangeListener<String>() {
	    			  		        	    public void changed(ObservableValue<? extends String> observable, String old1, String newv1) {
	    			  		        		
	    			  		        	    	procedureRem.getItems().clear();
	    			  		        	    
	    			  		        	    	int iTmp1 = patientRemPro.getSelectionModel().getSelectedIndex();
	    			  		        		int iTmp2 = invoiceRemPro.getSelectionModel().getSelectedIndex();
	    			  		        	
	    			  		        		ArrayList<Invoice> tmp_invoice1 = patientList.get(iTmp1).getp_invoiceList();
	    			  		        		
	    			  		        		
	    			  		        				for(int iiii = 0; iiii < tmp_invoice1.get(iTmp2).in_procList.size(); iiii++) 
	    			  		        				{
	    			  		        				  String tmp_invoice_number2 = Integer.toString( tmp_invoice1.get(iTmp2).in_procList.get(iiii).procNo);
	    			  		        				  procedureRem.getItems().add(tmp_invoice_number2);    				 
	    			  		        				}
	    			  		        				
	    			  		        	}
	    			  		        });
	    		  	    		        double   getPrices = totalAmtOfInvoice();  
	    		  	    		        double amts = 0;
	    		  	    		        amts = amts + getPrices;
	    		  	    		        if(tmp_invoice1.size() > 0)
	    		  	    		        			 {
	    		  	    		        			   tmp_invoice1.get(inv).invoiceAmt = amts;
	    		  	    		        			 }
	    		  	    		
	    		  	    		      showTotalPayment(payAmt);
	    		  	    		   
	    		  	  Alert confirm2 = new Alert(AlertType.INFORMATION, "Procedure Saved", ButtonType.CLOSE);
	    			  Image image3 = new Image("/images/tick.png");
		    	      ImageView imageView1 = new ImageView(image3);
		    	      confirm2.setGraphic(imageView1);
	    			  confirm2.showAndWait();
	    			 
	    			
	    			  if(confirm2.getResult() == ButtonType.CLOSE){
	    				
	    			  }
	    		   }
	    		   else if (alert3.getResult() == ButtonType.NO)
	    		   {
	    			  alert3.close();
	    		   }
	    	   }
	    	   else if(!list.getSelectionModel().isSelected(po) || !patientPro.getSelectionModel().isSelected(o))
	    	   {
	    		   Alert error1 = new Alert(AlertType.ERROR, "Please Enter Required", ButtonType.CLOSE);
	    		   error1.showAndWait();
	    	   }
			}
        catch(ArrayIndexOutOfBoundsException hi)
        {
        	Alert error2 = new Alert(AlertType.WARNING, "No Invoice Found, Please Add New Invoice", ButtonType.CLOSE);
  		    error2.showAndWait();
        }catch(NullPointerException y)
        {
       	 
        }
      	
      
        });
	
	}
	public void clearField(TextField pName, TextField adds, TextField contactNumText)
	{
		pName.clear();
        adds.clear();
        contactNumText.clear();
	}
	public void addPatientBtn(Button btn10, TextField pName, TextField adds, TextField contactNumText){

        btn10.setOnAction(e -> {

        	
    		p = new Patient(pName.getText(),adds.getText());    		 	
	    	   if(!pName.getText().isEmpty() && !adds.getText().isEmpty() && !contactNumText.getText().isEmpty())
	    	   {
	    		  
	  	    	   p.patientNo = patientCounter;

	    		   Alert alert = new Alert(AlertType.CONFIRMATION, "Are You Sure To Save This Patient " +  " ?", ButtonType.YES, ButtonType.NO);
	    		   Image image1 = new Image("/images/smile.jpg");
	    	       ImageView imageView = new ImageView(image1);
	    	       alert.setGraphic(imageView);
	    		   alert.showAndWait();

	    		   if (alert.getResult() == ButtonType.YES)
	    		   {
	    			  patientCounter++;
	    			  patientList.add(p);
	    			  try{
	    				  patientInv.getItems().add(p.getName());    		
	    				  patientPro.getItems().add(p.getName());
	    				  patientPay.getItems().add(p.getName());
	    				  patientRemInv.getItems().add(p.getName());
	    				  patientRemPro.getItems().add(p.getName());
	    				  patientSortbyName.getItems().add(p.getName());
	    			  }catch(ArrayIndexOutOfBoundsException v){
	    				  
	    			  }
	    			  		
	    	 		  
	    			  Alert confirm = new Alert(AlertType.INFORMATION, "Patient Saved", ButtonType.CLOSE);
	    			  Image image2 = new Image("/images/tick.png");
		    	      ImageView imageView1 = new ImageView(image2);
		    	      confirm.setGraphic(imageView1);
	    			  confirm.showAndWait();
	    			  if(confirm.getResult() == ButtonType.CLOSE){
	    				  clearField(pName,adds,contactNumText);
	    			  }
	    		   }
	    		   else if (alert.getResult() == ButtonType.NO)
	    		   {
	    			  alert.close();
	    		   }
	    	   }
	    	   else if(pName.getText().isEmpty() || adds.getText().isEmpty() || contactNumText.getText().isEmpty())
	    	   {
	    		   Alert error = new Alert(AlertType.ERROR, "Please Enter Required", ButtonType.CLOSE);
	    		   error.showAndWait();
	    	   }
   		
   		 @SuppressWarnings("unused")
		String s = "";    		
	    	    for(int i= 0; i < patientList.size(); i++)
	    	     {    	
	    	    	  s+= patientList.get(i).toString()+"\n";
	    	     }  	    	
	    	
	       });
	}
	public void removeInv(Button removeInvBtn, TextArea disRemInv){
		removeInvBtn.setOnAction(e ->{
    		
    		try{
    			try{
    			int iTmp = patientRemInv.getSelectionModel().getSelectedIndex();
    			int iTmp2 = invoiceRemInv.getSelectionModel().getSelectedIndex();
    			ArrayList<Invoice> tmp_invoice1 = patientList.get(iTmp).getp_invoiceList(); 	
    		
    			 if(patientRemInv.getSelectionModel().isSelected(iTmp))
  	    	     {
    			  
        		
  	    		   Alert alert3 = new Alert(AlertType.CONFIRMATION, "Are You Sure To Remove This Invoice" +  " ?", ButtonType.YES, ButtonType.NO);
  	    		   Image image2 = new Image("/images/emoji1.png");
  	    	       ImageView imageView = new ImageView(image2);
  	    	       alert3.setGraphic(imageView);
  	    		   alert3.showAndWait();

  	    		   if (alert3.getResult() == ButtonType.YES)
  	    		   {
  	    			   for(int ii = 0; ii < tmp_invoice1.size(); ii++) 
  	    		  	    		        {
  	    				   					String t = "";
  	    		  	    		        	if(iTmp2 == tmp_invoice1.get(ii).getinvoiceNo()-1)
  	    		  	    		        		{
  	    		  	    		        	        t+= patientList.get(iTmp).p_invoiceList.get(iTmp2).toString()+"\n";
  	    		  	    		        		     tmp_invoice1.remove(iTmp2);
  	    		  	    		        		     disRemInv.setText("Invoices: \n"+ t+ "\nInvoice Removed");
  	    		  	    		        		}  
  	    		  	    		        } 
  	    		  	    		  
  	    		  	    		    Alert removeInv = new Alert(AlertType.INFORMATION, "Invoice Removed", ButtonType.CLOSE);
  	    	    			 		Image image3 = new Image("/images/tick.png");
  	    	     					ImageView imageView1 = new ImageView(image3);
  	    	     					removeInv.setGraphic(imageView1);
  	    	     					removeInv.showAndWait();
  	    	     					
  	    			 
  	    			  if(removeInv.getResult() == ButtonType.CLOSE){
  	    				
  	    			  }
  	    		   }
  	    		   else if (alert3.getResult() == ButtonType.NO)
  	    		   {
  	    			  alert3.close();
  	    		   }
  	    	    }
    			
    			 else if (!patientRemInv.getSelectionModel().isSelected(iTmp) || !invoiceRemInv.getSelectionModel().isSelected(iTmp2))
     			{
     				Alert removeFail = new Alert(AlertType.WARNING, "Please Select At Least 1 Patient or Invocie", ButtonType.CLOSE);;
     				removeFail.showAndWait();
     			}
    			}catch(ArrayIndexOutOfBoundsException hi)
    			{
    				Alert removeFail = new Alert(AlertType.WARNING, "Please Select At Least 1 Patient or Invocie", ButtonType.CLOSE);;
    				removeFail.showAndWait();
    		 }
    			}catch(NullPointerException n)
     		{
     			
     		}	
        	
	
    	});
	}
	public void removePro(Button removeProBtn, TextArea disRemPro){
		removeProBtn.setOnAction(e ->{
    		
    		try{
    			try{
    			int iTmp = patientRemPro.getSelectionModel().getSelectedIndex();
    			int iTmp2 = invoiceRemPro.getSelectionModel().getSelectedIndex();
    			int iTmp3 = procedureRem.getSelectionModel().getSelectedIndex();
    			ArrayList<Invoice> tmp_invoice1 = patientList.get(iTmp).getp_invoiceList(); 	
    		
    			 if(patientRemPro.getSelectionModel().isSelected(iTmp))
  	    	     {
    			  
        		
  	    		   Alert alert3 = new Alert(AlertType.CONFIRMATION, "Are You Sure To Remove This Procedure" +  " ?", ButtonType.YES, ButtonType.NO);
  	    		   Image image2 = new Image("/images/emoji1.png");
  	    	       ImageView imageView = new ImageView(image2);
  	    	       alert3.setGraphic(imageView);
  	    		   alert3.showAndWait();

  	    		   if (alert3.getResult() == ButtonType.YES)
  	    		   {
  	    			   for(int ii = 0; ii < tmp_invoice1.get(iTmp2).in_procList.size(); ii++) 
  	    		  	    		        {
  	    				   					String t = "";
  	    		  	    		        	if(iTmp2 == tmp_invoice1.get(iTmp2).in_procList.get(ii).procNo-1)
  	    		  	    		        		{
  	    		  	    		        	        t+= patientList.get(iTmp).p_invoiceList.get(iTmp2).in_procList.get(iTmp3).toString()+"\n";
  	    		  	    		        		     tmp_invoice1.get(iTmp2).in_procList.remove(iTmp3);
  	    		  	    		        		     disRemPro.setText("Procedures: \n"+ t+ "\nProcedure Removed");
  	    		  	    		        		}  
  	    		  	    		        } 
  	    		  	    		  
  	    		  	    		    Alert removePro = new Alert(AlertType.INFORMATION, "Procedure Removed", ButtonType.CLOSE);
  	    	    			 		Image image3 = new Image("/images/tick.png");
  	    	     					ImageView imageView1 = new ImageView(image3);
  	    	     					removePro.setGraphic(imageView1);
  	    	     					removePro.showAndWait();
  	    	     					
  	    			 
  	    			  if(removePro.getResult() == ButtonType.CLOSE){
  	    				
  	    			  }
  	    		   }
  	    		   else if (alert3.getResult() == ButtonType.NO)
  	    		   {
  	    			  alert3.close();
  	    		   }
  	    	    }
    			
    			 else if (!patientRemPro.getSelectionModel().isSelected(iTmp) || !invoiceRemPro.getSelectionModel().isSelected(iTmp2))
     			{
     				Alert removeFail = new Alert(AlertType.WARNING, "Please Select At Least 1 Patient or Invocie or Procedure", ButtonType.CLOSE);;
     				removeFail.showAndWait();
     			}
    			}catch(ArrayIndexOutOfBoundsException hi)
    			{
    				Alert removeFail = new Alert(AlertType.WARNING, "Please Select At Least 1 Patient or Invocie or Procedure", ButtonType.CLOSE);;
    				removeFail.showAndWait();
    		 }
    			}catch(NullPointerException n)
     		{
     			
     		}	
        	
	
    	});
	}
	public ComboBox<String> addPatientToInv(){
		patientInv = new ComboBox<String>();
		patientInv.setMinSize(100,30);
		patientInv.setMaxSize(200, 30);
		patientInv.setPromptText("Patient List");
		return patientInv;
	}
	public ComboBox<String> addPatientToPro(){
		
		patientPro = new ComboBox<String>();
		patientPro.setMinSize(100,30);
		patientPro.setMaxSize(200, 30);
		patientPro.setPromptText("Patient List");
				
		return patientPro;
	}
	public ComboBox<String> addPatientToPay()
	{
		patientPay = new ComboBox<String>();
		patientPay.setMinSize(100,30);
		patientPay.setMaxSize(200, 30);
		patientPay.setPromptText("Patient List");
		
		return patientPay;
		
	}
	public ComboBox<String> addPatientToRemInv(){
		patientRemInv = new ComboBox<String>();
		patientRemInv.setMinSize(100,30);
		patientRemInv.setMaxSize(200, 30);
		patientRemInv.setPromptText("Patient List");
		return patientRemInv;
	}
	public ComboBox<String> addInvocieToRemInv(){
		invoiceRemInv = new ComboBox<String>();
		invoiceRemInv.setMinSize(100,30);
		invoiceRemInv.setMaxSize(200, 30);
		invoiceRemInv.setPromptText("invoice List");
		return invoiceRemInv;
	}
	public ComboBox<String> addPatientToRemPro(){
		patientRemPro = new ComboBox<String>();
		patientRemPro.setMinSize(100,30);
		patientRemPro.setMaxSize(200, 30);
		patientRemPro.setPromptText("Patient List");
		return patientRemPro;
	}
	public ComboBox<String> addInvocieToRemPro(){
		invoiceRemPro = new ComboBox<String>();
		invoiceRemPro.setMinSize(100,30);
		invoiceRemPro.setMaxSize(200, 30);
		invoiceRemPro.setPromptText("invoice List");
		return invoiceRemPro;
	}
	public ComboBox<String> addProcedureToRem(){
		procedureRem = new ComboBox<String>();
		procedureRem.setMinSize(100,30);
		procedureRem.setMaxSize(200, 30);
		procedureRem.setPromptText("Procedure List");
		return procedureRem;
	}
	public ComboBox<String> addInvoiceToPay()
	{
		invoicePay = new ComboBox<String>();
		invoicePay.setMinSize(100,30);
		invoicePay.setMaxSize(200, 30);
		invoicePay.setPromptText("Invoice List");
		
		return invoicePay;
		
	}
	public ComboBox<String> addinvoicePro()
	{
		invoicePro = new ComboBox<String>();
		invoicePro.setMinSize(100,30);
		invoicePro.setMaxSize(200, 30);
		invoicePro.setPromptText("Invoice List");
			
		return invoicePro;
		
	}
	public ComboBox<String> sortByName()
	{
		patientSortbyName = new ComboBox<String>();
		patientSortbyName.setMinSize(100,30);
		patientSortbyName.setMaxSize(200, 30);
		patientSortbyName.setPromptText("Patient List");
		return patientSortbyName;
	}
	public void showPatient(Button showP, TextArea disPBox){
		showP.setOnAction(e -> {
        	 String s = "";
	    	    for(int i= 0; i < patientList.size(); i++)
	    	     {
	    	 
	    		   s+= patientList.get(i).toString()+"\n";
	    	   }  	   
	    	if(patientList.size() > 0){
	    		disPBox.setText("Patient List: " + s);   
	    	}
	    	else
	    	{
	    		disPBox.setText("No Patient Saved. Please Add Patient!");
	    	}
	    	
	    	
	    	
        });
	}
	public void windowStyle(Scene scene1){
		window.setMinWidth(580);
        window.setMaxWidth(680);
        window.setMinHeight(350);
        window.setMaxHeight(550);
        window.setScene(scene1);
        window.show();
	}
	public void getStylesheet(Scene reportScene, Scene payscene, Scene invproscene, Scene scene4, Scene scene1,Scene scene3,Scene scene5,Scene scene2,Scene scene6,Scene scene7){
         
		invproscene.getStylesheets().addAll(this.getClass().getResource("application.css").toExternalForm());
		payscene.getStylesheets().addAll(this.getClass().getResource("application.css").toExternalForm());
        scene4.getStylesheets().addAll(this.getClass().getResource("application.css").toExternalForm());
        scene3.getStylesheets().addAll(this.getClass().getResource("application.css").toExternalForm());
        scene1.getStylesheets().addAll(this.getClass().getResource("application.css").toExternalForm());
        scene5.getStylesheets().addAll(this.getClass().getResource("application.css").toExternalForm());
        scene2.getStylesheets().addAll(this.getClass().getResource("application.css").toExternalForm());
        scene6.getStylesheets().addAll(this.getClass().getResource("application.css").toExternalForm());
        scene7.getStylesheets().addAll(this.getClass().getResource("application.css").toExternalForm());
        reportScene.getStylesheets().addAll(this.getClass().getResource("application.css").toExternalForm());
        
   } 
	public void goBack(Scene scene3){
		 window.setScene(scene3);
	}	
    public void removeRadioBtn(ToggleGroup group, Button removePatient, TextField removeF, RadioButton rdo2, RadioButton rdo1, TextArea removeDisBox){
        
        group.selectedToggleProperty().addListener(
            (ObservableValue<? extends Toggle> ov, Toggle old_toggle, Toggle new_toggle) ->
            {
                if (group.getSelectedToggle() == rdo2)  {
               	 removePatient.setOnAction(e -> 
                    	{
                    		String s = "";
                    		Patient p = null;
                   	 	    for ( int i = 0;  i < patientList.size(); i++)
                   	 	     {
                   	 	         p =  patientList.get(i);
                    		  	if(Integer.toString(p.patientNo).equals(removeF.getText()))
                    		  	{
                    		  		s+= patientList.get(i).toString()+"\n";
                    		  		patientList.remove(i);  
                    		  		removeDisBox.setText("Patient List: " + s+"\nPatient Removed");   
                    		  	}                             
                   	 	     }
                   	 	    
                   	 	    if(removeF.getText().isEmpty() || !removeF.getText().equals(Integer.toString(p.patientNo)))
                   	 	    {
                   	 	    	Alert removeError = new Alert(AlertType.ERROR, "No Patient Found or Wrong Name / ID", ButtonType.CLOSE);
                   	 	    	removeError.showAndWait();
                   	 	    }
                   	      
                       });
                }
                
                else if (group.getSelectedToggle() == rdo1) {
               		 
               	 removePatient.setOnAction(e -> 
                       { 
                    	   String t = "";
                    	   Patient pa = null;
                           for ( int o = 0;  o < patientList.size(); o++)
                       	    {
                     		     pa =  patientList.get(o);  
                     		   	if (pa.Name.equals(removeF.getText()))
                     		   	{
                     		   	    t+= patientList.get(o).toString()+"\n";
                     		   		patientList.remove(o);
                     		   		removeDisBox.setText("Patient List: " + t+"\nPatient Removed");
                     		   	}    
                     		 
                            }
                           
                            if(removeF.getText().isEmpty() || !removeF.getText().equals(pa.Name))
             	    	   {
             	    		   Alert removeError = new Alert(AlertType.ERROR, "No Patient Found or Wrong Name / ID", ButtonType.CLOSE);
             	    		   removeError.showAndWait();
             	    	   }
                       });	 
               	 }
       	 });
	}	
	public void searchRadioBtn(ToggleGroup group1, Button searchPatient, TextField searchF, RadioButton searrdo2, RadioButton searrdo1, TextArea searchBox)
	{
		group1.selectedToggleProperty().addListener(
                (ObservableValue<? extends Toggle> ov, Toggle old_toggle, Toggle new_toggle) ->
                {
                    if (group1.getSelectedToggle() == searrdo2)  {
                   	 searchPatient.setOnAction(e -> 
                        	{ 
                        		String s = "";
                       	 	for ( int i = 0;  i < patientList.size(); i++)
                       	 	{
                       	 		
                        		  Patient p =  patientList.get(i);
                        		  	if(Integer.toString(p.patientNo).equals(searchF.getText()))
                        		  	{
                        		  		s+= patientList.get(i).toString()+"\n";      
                        		  	}                             
                               }
                       	 	searchBox.setText("Patient List: " + s);
                           });
                    }
                    
                    else if (group1.getSelectedToggle() == searrdo1) {
                   		 
                   	 searchPatient.setOnAction(e -> 
                           { 
                           	String t = "";
                                for ( int o = 0;  o < patientList.size(); o++)
                           	 {
                               	 
                         		   Patient pa =  patientList.get(o);  
                         		   	if (pa.Name.equals(searchF.getText()))
                         		   	{
                         		   	  t+= patientList.get(o).toString()+"\n";
                         		   	}    
                                }
                                searchBox.setText("Patient List: " + t);
                           });	 
                   	 }
           	 });
	  
	}	
    public void showTotalPayment(TextField payAmt)
    { 
    
    	  invoicePay.valueProperty().addListener(new ChangeListener<String>() {
	        	public void changed(ObservableValue<? extends String> observable, String old2, String newv2) {
	        			
	        		payAmt.clear();
	        		int iTmp4 = patientPay.getSelectionModel().getSelectedIndex();
	        		int iTmp3 = invoicePay.getSelectionModel().getSelectedIndex();
	        	
	        		ArrayList<Invoice> tmp_invoices = patientList.get(iTmp4).getp_invoiceList();
	        		
	        		
	        				for(int ii = 0; ii < tmp_invoices.size(); ii++) 
	        				{
	        				   if(iTmp3 == tmp_invoices.get(ii).getinvoiceNo()-1)
	        				   {
	        					   String pri = Double.toString(tmp_invoices.get(ii).getinvoiceAmt());
	    		  	    	       payAmt.setText("ву"+pri);
	        				   }
	        				}
	        		
	        	}
	        });
    	
    }
	public double totalAmtOfInvoice(){
    	
    	
    	int i;
    	double sum = 0;
    	int iTmp = patientPro.getSelectionModel().getSelectedIndex();
    	int iTmp2 = invoicePro.getSelectionModel().getSelectedIndex();
    	
    	if(patientList.get(iTmp).getp_invoiceList().size() > 0)
    	{
    	
    	
    	  ArrayList<Invoice> tmp_invoice2 = patientList.get(iTmp).getp_invoiceList();
    	 
    	  for(i = 0; i < tmp_invoice2.get(iTmp2).in_procList.size(); i++)
    	  {
    		  sum += tmp_invoice2.get(iTmp2).in_procList.get(i).getprocCost();
    		  
    	  }
    	}
    	return sum;
        
    		
    }
	public void addPayment(Button addPay, TextField payAmt, TextField enterPayAmt)
    {
		
    	addPay.setOnAction(e ->{
    		
    		try{
    			try{
    			int iTmp = patientPay.getSelectionModel().getSelectedIndex();
    			int iTmp2 = invoicePay.getSelectionModel().getSelectedIndex();
    			ArrayList<Invoice> tmp_invoice1 = patientList.get(iTmp).getp_invoiceList(); 
    			double paidAmt = Double.parseDouble(enterPayAmt.getText());
    			pay = new Payment(paymentDate, paidAmt);
    			
    			double afterPay;
    			double enteredPay = Double.parseDouble(enterPayAmt.getText());
    			afterPay =   enteredPay - tmp_invoice1.get(iTmp2).invoiceAmt;
    	
    			 if(patientPay.getSelectionModel().isSelected(iTmp))
  	    	     {
    			  
        		   pay.paymentNo = paymentCounter;
  	    		   Alert alert3 = new Alert(AlertType.CONFIRMATION, "Are You Sure To Pay For This Invoice" +  " ?", ButtonType.YES, ButtonType.NO);
  	    		   Image image2 = new Image("/images/smile.jpg");
  	    	       ImageView imageView = new ImageView(image2);
  	    	       alert3.setGraphic(imageView);
  	    		   alert3.showAndWait();

  	    		   if (alert3.getResult() == ButtonType.YES)
  	    		   {
  	    			  
  	    		  	    	        
  	    		  	      if(patientList.get(iTmp).p_invoiceList.get(iTmp2).in_paymentList.isEmpty())
  	 	    			 {  
  	    		  	    	paymentCounter = 1;
  	 	    				pay.paymentNo = paymentCounter;
  	 	    			 }
  	    		  	      
  	    		  	      paymentCounter++;
  	    		  	        
  	    		  	    		       for(int ii = 0; ii < tmp_invoice1.size(); ii++) 
  	    		  	    		        {
  			 
  	    		  	    		        	if(iTmp2 == tmp_invoice1.get(ii).getinvoiceNo()-1)
  	    		  	    		        		{
  	    		  	    		        		     tmp_invoice1.get(ii).in_paymentList.add(pay);
  	    		  	    		        		}  
  	    		  	    		        } 
  	    		  	    		   double payCost;
  	    		  	    		   double totalPay = 0;
  	    		  	    		   for(int ii = 0; ii < tmp_invoice1.get(iTmp2).in_paymentList.size(); ii++) 
	    		  	    		        {
  	    		  	    		          payCost = tmp_invoice1.get(iTmp2).in_paymentList.get(ii).paymentAmt;	
  	    		  	    		          totalPay = totalPay + payCost;	   
	    		  	    		        
  	    		  	    		       if(afterPay == 0 || afterPay > 0 || tmp_invoice1.get(iTmp2).invoiceAmt == totalPay){
  	    		  	    		    	   i.isPaid = true;
  	    		  	    		       }
  	    		  	    		       else if (afterPay < 0)
  	    		  	    		       {
  	    		  	    		    	   i.isPaid = false;
  	    		  	    		       }
	    		  	    		      }
  	    		  	    		    Alert payment = new Alert(AlertType.INFORMATION, "Payment Successful", ButtonType.CLOSE);
  	    	    			 		Image image3 = new Image("/images/tick.png");
  	    	     					ImageView imageView1 = new ImageView(image3);
  	    	     					payment.setGraphic(imageView1);
  	    	     					payment.showAndWait();
  	    	     					
  	    	     					saveData();
  	    			 
  	    			  if(payment.getResult() == ButtonType.CLOSE){
  	    				
  	    			  }
  	    		   }
  	    		   else if (alert3.getResult() == ButtonType.NO)
  	    		   {
  	    			  alert3.close();
  	    		   }
  	    	    }
    			
    			 else if (enterPayAmt.getText().isEmpty() || enteredPay <= 0)
     			{
     				Alert paymentFail = new Alert(AlertType.ERROR, "Payment Unsuccessful - PLease Enter Amount to Pay", ButtonType.CLOSE);
     				paymentFail.showAndWait();
     			}
    			}catch(ArrayIndexOutOfBoundsException hi)
    			{
    				Alert paymentFail = new Alert(AlertType.ERROR, "Payment Unsuccessful - PLease choose invoice", ButtonType.CLOSE);
     			paymentFail.showAndWait();
    		 }
    			}catch(NumberFormatException n)
     		{
     			
     		}	
        	
    		
    	});
    }
	public void payScene(FlowPane payPane, Button backToMenu, Button addPay, TextField payAmt, TextField enterPayAmt)
    {
    	
    
    	VBox payBox = new VBox();
    	payBox.setSpacing(10);
    	
    	HBox buttonBox = new HBox();
    	buttonBox.setSpacing(10);
    	
        buttonBox.getChildren().addAll(addPay, backToMenu);
    	
    	Label totalAmt = new Label("Total Amount: ");
    	payBox.getChildren().addAll(addPatientToPay(), addInvoiceToPay(), totalAmt, payAmt, enterPayAmt, buttonBox);
    	payPane.getChildren().add(payBox);
    	
    
    	
    	
    	
    }
	public int getPatientPos()
	{
		
		int o =	patientInv.getSelectionModel().getSelectedIndex();
		for (int i = 0; i < patientList.size(); i++) {
		    if (patientList.get(o).getpatientNo() == patientList.get(i).patientNo) 
		    {
		    	return i;
		    
		    }
	    } 
		return -1;
		
	}
	public int getInvoicePos()
	{   
		
		int o =	patientPro.getSelectionModel().getSelectedIndex();
		for (int l = 0; l < patientList.get(o).p_invoiceList.size(); l++) {
		    if (patientList.get(getPatientPos()).p_invoiceList.get(l).getinvoiceNo() == patientList.get(getPatientPos()).p_invoiceList.get(l).invoiceNo) 
		    {
		    	return l; 
		    
		    }
	    } 
		return -1;
	}
	public void saveData(){
		  try {
		       
		         ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("PatientList.txt"));
		        		 {
		        	  		out.writeObject(this.patientList);
		        		 }
		         out.close();
		         Alert saved = new Alert(AlertType.INFORMATION, "DATA SAVED", ButtonType.CLOSE);
		         saved.showAndWait();
		      }catch(Exception ii) {
		         ii.printStackTrace();
		      }
	}
	@SuppressWarnings("unchecked")
	public void readData(){
		
		try {
	        ObjectInputStream in = new ObjectInputStream(new FileInputStream("PatientList.txt"));
	        patientList = ( ArrayList<Patient> ) in.readObject();
			  in.close();
	         
	      }catch(Exception c) {
	         
	       
	      
	      }
	}
	public static void main(String[] args) {
		launch(args);
	}	
}	
		


