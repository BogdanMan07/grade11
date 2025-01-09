import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.ArrayList;

public class InventorySystem {

    public static void main(String[] args) {
        Inventory inventory = new Inventory(3); // Create inventory with space for 3 products

        JFrame frame = new JFrame("Inventory System");
        frame.setSize(1000, 800);

        // Main layout: 3 rows, 2 columns
        frame.setLayout(new GridLayout(3, 2));

        // Text area panel for displaying product info
        JPanel text = new JPanel(new BorderLayout());
        JTextArea textArea = new JTextArea(20, 30);
        textArea.setFont(new Font("Arial", Font.PLAIN, 30));
        textArea.setForeground(Color.GREEN);
        textArea.setEditable(false); // Set as non-editable
        text.add(textArea);

        // Input fields panel for user to enter product info
        JPanel textPanel = new JPanel();
        JTextField textFieldName = new JTextField("Name", 15);
        JTextField textFieldPrice = new JTextField("Price", 15);
        JTextField textFieldQuantity = new JTextField("Quantity", 15);
        textPanel.add(createLabeledPanel("Name:", textFieldName));
        textPanel.add(createLabeledPanel("Price:", textFieldPrice));
        textPanel.add(createLabeledPanel("Quantity:", textFieldQuantity));

        // Buttons panel with action buttons
        JPanel buttonPanel = new JPanel();
        JButton addProductButton = new JButton("Add Product");
        JButton updateProductButton = new JButton("Update Product");
        JButton displayProductsButton = new JButton("Display Products");

        buttonStyle(addProductButton); // Style buttons
        buttonStyle(updateProductButton);
        buttonStyle(displayProductsButton);

        buttonPanel.add(addProductButton);
        buttonPanel.add(updateProductButton);
        buttonPanel.add(displayProductsButton);

        // Add panels to frame
        frame.add(textPanel);          // Input fields
        frame.add(buttonPanel);        // Buttons
        frame.add(text);               // Text area for product info

        frame.setVisible(true);

        // Action listener for "Add Product" button
        addProductButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = textFieldName.getText();
                double price = Double.parseDouble(textFieldPrice.getText());
                int quantity = Integer.parseInt(textFieldQuantity.getText());

                if (price < 0 || quantity < 0) {
                    textArea.setText("No negative values!"); // Error check
                    return;
                }

                inventory.addProduct(new Product(name, price, quantity), textArea); // Add product
            }
        });

        // Action listener for "Update Product" button
        updateProductButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = textFieldName.getText();
                double price = Double.parseDouble(textFieldPrice.getText());
                int quantity = Integer.parseInt(textFieldQuantity.getText());

                if (price < 0 || quantity < 0) {
                    textArea.setText("No negative values!"); // Error check
                    return;
                }

                inventory.updateProduct(name, price, quantity, textArea); // Update product
            }
        });

        // Action listener for "Display Products" button
        displayProductsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                inventory.displayProducts(textArea); // Display all products
            }
        });
    }

    // Helper method to style buttons
    public static void buttonStyle(JButton button) {
        button.setFont(new Font("Arial", Font.BOLD, 20));
        button.setForeground(Color.WHITE);
        button.setBackground(Color.BLUE);
        button.setFocusPainted(false);
    }

    // Helper method to create labeled panels with text fields
    public static JPanel createLabeledPanel(String labelText, JTextField textField) {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JLabel label = new JLabel(labelText);
        label.setFont(new Font("Arial", Font.PLAIN, 16));
        panel.add(label);
        panel.add(textField);
        return panel;
    }
}

class Product {
    String name;
    double price;
    int quantity;

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // Display product details in text area
    public void displayDetails(JTextArea textArea) {
        textArea.append("Name: " + name + "\n");
        textArea.append("Price: " + price + "\n");
        textArea.append("Quantity: " + quantity + "\n");
    }
}

class Inventory {
    private ArrayList<Product> products;
    private int space;

    public Inventory(int space) {
        this.space = space;
        this.products = new ArrayList<>();
    }

    // Add product to inventory
    void addProduct(Product product, JTextArea textArea) {
        if (products.size() < space) {
            products.add(product);
            textArea.setText("Product added successfully!");
        } else {
            textArea.setText("No space available in inventory!");
        }
    }

    // Update existing product in inventory
    void updateProduct(String name, double price, int quantity, JTextArea textArea) {
        for (Product i : products) {
            if (i.getName().equals(name)) {
                i.setPrice(price);
                i.setQuantity(quantity);
                textArea.setText("Product was updated!");
                return;
            }
        }
        textArea.setText("There isn't a product with such name!"); // Error if product not found
    }

    // Display all products in inventory
    void displayProducts(JTextArea textArea) {
        if (products.isEmpty()) {
            textArea.setText("There are no products!"); // If no products exist
        } else {
            textArea.setText(" ");
            for (Product i : products) {
                i.displayDetails(textArea); // Display each product's details
            }
        }
    }
}
