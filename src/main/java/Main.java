import ru.gb.learn.provider.DataProvider;
import ru.gb.learn.provider.DataProviderFrame;
import ru.gb.learn.toy.RealToyBox;
import ru.gb.learn.toy.Toy;
import ru.gb.learn.toy.ToyBox;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DataProvider provider = new DataProviderFrame(scanner).getProvider();

        List<Toy> toyList = provider.getToyList();

        ToyBox toyBox = new RealToyBox();

        toyBox.putAll(toyList);

        while (toyBox.isReady()) {
            System.out.println("toyBox.get() = " + toyBox.get());
        }
    }
}
