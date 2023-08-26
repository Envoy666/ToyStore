import ru.gb.learn.toy.*;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        DataProvider provider = new ToyListReader();

        List<Toy> toyList = provider.getToyList();

        ToyBox toyBox = new RealToyBox();

        toyBox.putAll(toyList);

        while (toyBox.isReady()) {
            System.out.println("toyBox.get() = " + toyBox.get());
        }
    }
}
