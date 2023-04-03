import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Caja {

    public static void main(String[] args) throws IOException{  
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el pin: ");
        String link = scanner.nextLine();
        String linea = null;
        if (link.equals("2345"))
            System.out.print("Correcto");
            while (true){
                System.out.print("\nQue funciones quieres: Sacar dinero, Meter dinero,Balance o Cerrar: ");
                String opcion = scanner.nextLine();
                if(opcion.equalsIgnoreCase("Sacar dinero")){
                    System.out.print("Quanto dinero quieres sacar?");
                    String dinero_sacado = scanner.nextLine();
                    
                    try{
                        FileReader lector = new FileReader("Dinero en el banco.txt");
                        BufferedReader lectorBuffer = new BufferedReader(lector);
                        linea = lectorBuffer.readLine();
                        lectorBuffer.close();
                        int line = Integer.parseInt(linea);
                        int diner = Integer.parseInt(dinero_sacado);
                        int result = line - diner;
                        
                    
                        
                        FileWriter writer2 = new FileWriter("Dinero en el banco.txt");
                        if(result>0){
                         writer2.write(Integer.toString(result));
                         writer2.close();
                         System.out.print("Dinero retirado " + dinero_sacado);
                        }
                         
                        else{
                            System.out.print("Dinero insuficiente");
                        }
                    }
                    catch(FileNotFoundException e){
                        FileWriter wr1= new FileWriter("Dinero en el banco.txt");
                        wr1.write("0");
                        wr1.close();
                        System.out.print("Creandote una cuenta bancaria");
                    }
                    catch(Exception e){
                        e.printStackTrace();
                    }
                    
                }else if(opcion.equalsIgnoreCase("Meter dinero")){

                    System.out.print("Quanto dinero quieres meter?");
                    String dinero_metido = scanner.nextLine();
                    
                    try{
                        FileReader lector = new FileReader("Dinero en el banco.txt");
                        BufferedReader lectorBuffer = new BufferedReader(lector);
                        linea = lectorBuffer.readLine();
                        lectorBuffer.close();
                        int line = Integer.parseInt(linea);
                        int diner = Integer.parseInt(dinero_metido);
                        int result = line + diner;
                        
                    
                        
                        FileWriter writer2 = new FileWriter("Dinero en el banco.txt");
                        writer2.write(Integer.toString(result));
                        writer2.close();
                        System.out.print("Dinero metido " + dinero_metido);
                    }
                    catch(FileNotFoundException e){
                        FileWriter wr1= new FileWriter("Dinero en el banco.txt");
                        wr1.write("0");
                        wr1.close();
                        System.out.print("Creandote una cuenta bancaria");
                    }
                    catch(Exception e){
                        e.printStackTrace();
                    }
                }else if(opcion.equalsIgnoreCase("Cerrar")){
                    scanner.close();
                    break;
                }else if(opcion.equalsIgnoreCase("Balance")){
                    try{
                        FileReader lector = new FileReader("Dinero en el banco.txt");
                        BufferedReader lectorBuffer = new BufferedReader(lector);
                        linea = lectorBuffer.readLine();
                        System.out.print("Dinero en total es "+linea);
                        lector.close();
                    }
                    catch(FileNotFoundException e){
                        FileWriter wr1= new FileWriter("Dinero en el banco.txt");
                        wr1.write("0");
                        wr1.close();
                        System.out.print("Creandote una cuenta bancaria");
                    }
                    catch(Exception e){
                        e.printStackTrace();}

                 } else{
                    System.out.print("Opcion invalida, elige otra");
                }
            
            
            }
       }
    }
 