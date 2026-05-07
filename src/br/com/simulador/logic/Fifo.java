package br.com.simulador.logic;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Fifo {
    public static int calcular(int[] seq, int q) {
        Set<Integer> paginas = new HashSet<>();
        Queue<Integer> fila = new LinkedList<>();
        int faltas = 0;

        for (int p : seq) {
            if (!paginas.contains(p)) {
                if (paginas.size() == q) {
                    int antiga = fila.poll();
                    paginas.remove(antiga);
                }
                paginas.add(p);
                fila.add(p);
                faltas++;
            }
        }
        return faltas;
    }
}
