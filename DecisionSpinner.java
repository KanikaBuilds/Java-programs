import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class DecisionSpinner extends JFrame implements ActionListener {

    private JTextArea inputArea;
    private JButton spinButton, resetButton;
    private JLabel resultLabel, titleLabel;
    private javax.swing.Timer timer;
    private Random random;
    private java.util.List<String> options;
    private int spinCount = 0;

    public DecisionSpinner() {
        // Frame setup
        setTitle("Decision Spinner App");
        setSize(400, 420);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));
        getContentPane().setBackground(new Color(240, 248, 255));

        // Title label
        titleLabel = new JLabel("Decision Spinner", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 22));
        titleLabel.setForeground(new Color(50, 80, 180));
        add(titleLabel, BorderLayout.NORTH);

        // Input area
        inputArea = new JTextArea("Enter options (one per line)...");
        inputArea.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        inputArea.setLineWrap(true);
        inputArea.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(inputArea);
        add(scrollPane, BorderLayout.CENTER);

        // Result label
        resultLabel = new JLabel("Result will appear here...", SwingConstants.CENTER);
        resultLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));
        resultLabel.setForeground(new Color(0, 128, 0));
        add(resultLabel, BorderLayout.SOUTH);

        // Button panel
        JPanel buttonPanel = new JPanel(new FlowLayout());
        spinButton = new JButton("Spin 🎲");
        resetButton = new JButton("Reset");
        buttonPanel.add(spinButton);
        buttonPanel.add(resetButton);
        add(buttonPanel, BorderLayout.PAGE_END);

        // Action listeners
        spinButton.addActionListener(this);
        resetButton.addActionListener(this);

        random = new Random();
        options = new ArrayList<>();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == spinButton) {
            String text = inputArea.getText().trim();
            if (text.isEmpty() || text.equals("Enter options (one per line)...")) {
                JOptionPane.showMessageDialog(this, "Please enter some options first!");
                return;
            }

            String[] lines = text.split("\\n");
            options = Arrays.asList(lines);

            spinButton.setEnabled(false);
            resultLabel.setText("Spinning...");
            spinCount = 0;

            timer = new javax.swing.Timer(100, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    spinCount++;
                    int index = random.nextInt(options.size());
                    resultLabel.setText("Currently: " + options.get(index));

                    // Slow down gradually
                    if (spinCount > 15) ((javax.swing.Timer) evt.getSource()).setDelay(200);
                    if (spinCount > 25) ((javax.swing.Timer) evt.getSource()).setDelay(300);
                    if (spinCount > 30) {
                        ((javax.swing.Timer) evt.getSource()).stop();
                        resultLabel.setText("✅ Final Choice: " + options.get(index));
                        spinButton.setEnabled(true);
                    }
                }
            });
            timer.start();
        }

        if (e.getSource() == resetButton) {
            inputArea.setText("Enter options (one per line)...");
            resultLabel.setText("Result will appear here...");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new DecisionSpinner().setVisible(true));
    }
}
