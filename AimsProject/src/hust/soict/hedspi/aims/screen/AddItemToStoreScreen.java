package hust.soict.hedspi.aims.screen;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.store.Store;

public abstract class AddItemToStoreScreen extends JFrame {
    protected Store store;
    protected Cart cart;
    protected StoreScreen storeScreen;

    protected JTextField tfTitle;
    protected JTextField tfCategory;
    protected JTextField tfCost;

    public AddItemToStoreScreen(Store store, Cart cart, StoreScreen storeScreen, String title) {
        this.store = store;
        this.cart = cart;
        this.storeScreen = storeScreen;

        this.setLayout(new BorderLayout());

        // We could reuse the north menu from StoreScreen, but for simplicity, just a basic form
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(0, 2, 5, 5));

        center.add(new JLabel("Title: "));
        tfTitle = new JTextField();
        center.add(tfTitle);

        center.add(new JLabel("Category: "));
        tfCategory = new JTextField();
        center.add(tfCategory);

        center.add(new JLabel("Cost: "));
        tfCost = new JTextField();
        center.add(tfCost);

        addAdditionalFields(center);

        this.add(center, BorderLayout.CENTER);

        JPanel bottom = new JPanel(new FlowLayout());
        JButton btnAdd = new JButton("Add");
        btnAdd.addActionListener(e -> {
            Media media = createMedia();
            if (media != null) {
                store.addMedia(media);
                if (storeScreen != null) {
                    storeScreen.refreshStore();
                }
                this.dispose(); // close the window after adding
            }
        });
        bottom.add(btnAdd);

        JButton btnCancel = new JButton("Cancel");
        btnCancel.addActionListener(e -> this.dispose());
        bottom.add(btnCancel);

        this.add(bottom, BorderLayout.SOUTH);

        this.setTitle(title);
        this.setSize(400, 300);
        this.setVisible(true);
    }

    protected abstract void addAdditionalFields(JPanel center);

    protected abstract Media createMedia();

    protected float getCost() {
        try {
            return Float.parseFloat(tfCost.getText().trim());
        } catch (NumberFormatException e) {
            return 0.0f;
        }
    }
}
