package AimsProject;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private DigitalVideoDisc itemsOrdered[] =
        new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    private int qtyOrdered = 0;

    //Add DVD
    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if (qtyOrdered < MAX_NUMBERS_ORDERED) {
            itemsOrdered[qtyOrdered++] = disc;
        } else {
            System.out.println("Cart is full");
        }
    }
    //Overloading by differing types of parameter
    public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList) {
        for (DigitalVideoDisc disc : dvdList) {
            addDigitalVideoDisc(disc);
        }
    }
    //Overloading by differing the number of parameters
    public void addDigitalVideoDisc(DigitalVideoDisc dvd1,DigitalVideoDisc dvd2) {
        addDigitalVideoDisc(dvd1);
        addDigitalVideoDisc(dvd2);
    }

    //Delete DVD
    public void deleteDigitalVideoDisc(DigitalVideoDisc disc) {
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i] == disc) {
                for (int j = i; j < qtyOrdered - 1; j++) {
                    itemsOrdered[j] = itemsOrdered[j+1];
                }
                itemsOrdered[qtyOrdered - 1] = null;
                qtyOrdered--;
                System.out.println("The DVD has been deleted");
                return;
            }
        }
        System.out.println("DVD not found");
    }

    //Total Cost
    public float totalCost() {
        float sum = 0;
        for (int i = 0; i < qtyOrdered; i++){
            sum += itemsOrdered[i].getCost();
        }
        return sum;
    }
}
