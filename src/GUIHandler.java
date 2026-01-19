import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.util.Map;

public class GUIHandler extends JFrame {

    private JLabel balanceLabel;
    private JPanel gridPanel;

    private JPanel sidePanel;
    private JPanel reservationPanel;
    private JPanel ordersPanel;

    private JList<String> ordersList;
    private DefaultListModel<String> ordersListModel;

    private Map<Table, JButton> tableButtonMap;
    private Color defaultTableColor;

    public GUIHandler() {
        tableButtonMap = new java.util.HashMap<>();

        setTitle("Restaurant");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1100, 650);
        setLayout(new BorderLayout(10, 10));

        add(createTopPanel(), BorderLayout.NORTH);
        add(createGridPanel(), BorderLayout.CENTER);
        add(createSidePanel(), BorderLayout.EAST);

        updateBalance();

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private JPanel createTopPanel() {
        JPanel topPanel = new JPanel(new BorderLayout());

        JPanel leftPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));

        JButton payButton = new JButton("$");
        payButton.addActionListener(e -> {
            if (!CashRegister.canPaySalaries()) {
                JOptionPane.showMessageDialog(
                        this,
                        "Insufficient balance!",
                        "Payment Error",
                        JOptionPane.ERROR_MESSAGE
                );
                return;
            }
            CashRegister.givePaychecks();
            updateBalance();
        });

        JButton clearReservationsButton = new JButton("Reservation-Clear");
        clearReservationsButton.addActionListener(e -> {
            Restaurant.removeAllReservations();
            resetAllTables();
        });

        leftPanel.add(payButton);
        leftPanel.add(clearReservationsButton);

        balanceLabel = new JLabel();
        balanceLabel.setFont(new Font("Monospaced", Font.BOLD, 18));
        balanceLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        topPanel.add(leftPanel, BorderLayout.WEST);
        topPanel.add(balanceLabel, BorderLayout.EAST);

        return topPanel;
    }

    private JPanel createGridPanel() {
        int columns = 3;
        int tableCount = Restaurant.getTableList().size();
        int rows = (int) Math.ceil(tableCount / (double) columns);

        gridPanel = new JPanel(new GridLayout(rows, columns, 20, 20));
        gridPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        for (Table table : Restaurant.getTableList()) {
            JButton button = createTableButton(table);
            tableButtonMap.put(table, button);
            gridPanel.add(button);
        }

        return gridPanel;
    }

    private JButton createTableButton(Table table) {
        JButton button = new JButton();
        button.setFont(new Font("SansSerif", Font.BOLD, 14));

        if (defaultTableColor == null)
            defaultTableColor = button.getBackground();

        refreshTableButton(table, button);

        button.addActionListener(e -> showTableSidePanel(table));

        return button;
    }

    private JPanel createSidePanel() {
        sidePanel = new JPanel(new BorderLayout());
        sidePanel.setPreferredSize(new Dimension(300, 0));
        sidePanel.setBorder(BorderFactory.createTitledBorder("Table Details"));

        reservationPanel = new JPanel();
        reservationPanel.setLayout(new BoxLayout(reservationPanel, BoxLayout.Y_AXIS));
        reservationPanel.setBorder(BorderFactory.createTitledBorder("Reservation"));

        ordersPanel = new JPanel(new BorderLayout());
        ordersPanel.setBorder(BorderFactory.createTitledBorder("Current Orders"));

        ordersListModel = new DefaultListModel<>();
        ordersList = new JList<>(ordersListModel);
        ordersPanel.add(new JScrollPane(ordersList), BorderLayout.CENTER);

        JSplitPane splitPane = new JSplitPane(
                JSplitPane.VERTICAL_SPLIT,
                reservationPanel,
                ordersPanel
        );
        splitPane.setResizeWeight(0.4);
        splitPane.setDividerSize(5);

        sidePanel.add(splitPane, BorderLayout.CENTER);

        return sidePanel;
    }

    private void showTableSidePanel(Table table) {
        refreshOrdersList(table);

        reservationPanel.removeAll();

        JLabel title = new JLabel("Table " + table.getID());
        title.setFont(new Font("SansSerif", Font.BOLD, 18));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JTextField dateField = new JTextField("2026-01-20");

        JButton reserveButton = new JButton("Confirm Reservation");
        reserveButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        reserveButton.addActionListener(e -> {
            try {
                LocalDate date = LocalDate.parse(dateField.getText());
                table.setReserved(true);
                table.reserveTable(date);
                refreshTableButton(table, tableButtonMap.get(table));
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Invalid date format!");
            }
        });

        JPanel buttonPanel = new JPanel(new GridLayout(1, 2, 10, 0));

        JButton orderButton = new JButton("Add Order");
        orderButton.addActionListener(e -> showOrderDialog(table));

        JButton receiptButton = new JButton("Generate Receipt");
        receiptButton.addActionListener(e -> {
            StringBuilder receipt = table.generateReceipt();
            refreshOrdersList(table);
            updateBalance();

            if (receipt != null) {
                JTextArea textArea = new JTextArea(receipt.toString());
                textArea.setEditable(false);
                textArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
                JOptionPane.showMessageDialog(this, new JScrollPane(textArea),
                        "Receipt - Table " + table.getID(),
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });

        buttonPanel.add(orderButton);
        buttonPanel.add(receiptButton);

        reservationPanel.add(title);
        reservationPanel.add(Box.createVerticalStrut(10));
        reservationPanel.add(new JLabel("Reservation Date (YYYY-MM-DD):"));
        reservationPanel.add(dateField);
        reservationPanel.add(Box.createVerticalStrut(10));
        reservationPanel.add(reserveButton);
        reservationPanel.add(Box.createVerticalStrut(15));
        reservationPanel.add(buttonPanel);

        reservationPanel.revalidate();
        reservationPanel.repaint();
    }

    private void refreshOrdersList(Table table) {
        ordersListModel.clear();

        if (table.getProductMap().isEmpty()) {
            ordersListModel.addElement("No orders yet");
        } else {
            for (Map.Entry<String, Integer> entry : table.getProductMap()) {
                String name = entry.getKey();
                name = name.substring(0, 1).toUpperCase() + name.substring(1); // Capitalize
                ordersListModel.addElement(name + " x" + entry.getValue());
            }
        }
    }

    private void showOrderDialog(Table table) {
        JDialog dialog = new JDialog(this, "Add Order - Table " + table.getID(), true);
        dialog.setSize(300, 220);
        dialog.setLayout(new GridLayout(4, 1, 10, 10));

        JComboBox<String> menuBox = new JComboBox<>(getMenuNames());
        JSpinner quantitySpinner = new JSpinner(new SpinnerNumberModel(1, 1, 100, 1));

        JButton addButton = new JButton("Add Order");
        addButton.addActionListener(e -> {
            String product = (String) menuBox.getSelectedItem();
            int quantity = (Integer) quantitySpinner.getValue();

            table.addOrder(product, quantity);
            refreshOrdersList(table);
            dialog.dispose();
        });

        dialog.add(new JLabel("Product:"));
        dialog.add(menuBox);
        dialog.add(quantitySpinner);
        dialog.add(addButton);

        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);
    }

    private String[] getMenuNames() {
        return Menu.getMenu()
                .stream()
                .map(Product::getName)
                .toArray(String[]::new);
    }

    private void refreshTableButton(Table table, JButton button) {
        if (table.isReserved()) {
            button.setBackground(Color.ORANGE);
            button.setOpaque(true);
            button.setBorderPainted(false);
            button.setText("<html><center>Table " + table.getID() + "<br>" +
                    table.getReservationDate() + "</center></html>");
        } else {
            button.setBackground(defaultTableColor);
            button.setOpaque(true);
            button.setBorderPainted(true);
            button.setText("<html><center>Table " + table.getID() + "</center></html>");
        }
    }

    private void resetAllTables() {
        for (Map.Entry<Table, JButton> entry : tableButtonMap.entrySet()) {
            Table table = entry.getKey();
            JButton button = entry.getValue();

            table.setReserved(false);
            table.reserveTable(null);
            refreshTableButton(table, button);
        }
    }

    private void updateBalance() {
        balanceLabel.setText("Balance: " +
                String.format("%.2f", CashRegister.getBalance()));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(GUIHandler::new);
    }
}
