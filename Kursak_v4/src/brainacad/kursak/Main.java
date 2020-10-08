package brainacad.kursak;

public class Main {

    public static void main(String[] args) {

        try {
            new Menu().startMenu();
        }catch (Exception e){
            e.printStackTrace();
        }


    }
}
