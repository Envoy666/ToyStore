import ru.gb.learn.box.ToyBox;
import ru.gb.learn.box.ToyBoxFrame;
import ru.gb.learn.provider.DataProvider;
import ru.gb.learn.provider.DataProviderFrame;
import ru.gb.learn.toy.Toy;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DataProvider provider = new DataProviderFrame(scanner).getProvider();
        ToyBox toyBox = new ToyBoxFrame(scanner).getToyBox();
        List<Toy> toyList = provider.getToyList();
        toyBox.putAll(toyList);
        while (toyBox.isReady()) {
            System.out.println("toyBox.get() = " + toyBox.get());
        }
    }
}
