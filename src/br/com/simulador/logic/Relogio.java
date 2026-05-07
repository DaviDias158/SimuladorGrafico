package br.com.simulador.logic;

import java.util.Arrays;

public class Relogio {
    public static int calcular(int[] seq, int q) {
        int[] memoria = new int[q];
        boolean[] bitR = new boolean[q];
        Arrays.fill(memoria, -1);
        int ponteiro = 0, faltas = 0;

        for (int p : seq) {
            boolean achou = false;
            for (int i = 0; i < q; i++) {
                if (memoria[i] == p) {
                    bitR[i] = true;
                    achou = true;
                    break;
                }
            }
            if (!achou) {
                while (bitR[ponteiro]) {
                    bitR[ponteiro] = false;
                    ponteiro = (ponteiro + 1) % q;
                }
                memoria[ponteiro] = p;
                bitR[ponteiro] = false;
                ponteiro = (ponteiro + 1) % q;
                faltas++;
            }
        }
        return faltas;
    }
}
