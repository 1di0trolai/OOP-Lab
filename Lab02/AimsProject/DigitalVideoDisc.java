package AimsProject;

public class DigitalVideoDisc {
    private String title;
    private String category;
    private String director;
    private int length;
    private float cost;

    private static int nbDigitalVideoDiscs = 0;
    private int id;

    public String getTitle() {
        return title;
    }
    public String getCategory() {
        return category;
    }
    public String getDirector(){
        return director;
    }
    public int getLength() {
        return length;
    }
    public float getCost() {
        return cost;
    }

    //DVD1
    public DigitalVideoDisc(String title) {
        super();
        this.title = title;

        nbDigitalVideoDiscs++;
        this.id = nbDigitalVideoDiscs;
    }
    //DVD2
    public DigitalVideoDisc(String title, String category, float cost){
        super();
        this.title = title;
        this.category = category;
        this.cost = cost;

        nbDigitalVideoDiscs++;
        this.id = nbDigitalVideoDiscs;
    }
    //DVD3
    public DigitalVideoDisc(String title, String category, String director, float cost){
        super();
        this.director = director;
        this.title = title;
        this.category = category;
        this.cost = cost;

        nbDigitalVideoDiscs++;
        this.id = nbDigitalVideoDiscs;
    }
    //DVD4
        public DigitalVideoDisc(String title, String category, String director, float cost, int length){
        super();
        this.director = director;
        this.title = title;
        this.category = category;
        this.cost = cost;
        this.length = length;

        nbDigitalVideoDiscs++;
        this.id = nbDigitalVideoDiscs;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public static int getNbDigitalVideoDiscs(){
        return nbDigitalVideoDiscs;
    }
    public int getId() {
        return id;
    }
}
