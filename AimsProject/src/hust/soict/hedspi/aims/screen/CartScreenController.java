package hust.soict.hedspi.aims.screen;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;
import hust.soict.hedspi.aims.exception.PlayerException;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;

public class CartScreenController {

    private Cart cart;
    private FilteredList<Media> filteredData;

    @FXML
    private TableView<Media> tblMedia;

    @FXML
    private TableColumn<Media, String> colMediaTitle;

    @FXML
    private TableColumn<Media, String> colMediacategory;

    @FXML
    private TableColumn<Media, Float> colMediaCost;

    @FXML
    private Button btnPlay;

    @FXML
    private Button btnRemove;

    @FXML
    private TextField tfFilter;

    @FXML
    private RadioButton radioBtnFilterId;

    @FXML
    private ToggleGroup filterCategory;

    @FXML
    private RadioButton radioBtnFilterTitle;

    @FXML
    private Label costLabel;

    public CartScreenController(Cart cart) {
        super();
        this.cart = cart;
    }

    @FXML
    private void initialize() {
        colMediaTitle.setCellValueFactory(new PropertyValueFactory<Media, String>("title"));
        colMediacategory.setCellValueFactory(new PropertyValueFactory<Media, String>("category"));
        colMediaCost.setCellValueFactory(new PropertyValueFactory<Media, Float>("cost"));

        // Use FilteredList to wrap the ObservableList
        filteredData = new FilteredList<>(this.cart.getItemsOrdered(), p -> true);
        tblMedia.setItems(filteredData);

        btnPlay.setVisible(false);
        btnRemove.setVisible(false);
        
        updateTotalCost();

        tblMedia.getSelectionModel().selectedItemProperty().addListener(
            new ChangeListener<Media>() {
                @Override
                public void changed(ObservableValue<? extends Media> observable, Media oldValue, Media newValue) {
                    if (newValue != null) {
                        updateButtonBar(newValue);
                    }
                }
            }
        );

        tfFilter.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                showFilteredMedia(newValue);
            }
        });
    }

    private void updateButtonBar(Media media) {
        btnRemove.setVisible(true);
        if (media instanceof Playable) {
            btnPlay.setVisible(true);
        } else {
            btnPlay.setVisible(false);
        }
    }

    private void showFilteredMedia(String filterStr) {
        filteredData.setPredicate(media -> {
            if (filterStr == null || filterStr.isEmpty()) {
                return true;
            }

            if (radioBtnFilterId.isSelected()) {
                try {
                    int id = Integer.parseInt(filterStr);
                    return media.getId() == id;
                } catch (NumberFormatException e) {
                    return false;
                }
            } else if (radioBtnFilterTitle.isSelected()) {
                String lowerCaseFilter = filterStr.toLowerCase();
                return media.getTitle().toLowerCase().contains(lowerCaseFilter);
            }
            return false;
        });
    }

    private void updateTotalCost() {
        costLabel.setText(String.format("%.2f $", cart.totalCost()));
    }

    @FXML
    void btnRemovePressed(ActionEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        if (media != null) {
            cart.removeMedia(media);
            updateTotalCost();
        }
    }

    @FXML
    void btnPlayPressed(ActionEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        if (media != null && media instanceof Playable) {
            try {
                ((Playable) media).play();
            } catch (PlayerException e) {
                // Should show a dialog here, but for now print stack trace
                e.printStackTrace();
            }
        }
    }

    @FXML
    void btnPlaceOrderPressed(ActionEvent event) {
        cart.emptyCart();
        updateTotalCost();
    }
}
