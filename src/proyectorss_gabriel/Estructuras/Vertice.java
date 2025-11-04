/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectorss_gabriel.Estructuras;

/**
 *
 * @author gabriel
 */
public class Vertice {
    Usuario dato;
    Vertice sig;
    Lista seguidos;

    public Vertice(Usuario dato) {
        this.dato = dato;
        this.sig = null;
        seguidos = new Lista();
    }
    
    
}
