package hust.soict.hedspi.aims.screen;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.store.Store;

public class AddDigitalVideoDiscToStoreScreen extends AddItemToStoreScreen {
    private JTextField tfDirector;
    private JTextField tfLength;

    public AddDigitalVideoDiscToStoreScreen(Store store, Cart cart, StoreScreen storeScreen) {
        super(store, cart, storeScreen, "Add DVD to Store");
    }

    @Override
    protected void addAdditionalFields(JPanel center) {
        center.add(new JLabel("Director: "));
        tfDirector = new JTextField();
        center.add(tfDirector);

        center.add(new JLabel("Length: "));
        tfLength = new JTextField();
        center.add(tfLength);
    }

    @Override
    protected Media createMedia() {
        String title = tfTitle.getText().trim();
        String category = tfCategory.getText().trim();
        float cost = getCost();
        String director = tfDirector.getText().trim();
        int length = 0;
        try {
            length = Integer.parseInt(tfLength.getText().trim());
        } catch (NumberFormatException e) {
            length = 0;
        }

        if (title.isEmpty()) return null;
        return new DigitalVideoDisc(title, category, director, length, cost);
    }
}
