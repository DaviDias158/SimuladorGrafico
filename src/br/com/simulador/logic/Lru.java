package br.com.simulador.logic;

import java.util.ArrayList;
import java.util.List;

public class Lru {
    public static int calcular(int[] seq, int q) {
        List<Integer> memoria = new ArrayList<>();
        int faltas = 0;

        for (int p : seq) {
            if (!memoria.contains(p)) {
                if (memoria.size() == q) memoria.remove(0);
                memoria.add(p);
                faltas++;
            } else {
                memoria.remove((Integer) p);
                memoria.add(p);
            }
        }
        return faltas;
    }
}
