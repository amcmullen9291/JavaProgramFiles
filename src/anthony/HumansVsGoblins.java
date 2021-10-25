package anthony;

public class HumansVsGoblins {

    public static void main(String[] args) {

        HVGGameFrame frame = new HVGGameFrame();


        HumansVsGoblins overrideToString = new HumansVsGoblins();
        overrideToString.levelComplete();

        Dialogue welcome = new Dialogue();
        welcome.levelComplete();
    }

    public void levelComplete() {
        System.out.println("Congratulations!");
    }

    static class Dialogue extends HumansVsGoblins {

        @Override
        public void levelComplete() {
            System.out.println("Your are ready for another Challenge.");
        }
    }
}
