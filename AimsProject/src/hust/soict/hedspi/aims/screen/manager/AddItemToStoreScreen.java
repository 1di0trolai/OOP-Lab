package hust.soict.hedspi.aims.screen.manager;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import hust.soict.hedspi.aims.store.Store;

public abstract class AddItemToStoreScreen extends JFrame {
    protected Store store;
    protected JTextField tfTitle;
    protected JTextField tfCategory;
    protected JTextField tfCost;

    public AddItemToStoreScreen(Store store, String title) {
        this.store = store;

        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());

        cp.add(createNorth(), BorderLayout.NORTH);
        cp.add(createCenter(), BorderLayout.CENTER);

        setTitle(title);
        setSize(1024, 768);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    JPanel createNorth() {
        JPanel north = new JPanel();
        north.setLayout(new FlowLayout(FlowLayout.LEFT));
        north.add(createMenuBar());
        return north;
    }

    JMenuBar createMenuBar() {
        JMenu menu = new JMenu("Options");

        JMenu smUpdateStore = new JMenu("Update Store");
        JMenuItem miAddBook = new JMenuItem("Add Book");
        JMenuItem miAddCD = new JMenuItem("Add CD");
        JMenuItem miAddDVD = new JMenuItem("Add DVD");

        smUpdateStore.add(miAddBook);
        smUpdateStore.add(miAddCD);
        smUpdateStore.add(miAddDVD);

        menu.add(smUpdateStore);

        JMenuItem miViewStore = new JMenuItem("View Store");
        menu.add(miViewStore);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);

        miViewStore.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new StoreManagerScreen(store);
                dispose();
            }
        });

        miAddBook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddBookToStoreScreen(store);
                dispose();
            }
        });

        miAddCD.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddCompactDiscToStoreScreen(store);
                dispose();
            }
        });

        miAddDVD.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddDigitalVideoDiscToStoreScreen(store);
                dispose();
            }
        });

        return menuBar;
    }

    JPanel createCenter() {
        JPanel center = new JPanel();
        center.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        center.setLayout(new GridLayout(4, 2, 10, 10));

        center.add(new JLabel("Title: "));
        tfTitle = new JTextField(10);
        center.add(tfTitle);

        center.add(new JLabel("Category: "));
        tfCategory = new JTextField(10);
        center.add(tfCategory);

        center.add(new JLabel("Cost: "));
        tfCost = new JTextField(10);
        center.add(tfCost);

        JButton btnAdd = new JButton("Add");
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addItemToStore();
                JOptionPane.showMessageDialog(null, "Item added successfully!");
                tfTitle.setText("");
                tfCategory.setText("");
                tfCost.setText("");
            }
        });
        center.add(btnAdd);

        return center;
    }

    protected abstract void addItemToStore();
}
