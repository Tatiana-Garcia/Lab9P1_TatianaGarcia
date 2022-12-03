/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab9p1_tatianagarcia;

import java.util.ArrayList;

/**
 *
 * @author tatig
 */
public class Game {
    public int [][] Matriz;
    public int[][] Matriz2;
    public int numero; 
    public ArrayList<String> cel_vivas = new ArrayList();
    
    public Game()
    {
        
    }//Constructor
    
    public int [][] getMatriz()
    {
        return Matriz;
    }//getters 
    
    public void setMatriz(int [][]Matriz)
    {
        this.Matriz = Matriz; 
    }//setters
    
    public int [][] getMatriz2()
    {
        return Matriz2;
    }//getters 
    
    public void setMatriz2(int [][]Matriz2)
    {
        this.Matriz2 = Matriz2; 
    }//setters
    public int getnumero()
    {
        return numero;
    }//getters 
    
    public void setnumero(int numero)
    {
        this.numero = numero; 
    }//setters
    
    public ArrayList<String> getcel_vivas()
    {
        return cel_vivas;
    }//getters 
    
    public void setcel_vivas(ArrayList<String> cel_vivas)
    {
        this.cel_vivas = cel_vivas; 
    }//setters
    
    public void jugar(int x)
    {
        for (int i = 0; i < x; i++)
        {
            System.out.println("Ronda "+(i+1));
            nextGen();
            
            String tablero = imprimir(Matriz);
            System.out.print(tablero);
        }
    }
    
    public void nextGen()
    {
        cel_vivas.clear();
        
        for (int i = 0; i < Matriz.length; i++) {
            for (int j = 0; j < Matriz[0].length; j++) {
                    
                if (i != 0 || i != Matriz.length-1||j != 0||j != Matriz[0].length-1)
                {
                    int con = 0; 
                    int a = i+1;
                    int y = i-1;
                    int b = j+1;
                    int x = j-1;
                    if (a<10&&y>-1&&b<10&&x>-1)
                    {
                        if (Matriz[a][j]==1)
                        {
                            con++;
                        }
                        if (Matriz[y][j]==1)
                        {
                            con++;
                        }
                        if (Matriz[i][x]==1)
                        {
                            con++;
                        }
                        if (Matriz[i][b]==1)
                        {
                            con++;
                        }
                        if (Matriz[y][x]==1)
                        {
                            con++;
                        }
                        if (Matriz[a][x]==1)
                        {
                            con++;
                        }
                        if (Matriz[y][b]==1)
                        {
                            con++;
                        }
                        if (Matriz[a][b]==1)
                        {
                            con++;
                        }
                    }
                    
                    //////
                    if(Matriz[i][j]==0)
                    {
                        if (con ==3)
                        {
                            Matriz2[i][j] = 1;
                        }
                        else 
                        {
                            Matriz2[i][j] = 0;
                        }
                    }
                    else 
                    {
                        switch(con)
                        {
                            case 1: 
                            case 4:
                            case 5: 
                            case 6:
                            case 7: 
                            case 8: 
                                Matriz2[i][j] = 0;
                                break; 
                            case 2: 
                            case 3: 
                                Matriz2[i][j] = 1;
                                cel_vivas.add(i+":"+j);
                                break;
                                
                        }
                    }
                    
                    
                }
            }
        }//FIn del for 
        int [][]temp = Matriz;
        Matriz = Matriz2; 
        Matriz2 = temp;
        System.out.println("Coordenadas de celdas vivas: ");
        System.out.println(cel_vivas);
    }
    
    public void Print(ArrayList<String> x)
    {
        int m[][] = new int [10][10];
        String matriz = "";
        for (int i = 0; i < x.size(); i++) {
            String[] coords = x.get(i).split(":");
            m[Integer.parseInt(coords[0])][Integer.parseInt(coords[1])] =1;
        }
        
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                matriz += "[" + m[i][j] +"]";
            }
        }
        System.out.println(matriz);
        
    }
    
    public String imprimir(int [][]numeros)
    {
        String cadena = "";
        
        for (int i = 0; i < numeros.length; i++)
        {
            for (int j = 0; j < numeros[i].length; j++)
            {
                cadena += "["+numeros [i][j]+"]"+" "; 
            }
            cadena += "\n";
        } 
        
        return cadena; 
    }
}
