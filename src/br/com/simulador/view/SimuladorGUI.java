package br.com.simulador.view;

import br.com.simulador.logic.*;
import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class SimuladorGUI extends JFrame {

    private JTextField txtSequencia;
    private JSpinner spinnerQuadros;
    private JButton btnSimular;
    private JTextArea txtResultados;

    public SimuladorGUI() {
        setTitle("Simulador de Substituição de Páginas");
        setSize(500, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        // --- PARTE SUPERIOR (INPUT) ---
        JPanel painelInput = new JPanel(new GridLayout(2, 2, 5, 5));
        painelInput.setBorder(BorderFactory.createTitledBorder("Configurações"));

        painelInput.add(new JLabel("Sequência (ex: 7,0,1,2):"));
        txtSequencia = new JTextField("7,0,1,2,0,3,0,4,2,3,0,3,2,1,2,0,1,7,0,1");
        painelInput.add(txtSequencia);

        painelInput.add(new JLabel("Quantidade de Quadros:"));
        spinnerQuadros = new JSpinner(new SpinnerNumberModel(3, 1, 50, 1));
        painelInput.add(spinnerQuadros);

        add(painelInput, BorderLayout.NORTH);

        // --- PARTE CENTRAL (BOTÃO) ---
        btnSimular = new JButton("Simular Algoritmos");
        btnSimular.setFont(new Font("Arial", Font.BOLD, 14));
        add(btnSimular, BorderLayout.CENTER);

        // --- PARTE INFERIOR (OUTPUT) ---
        txtResultados = new JTextArea(8, 30);
        txtResultados.setEditable(false);
        txtResultados.setFont(new Font("Monospaced", Font.PLAIN, 13));
        JScrollPane scroll = new JScrollPane(txtResultados);
        scroll.setBorder(BorderFactory.createTitledBorder("Resultado das Faltas de Página"));
        add(scroll, BorderLayout.SOUTH);

        btnSimular.addActionListener(e -> executarSimulacao());

        setLocationRelativeTo(null);
    }

    private void executarSimulacao() {
        try {
            String[] partes = txtSequencia.getText().split(",");
            int[] seq = Arrays.stream(partes).map(String::trim).mapToInt(Integer::parseInt).toArray();
            int q = (int) spinnerQuadros.getValue();

            int fFifo = Fifo.calcular(seq, q);
            int fLru = Lru.calcular(seq, q);
            int fOtimo = Otimo.calcular(seq, q);
            int fRelogio = Relogio.calcular(seq, q);

            StringBuilder sb = new StringBuilder();
            sb.append("===== RESULTADOS =====\n");
            sb.append("- Método FIFO: ").append(fFifo).append(" faltas\n");
            sb.append("- Método LRU: ").append(fLru).append(" faltas\n");
            sb.append("- Método Ótimo: ").append(fOtimo).append(" faltas\n");
            sb.append("- Método Relógio: ").append(fRelogio).append(" faltas\n");

            txtResultados.setText(sb.toString());

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro: Verifique se a sequência está no formato correto.");
        }
    }
}
