
package lab9p1_tatianagarcia;

import java.util.ArrayList;
import java.util.Random;
import javax.swing.JOptionPane;
import java.util.Scanner;


public class Lab9P1_TatianaGarcia {
    static Scanner leer = new Scanner(System.in);
    static Random aleatorio = new Random();
    static Game T = new Game();
    
    public static int menu()
    {
        System.out.println();
        System.out.println("--> Menu <--");
        System.out.println("1 -> Game of Life");
        System.out.println("2 -> Salida");
        System.out.println();
        System.out.println(">> Ingrese una opcion: "); 
        int opcion = leer.nextInt();

        return opcion;
    }

    public static void main(String[] args) {
        int opcion = menu();
        
        do 
        {
            switch (opcion)
            {
                case 1: 
                {
                    System.out.println(">> GAME OF LIFE <<");
                    System.out.println("");
                    System.out.println("Ingrese la cantidad de rondas: ");
                    int num = leer.nextInt();
                    
                    int [][]Tablero = new int [10][10];
                    int [][]Tablero2 = new int [10][10];
                    ArrayList<String> cel_vivas = new ArrayList();
                    
                    int [][]Matriz = llenar(Tablero, Tablero2, cel_vivas);
                    
                    T.setMatriz(Matriz);
                    T.setMatriz2(Tablero2);
                   
                    String tablero = T.imprimir(Matriz);
                    
                    System.out.println("Tablero 1: \n"+tablero);
                    
                    T.jugar(num);
                    
                    break; 
                }
                default:{
                    System.out.println("");
                    System.out.println("Fin del algoritmo");
                    break;
                }
                
            }
            opcion = menu();
        }while(opcion <2);
    }
    public static int[][]llenar(int [][]matriz, int [][]matriz2,ArrayList<String> cel_vivas)
    {
        int temp [][] = new int [10][10];
        //int temp2 [][]= new int [10][10];
        
        String str = "";
        
        for (int i = 0; i < matriz.length; i++)
        {
            for (int j = 0; j < matriz[0].length; j++)
            {
                if (i == 0 || i == matriz.length-1||j == 0||j == matriz[0].length-1)
                {
                    temp[i][j] = 0;
                } 
                else 
                {
                    temp[i][j]= aleatorio.nextInt(2);
                    
                    if (temp[i][j] == 1)
                    {
                        cel_vivas.add(i+":"+j);
                    }
                }
                
            }
        }
        System.out.println("Coordenadas de celdas vivas: ");
        System.out.println(cel_vivas);
        T.setcel_vivas(cel_vivas);
        return temp; 
    }
}
