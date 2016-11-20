
import java.applet.Applet;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Scanner;

public class Submit extends Applet implements ActionListener {

	 // A textField to get text input 
    TextField nombreField, 
     		   seguroField, 
     		   naciaField,
     		   numeroField,  
     		   direccionField, 
     		   planField, 
     		   fecha1Field, 
     		   diagField, 
     		   recetaField, 
     		   fecha2Field;
    
    Label labelNombre,
    	    labelSeguro,
    	    labelNacia,
    	    labelNumero,
    	    labelDireccion,
    	    labelPlan,
    	    labelFecha1,
    	    labelDiag,
    	    labelReceta,
    	    labelFecha2;

    Button submitButton;
	
	public void init() {
   
		// Tell the applet not to use a layout manager. 
   	 setLayout(null); 
 //Set up the scroll pane.      

       
       //Create objects for the labels
       labelNombre = new Label("Nombre, inicial y apellido:");
       labelSeguro = new Label("Seguro Social:");
       labelNacia = new Label("Fecha de nacimiento:");
       labelNumero = new Label("Numero de expediente:");
       labelDireccion = new Label("DirecciÛn:");
       labelPlan = new Label("Plan MÈdico:");
       labelFecha1 = new Label("Fecha de visita:");
       labelDiag = new Label("DiagnÛstico:");
       labelReceta = new Label("Receta:");
       labelFecha2 = new Label("Fecha de siguiente visita:");
       

     //Set the corners.
       //In theory, to support internationalization you would change
       //UPPER_LEFT_CORNER to UPPER_LEADING_CORNER,
       //LOWER_LEFT_CORNER to LOWER_LEADING_CORNER, and
       //UPPER_RIGHT_CORNER to UPPER_TRAILING_CORNER.  In practice,
       //bug #4467063 makes that impossible (in 1.4, at least).

       //Put it in this panel.
       
 // text and length of the field 
       nombreField = new TextField("",100);         
       
 // text and length of the field 
       seguroField = new TextField("",100); 

 // text and length of the field 
       numeroField = new TextField("",100); 

 // text and length of the field 
       naciaField = new TextField("",100); 

 // text and length of the field 
       direccionField = new TextField("",100); 
       
 // text and length of the field 
       planField = new TextField("",100); 

 // text and length of the field 
       fecha1Field = new TextField("",100); 

 // text and length of the field 
       diagField = new TextField("",100); 
       
 // text and length of the field 
       recetaField = new TextField("",40); 

 // text and length of the field 
       fecha2Field = new TextField("",40); 
                                         
 // initialize the button and give it a text. 
       submitButton = new Button("Submit"); 
       submitButton.addActionListener(this);

       

 // now we will specify the positions of the GUI components. 
 // this is done by specifying the x and y coordinate and 
 //the width and height. 
         
         // Label, Column 1
         labelNombre.setBounds(10,10,150,30);
  	      labelSeguro.setBounds(10,90,150,30);
  	      labelNacia.setBounds(10,170,150,30);
  	      labelNumero.setBounds(10,250,150,30);
  	      labelDireccion.setBounds(10,330,150,30);
  	      labelPlan.setBounds(10,410,150,30);
  	      
  	      // Label, column 2
  	      
  	      labelFecha1.setBounds(350,10,150,30);
  	      labelDiag.setBounds(350,90,150,30);
  	      labelReceta.setBounds(350,170,150,30);
  	      labelFecha2.setBounds(350,250,150,30);
         
         
         // Text Boxes, column 1
         nombreField.setBounds(10,40,300,30);            
         seguroField.setBounds(10,120,300,30); 
         naciaField.setBounds(10,200,300,30);
         numeroField.setBounds(10,280,300,30);  
         direccionField.setBounds(10,360,300,30); 
         planField.setBounds(10,440,300,30);
         
         //Text Boxes, column 2
         fecha1Field.setBounds(350,40,300,30); 
         diagField.setBounds(350,120,300,30); 
         recetaField.setBounds(350,200,300,30); 
         fecha2Field.setBounds(350,280,300,30);
         
         //Below, right corner
         submitButton.setBounds(550,330,100,30); 
         
         

 // now that all is set we can add these components to the applet 
     
     add(labelNombre);       //Label
     add(nombreField); 
     add(labelSeguro);       //Label
     add(seguroField);
     add(labelNacia);        //Label
     add(naciaField);
     add(labelNumero);       //Label
     add(numeroField);
     add(labelDireccion);    //Label
     add(direccionField);
     add(labelPlan);		  //Label
     add(planField);
     add(labelFecha1);		  //Label
     add(fecha1Field);
     add(labelDiag);		  //Label
     add(diagField);
     add(labelReceta);		  //Label
     add(recetaField);
     add(labelFecha2);	      //Label
     add(fecha2Field);
     add(submitButton);
		
	}
	public void actionPerformed(ActionEvent e) {
		
		String nombreFieldString;
		String seguroFieldString;
		String naciaFieldString;
		String numeroFieldString;
		String direccionFieldString;
		String planFieldString;
		String fecha1FieldString;
		String diagFieldString;
		String recetaFieldString;
		String fecha2FieldString;
		
		PrintWriter fileOutput;
		 
		nombreFieldString = nombreField.getText();
		seguroFieldString = seguroField.getText();
		naciaFieldString = naciaField.getText();
		numeroFieldString = numeroField.getText();
		direccionFieldString = direccionField.getText();
		planFieldString = planField.getText();
		fecha1FieldString = fecha1Field.getText();
		diagFieldString = diagField.getText();
		recetaFieldString = recetaField.getText();
		fecha2FieldString = fecha2Field.getText();

	    try {
		    
	    	File dir = new File(numeroFieldString);
		    dir.mkdir();
	    	
	    	fileOutput = new PrintWriter(dir + "/" + fecha1FieldString + "_" + numeroFieldString + ".txt");
		    fileOutput.println("Nombre, inicial y apellido: " + nombreFieldString);
		    fileOutput.println("Seguro Social: " + seguroFieldString);
		    fileOutput.println("Numero de expediente: " + naciaFieldString);
		    fileOutput.println("Fecha de nacimiento: " + numeroFieldString);
		    fileOutput.println("DirecciÛn: " + direccionFieldString);
		    fileOutput.println("Plan MÈdico: " + planFieldString);
		    fileOutput.println("Fecha de visita: " + fecha1FieldString);
		    fileOutput.println("DiagnÛstico: " + diagFieldString);
		    fileOutput.println("Receta: " + recetaFieldString);
		    fileOutput.println("Fecha de siguiente visita: " + fecha2FieldString); 
		    		    
		    fileOutput.close();
		    
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}
}
