import ru.gb.learn.toy.RealToyBox;
import ru.gb.learn.toy.Toy;
import ru.gb.learn.toy.ToyBox;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Toy teddy = new Toy(0, "Teddy Bear", 1);
        Toy robot = new Toy(1, "Terminator", 1);
        Toy doll = new Toy(2, "Barbie", 1);
        Toy jet = new Toy(3, "Jet", 1);
        Toy ctor = new Toy(4, "Constructor", 1);
        Toy sball = new Toy(5, "Soccer ball", 1);

        List<Toy> toyList = Arrays.asList(teddy, robot, doll, jet, ctor, sball);

        ToyBox toyBox = new RealToyBox();

        for (Toy toy : toyList) {
            toyBox.put(toy);
        }

        while (toyBox.isReady()) {
            System.out.println("toyBox.get() = " + toyBox.get());
        }
    }
}
