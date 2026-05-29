package hust.soict.hedspi.aims.screen;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.store.Store;

public class AddCompactDiscToStoreScreen extends AddItemToStoreScreen {
    private JTextField tfDirector;
    private JTextField tfArtist;

    public AddCompactDiscToStoreScreen(Store store, Cart cart, StoreScreen storeScreen) {
        super(store, cart, storeScreen, "Add CD to Store");
    }

    @Override
    protected void addAdditionalFields(JPanel center) {
        center.add(new JLabel("Director: "));
        tfDirector = new JTextField();
        center.add(tfDirector);

        center.add(new JLabel("Artist: "));
        tfArtist = new JTextField();
        center.add(tfArtist);
    }

    @Override
    protected Media createMedia() {
        String title = tfTitle.getText().trim();
        String category = tfCategory.getText().trim();
        float cost = getCost();
        String director = tfDirector.getText().trim();
        String artist = tfArtist.getText().trim();

        if (title.isEmpty()) return null;
        return new CompactDisc(title, category, director, cost, artist);
    }
}
