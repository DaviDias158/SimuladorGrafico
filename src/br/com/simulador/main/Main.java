package br.com.simulador.main;

import br.com.simulador.view.SimuladorGUI;
import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        // Inicializa a interface gráfica de forma segura na Thread do Swing
        SwingUtilities.invokeLater(() -> {
            SimuladorGUI tela = new SimuladorGUI();
            tela.setVisible(true);
        });
    }
}
