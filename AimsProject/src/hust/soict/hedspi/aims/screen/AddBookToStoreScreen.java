package hust.soict.hedspi.aims.screen;

import javax.swing.JPanel;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.store.Store;

public class AddBookToStoreScreen extends AddItemToStoreScreen {

    public AddBookToStoreScreen(Store store, Cart cart, StoreScreen storeScreen) {
        super(store, cart, storeScreen, "Add Book to Store");
    }

    @Override
    protected void addAdditionalFields(JPanel center) {
        // Books might have authors but to keep it simple, we don't add extra fields or we can add one for author
    }

    @Override
    protected Media createMedia() {
        String title = tfTitle.getText().trim();
        String category = tfCategory.getText().trim();
        float cost = getCost();

        if (title.isEmpty()) return null;
        return new Book(title, category, cost);
    }
}
