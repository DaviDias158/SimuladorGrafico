package br.com.simulador.logic;

import java.util.ArrayList;
import java.util.List;

public class Otimo {
    public static int calcular(int[] seq, int q) {
        List<Integer> memoria = new ArrayList<>();
        int faltas = 0;

        for (int i = 0; i < seq.length; i++) {
            int p = seq[i];
            if (!memoria.contains(p)) {
                if (memoria.size() == q) {
                    int indexParaRemover = -1, maisLonge = -1;
                    for (int j = 0; j < memoria.size(); j++) {
                        int proximoUso = Integer.MAX_VALUE;
                        for (int k = i + 1; k < seq.length; k++) {
                            if (memoria.get(j) == seq[k]) {
                                proximoUso = k;
                                break;
                            }
                        }
                        if (proximoUso > maisLonge) {
                            maisLonge = proximoUso;
                            indexParaRemover = j;
                        }
                    }
                    memoria.remove(indexParaRemover);
                }
                memoria.add(p);
                faltas++;
            }
        }
        return faltas;
    }
}
