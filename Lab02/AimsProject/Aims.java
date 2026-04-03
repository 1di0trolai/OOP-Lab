package AimsProject;

public class Aims {
    public static void main(String[] args) {
        Cart anOrder = new Cart();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("Harry Potter and the Philosopher's Stone", "Fantasy", 18.36f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Harry Potter and the Chamber of Secrets", "Fantasy", 18.36f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Harry Potter and the Prisoner of Azkaban", "Fantasy", "J.K.Rowling", 18.36f);
        DigitalVideoDisc dvd4 = new DigitalVideoDisc("Harry Potter and the Goblet of Fire", "Fantasy", "J.K.Rowling", 18.36f, 444);

        anOrder.addDigitalVideoDisc(dvd1);
        anOrder.addDigitalVideoDisc(dvd2);
        anOrder.addDigitalVideoDisc(dvd3);
        anOrder.addDigitalVideoDisc(dvd4);

        System.out.println("Cart contains:");
        System.out.println(dvd1.getId() + " " + dvd1.getTitle() + " " + dvd1.getCost());
        System.out.println(dvd2.getId() + " " + dvd2.getTitle() + " " + dvd2.getCost());
        System.out.println(dvd3.getId() + " " + dvd3.getTitle() + " " + dvd3.getCost());
        System.out.println(dvd4.getId() + " " + dvd4.getTitle() + " " + dvd4.getCost());

        System.out.println("Total cost: " + anOrder.totalCost());

        anOrder.deleteDigitalVideoDisc(dvd4);
        
        System.out.println("Total cost: " + anOrder.totalCost());
    }
}
