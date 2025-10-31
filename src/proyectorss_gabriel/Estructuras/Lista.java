/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectorss_gabriel.Estructuras;

/**
 *
 * @author gabriel
 */
public class Lista {
    Nodo primero;
    Nodo ultimo;
    public Lista() {
        primero = null;
    }
    
    
    public void insertar(Nodo nodo){
        if(primero == null){
            primero = ultimo = nodo;
        }else{
            ultimo.pNext = nodo;
            ultimo = nodo;
        }
    }
    
    
    
    
      
}
