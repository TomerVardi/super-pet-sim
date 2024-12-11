import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel; // need that to be able to use cursor detection, for click and release






public class GUI {
    private static final int FRAME_WIDTH = 400;
    private static final int FRAME_HEIGHT = 400;
    private static final Insets BUTTON_INSETS = new Insets(5, 0, 5, 0); // Padding around buttons

    /**
     * Entry point for the Super Pet Simulator application.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        JFrame frame = new JFrame("Super Pet Simulator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set up main panel and its components
        JPanel mainPanel = createMainPanel();
        frame.add(mainPanel, BorderLayout.CENTER);

        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setVisible(true);
    }

    /**
     * Creates the main panel and adds its components.
     *
     * @return a JPanel containing the layout with buttons.
     */
    private static JPanel createMainPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(Color.WHITE);

        GridBagConstraints gbc = createGridBagConstraints(0, 0);

        // Add "New Game" button
        JButton newGameButton = createNewGameButton();
        panel.add(newGameButton, gbc);

        // Add "Quit Game" button
        gbc.gridy = 1; // Move below "New Game" button
        JButton quitButton = createQuitButton();
        panel.add(quitButton, gbc);

        return panel;
    }

    /**
     * Creates the "New Game" button with its action listener.
     *
     * @return a JButton for starting a new game.
     */
    private static JButton createNewGameButton() {
        JButton button = new JButton("New Game");
        button.addActionListener(e -> {
            JFrame newGameFrame = new JFrame("Pet Setup");
            newGameFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            newGameFrame.setSize(300, 200);
            newGameFrame.setLayout(new GridBagLayout());

            // Add components for pet setup
            addPetSetupComponents(newGameFrame);

            newGameFrame.setVisible(true);
        });
        return button;
    }

    /**
     * Creates the "Quit Game" button with its action listener.
     *
     * @return a JButton to quit the application.
     */
    private static JButton createQuitButton() {
        JButton button = new JButton("Quit Game");
        button.addActionListener(e -> System.exit(0));
        return button;
    }

    /**
     * Adds components for pet setup to the given frame.
     *
     * @param frame the JFrame to which the components will be added.
     */
    private static void addPetSetupComponents(JFrame frame) {
        JLabel nameLabel = new JLabel("Enter Pet Name:");
        JTextField nameField = new JTextField(15);

        JLabel typeLabel = new JLabel("Select Pet Type:");
        String[] petTypes = {"Dog", "Cat"};
        JComboBox<String> typeDropdown = new JComboBox<>(petTypes);

        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(submitEvent -> {
            String petName = nameField.getText();
            String petType = (String) typeDropdown.getSelectedItem();
            frame.dispose(); // Close the Pet Setup window
            // Handle petName and petType if needed here
        });

        // Adding components using GridBagLayout
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        gbc.gridx = 0;
        gbc.gridy = 0;
        frame.add(nameLabel, gbc);

        gbc.gridx = 1;
        frame.add(nameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        frame.add(typeLabel, gbc);

        gbc.gridx = 1;
        frame.add(typeDropdown, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        frame.add(submitButton, gbc);
    }

    /**
     * Creates default GridBagConstraints for components.
     *
     * @param gridx the grid x position.
     * @param gridy the grid y position.
     * @return a GridBagConstraints object initialized with default values.
     */
    private static GridBagConstraints createGridBagConstraints(int gridx, int gridy) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = gridx;
        gbc.gridy = gridy;
        gbc.insets = BUTTON_INSETS;
        return gbc;
    }
}

