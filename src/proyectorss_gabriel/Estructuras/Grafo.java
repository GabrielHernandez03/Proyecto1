/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectorss_gabriel.Estructuras;

import javax.swing.JOptionPane;

/**
 *
 * @author gabriel
 */
public class Grafo {

    Vertice primer_usuario;
    Vertice ultimo_usuario;
    int num_usuarios;

    public Grafo() {
        this.primer_usuario = null;
        this.num_usuarios = 0;
    }

    public void nuevoUsuario(String usuario) {
        Vertice existe = this.buscarUsuario(usuario);
        if (existe == null) {
            Usuario nuevo_usuario = new Usuario(usuario);
            if (primer_usuario == null) {
                this.primer_usuario = this.ultimo_usuario = new Vertice(nuevo_usuario);
            } else {
                this.ultimo_usuario.sig = new Vertice(nuevo_usuario);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Ya existe un usuario con ese nombre");
        }
    }

    public Vertice buscarUsuario(String usuario) {
        if (this.primer_usuario != null) {
            Vertice pAux = this.primer_usuario;
            while (pAux != null && !pAux.dato.username.equals(usuario)) {
                pAux = pAux.sig;
            }
            return pAux;
        } else {
            return null;
        }
    }

    public void seguirUsuario(String nuevo_seguidor, String usuario_seguido) {
        if (primer_usuario == null) {
            JOptionPane.showMessageDialog(null, "Aun no hay usaurios registrados :(");

        } else {
            Vertice seguidor = this.buscarUsuario(nuevo_seguidor);
            Vertice seguido = this.buscarUsuario(usuario_seguido);

            if (seguidor != null && seguido != null) {
                seguidor.seguidos.insertar(new Nodo(seguido.dato));
                //profe aqui no pongo una alerta para que, al leer el txt, no spamee alertas al crear las relaciones
            } else{
                if(seguidor == null && seguido == null){
                   JOptionPane.showMessageDialog(null, "Ni el seguidor ni el usuario a seguir han sido encontrados.");  
                }
                else if (seguidor == null) {
                JOptionPane.showMessageDialog(null, "El seguidor no ha sido encontrado.");
                }else{
                     JOptionPane.showMessageDialog(null, "El usuario a seguir no ha sido encontrado.");
                }
               
            }
        }
    }

    public void eliminarUsuario(String usuario) {
        if (this.primer_usuario != null) {
            Vertice pAux = this.primer_usuario;
            if (pAux.dato.username.equals(usuario)) {
                this.primer_usuario = this.primer_usuario.sig;
            } else {
                while (pAux != this.ultimo_usuario && !pAux.sig.dato.username.equals(usuario)) {
                    pAux = pAux.sig;
                }

                if (pAux != this.ultimo_usuario) {
                    pAux.sig = pAux.sig.sig;

                    pAux = this.primer_usuario;
                    while (pAux != null) {
                        pAux.seguidos.eliminar(usuario);
                        pAux = pAux.sig;
                    }

                    JOptionPane.showMessageDialog(null, "Usuario eliminado con exito");
                } else {
                    JOptionPane.showMessageDialog(null, "Usuairo no Encontrado");

                }
            }

        } else {
            JOptionPane.showMessageDialog(null, "No hay usuarios que eliminar");

        }
    }

    public String verRelacionesEntreUsuarios() {
        if (primer_usuario != null) {
            Vertice pAux = this.primer_usuario;
            String gafo = "-------------- USUARIOS REGISTADOS -----------------\n";
            while (pAux != null) {
                gafo += "- " + pAux.dato.username + " -> " + pAux.seguidos.seguidos() + "\n";
                pAux = pAux.sig;
            }
            return gafo;

        } else {
            return "Aun no hay usaurios registrados :(";
        }
    }

}
