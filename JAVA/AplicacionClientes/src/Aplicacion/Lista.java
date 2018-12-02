/* */
package Aplicacion;

/**
 *
 * @author t0p01
 */
public class Lista {

    class Nodo {

        Persona info;
        Nodo ant, sig;
    }

    private Nodo raiz;

    public Lista() {
        raiz = null;
    }

    void insertar(int pos, Persona x) {
        if (pos <= cantidad() + 1) {
            Nodo nuevo = new Nodo();
            nuevo.info = x;
            if (pos == 1) {
                nuevo.sig = raiz;
                if (raiz != null) {
                    raiz.ant = nuevo;
                }
                raiz = nuevo;
            } else if (pos == cantidad() + 1) {
                Nodo reco = raiz;
                while (reco.sig != null) {
                    reco = reco.sig;
                }
                reco.sig = nuevo;
                nuevo.ant = reco;
                nuevo.sig = null;
            } else {
                Nodo reco = raiz;
                for (int f = 1; f <= pos - 2; f++) {
                    reco = reco.sig;
                }
                Nodo siguiente = reco.sig;
                reco.sig = nuevo;
                nuevo.ant = reco;
                nuevo.sig = siguiente;
                siguiente.ant = nuevo;
            }
        }
    }

    public Persona extraer(int pos) {
        if (pos <= cantidad()) {
            Persona informacion;
            if (pos == 1) {
                informacion = raiz.info;
                raiz = raiz.sig;
                if (raiz != null) {
                    raiz.ant = null;
                }
            } else {
                Nodo reco;
                reco = raiz;
                for (int f = 1; f <= pos - 2; f++) {
                    reco = reco.sig;
                }
                Nodo prox = reco.sig;
                reco.sig = prox.sig;
                Nodo siguiente = prox.sig;
                if (siguiente != null) {
                    siguiente.ant = reco;
                }
                informacion = prox.info;
            }
            return informacion;
        } else {
            return null;
        }
    }

    public void borrar(int pos) {
        if (pos <= cantidad()) {
            if (pos == 1) {
                raiz = raiz.sig;
                if (raiz != null) {
                    raiz.ant = null;
                }
            } else {
                Nodo reco;
                reco = raiz;
                for (int f = 1; f <= pos - 2; f++) {
                    reco = reco.sig;
                }
                Nodo prox = reco.sig;
                prox = prox.sig;
                reco.sig = prox;
                if (prox != null) {
                    prox.ant = reco;
                }
            }
        }
    }

    public void intercambiar(int pos1, int pos2) {
        if (pos1 <= cantidad() && pos2 <= cantidad()) {
            Nodo reco1 = raiz;
            for (int f = 1; f < pos1; f++) {
                reco1 = reco1.sig;
            }
            Nodo reco2 = raiz;
            for (int f = 1; f < pos2; f++) {
                reco2 = reco2.sig;
            }
            Persona aux = reco1.info;
            reco1.info = reco2.info;
            reco2.info = aux;
        }
    }

    public int cantidad() {
        int cant = 0;
        Nodo reco = raiz;
        while (reco != null) {
            reco = reco.sig;
            cant++;
        }
        return cant;
    }


    public boolean existe(Persona x) {
        Nodo reco = raiz;
        while (reco != null) {
            if (reco.info == x) {
                return true;
            }
            reco = reco.sig;
        }
        return false;
    }

    public boolean vacia() {
        if (raiz == null) {
            return true;
        } else {
            return false;
        }
    }

    public void imprimir() {
        Nodo reco = raiz;
        while (reco != null) {
            System.out.print(reco.info + "-");
            reco = reco.sig;
        }
        System.out.println();
    }

   
}
