
/* 									Proyecto Final


								Jesus Yapor Velazquez
								Melissa Kelly
								Daniel Velez Negron 					
																																	*/

///////////////////////////////////////////////////// LIBRERIAS IMPORTADAS ///////////////////////////////////////////////////////////

import java.util.Scanner; //importa el Scanner para permitir crear el objeto teclado.

import javax.print.DocFlavor.URL;//importa paquetes que permiten correr el html desde el directorio donde se encuentra el .class
import javax.swing.*; //importa la interface de JOptionPane
import java.awt.*; //importa todo de la libreria awt
import java.applet.*;//importa todo de la libreria applet
import java.lang.*;
import java.io.*;


////////////////////////////////////////////////////// CLASE ProyectoFinal /////////////////////////////////////////////////////////////

public class ProyectoFinal //extends Submit
{ 
   static Scanner teclado = new Scanner(System.in); //crea objeto teclado
   static int paciente = 0; // variable usada para correr un loop si desea elegir si desea hacer entrar informacion
   
/////////////////////////////////////////// METODO PARA CORRER EL FORMULARIO ////////////////////////////////////////////////////////
   
   /* Metodo que permite entrar informacion para archivar */
   public static void entrarInfo()
   {
		   paciente = JOptionPane.showConfirmDialog(null, 
		   			"Deseas llenar el formulario ?",
		   			null, JOptionPane.YES_NO_OPTION);
	
		while (paciente == JOptionPane.YES_OPTION)
		{
		  
		
			if(paciente == JOptionPane.YES_OPTION)
			{
			} 
			else //si elige no sale del loop
			{
				System.exit(0);
			}
			paciente = JOptionPane.showConfirmDialog(null, 
						"Deseas llenar el formulario ?",
						null, JOptionPane.YES_NO_OPTION);
		} //fin while nuevo_paciente
      
   }//fin metodo entrarInfo
   
///////////////////////////////////////////// METODO PARA ABRIR ARCHIVO HTML  //////////////////////////////////////////////////////
   
   /* Metodo que permite buscar informacion archivada en los .txt a traves de html  */
   static void buscarInfo()
   {
	   try 
		 {
		  
		   Runtime rtime = Runtime.getRuntime();
		   
		   /*Comando que permite buscar dentro del directorio de la clase para correr el file html. 
		    De esta manera no hay que especificar un path.
		   */
		   java.net.URL fileURL= ProyectoFinal.class.getResource("Interface.html "); //busca el file html
		   String url= fileURL.toString(); //guarda el link del file html en un string
		   
		   //Permite correr el browser que esta por default en la maquina.
	       rtime.exec( "rundll32 url.dll,FileProtocolHandler " + url);
	       
		 } //fin try
		 	catch (Exception e)
		 {
			 System.out.println("\n\n" + e.getMessage() );
		 } // fin catch  
   }//fin metodo buscarInfo

   
///////////////////////////////////////////////////////// MAIN /////////////////////////////////////////////////////////////////////
   
   public static void main(String[] args)
   {
     
      String usuario = "name",
             pw = "pass",          
             u_usuario,
             u_pw;
             
      int menu = 0;
           
       /*
      usuario - guarda el nombre de usuario para poder acceder al programa
      pw - guarda la contrasena para acceder al programa
      u_usuario - guarda el nombre de usuario entrada por el usuario 
      u_pw - guarda la contrasena entrada por el usuario
      menu - guarda el numero que se utiliza en el switch o case para hacer una seleccion en el menu
      */
      
//////////////////////////////////////////////// NOMBRE DE USUARIO Y CONTRASENA ///////////////////////////////////////////////////////
      
      //Le pide al usuario que entre el nombre de usuario
      u_usuario = JOptionPane.showInputDialog(null,
                  "Entre el nombre de usuario", 
                  "HOLA", JOptionPane.PLAIN_MESSAGE);
                  
      //Le pide al usuario que entre una contrasena
      u_pw = JOptionPane.showInputDialog(null, 
            "Entre su contrasena", 
            "Nombre de Usuario Correcto", JOptionPane.PLAIN_MESSAGE);

      //verifica si el nombre de usuario y contrasena es el correcto para permitir al usuario entrar al menu.
      if (u_usuario.equals(usuario) && u_pw.equals(pw)) 
      {
         
////////////////////////////////////////////////////// MENU ///////////////////////////////////////////////////////////////////////////// 

         while(menu != 10)
         {
            /*Guarda el valor de menu entrado por el usuario e imprime un mensaje para permitir al usuario
            seleccionar mediante el menu*/
            menu = Integer.parseInt(JOptionPane.showInputDialog(null,
                   "BIENVENIDOS AL PROGRAMA\n\n1- Entrar datos para archivar.\n2- Buscar datos del archivo. \n10- Salir del programa.",
                   "MENU DE SELECCION", JOptionPane.PLAIN_MESSAGE));
            
            /*Si el usuario selecciona el 10 para salir se ejecuta el if e imprime un mensaje preguntando si desea salir 
             Si elige que si entonces da un mensaje de despedida. Si elige no entonces vuelve al menu
            Cualquier otro numero que no sea 10 ejecuta el else y corre codigo del menu dependiendo de la
            seleccion del usuario
            */
            if (menu == 10)
            {	   
    				System.exit(0); 
    				            	 
            } //fin menu == 10
            else
            {
                  /*El switch con las diferentes selecciones y sus ejecuciones apropiadas
                   1- Entra informacion para ser archivada.
                   2- Busca de la informacion archivada.
                   3- Crea un nuevo formulario para el paciente.
                   10 - Salir del programa
                   */
                   
                  switch (menu)//menu 
                  {
                     case 1:  entrarInfo();
                              break;
                              
                     case 2:  buscarInfo(); //Busca la informacion guardada en html. Utiliza el metodo buscarInfo()
                              break;
                                          		 		  
            		 /* Cualquier valor entrado por el usuario no disponible en el case mostrara el siguiente error */		  
                     default: JOptionPane.showMessageDialog(null, 
          	               			"La seleccion elegida no esta disponible o no es reconocida.\nPor Favor trate nuevamente", 
      	               				"ERROR SELECCION NO RECONOCIDA", JOptionPane.ERROR_MESSAGE);
  			   
                  }//fin switch menu
            }//fin else
          }// fin while menu != 10
            
      }// fin (u_usuario.equals(usuario) && u_pw.equals(pw) )
      
      //si el nombre de usuario y contrasena entrado es incorrecto corre el else e imprime el siguiente mensaje.
      else       
      {
         JOptionPane.showMessageDialog(null, 
         "Contrasena y/o nombre de usuario entrado es incorrecto.\nFavor tratar nuevamente", 
         "ERROR", JOptionPane.WARNING_MESSAGE);
      } //fin else
   }// fin main
}//fin public class
