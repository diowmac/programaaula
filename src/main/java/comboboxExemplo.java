import javax.swing.*;

public class comboboxExemplo extends JFrame {

    public comboboxExemplo() {
        // Configurações do JFrame
        setTitle("Exemplo JComboBox");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Criando um JComboBox vazio
        JComboBox<String> comboBox = new JComboBox<>();

        // Adicionando itens ao JComboBox
        comboBox.addItem("Código");
        comboBox.addItem("Item 2");
        comboBox.addItem("Item 3");
        comboBox.addItem("Item 4");

        // Adicionando o JComboBox ao JFrame
        add(comboBox);

        // Torna o JFrame visível
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new comboboxExemplo();
            }
        });
    }
}
