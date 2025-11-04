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

    public void insertar(Nodo nodo) {
        if (primero == null) {
            primero = ultimo = nodo;
        } else {
            ultimo.pNext = nodo;
            ultimo = nodo;
        }
    }

    public void eliminar(String usuario) {
        if (primero != null) {
            Nodo pAux = this.primero;
            if (pAux.dato.equals(usuario)) {
                this.primero = this.primero.pNext;
            } else {
                while (pAux != this.ultimo && !pAux.pNext.dato.equals(usuario)) {
                    pAux = pAux.pNext;
                }

                if (pAux != this.ultimo) {
                    pAux.pNext = pAux.pNext.pNext;
                }
            }
        }
    }

    public Nodo buscar(String usuario) {
        if (this.primero != null) {
            Nodo pAux = this.primero;
            while (pAux != null && !pAux.dato.equals(usuario)) {
                pAux = pAux.pNext;
            }
            return pAux;
        } else {
            return null;
        }
    }
    
    public String seguidos(){
        if(this.primero != null){
            String seguidos = "Sigue a: ";
            Nodo pAux = this.primero;
            while(pAux != this.ultimo){
                seguidos += pAux.dato + ", ";
                pAux = pAux.pNext;
            }
            
            seguidos += pAux.dato + ".";
            return seguidos;
        }else{
            return "No sigue a nadie";
        }
    }

}
