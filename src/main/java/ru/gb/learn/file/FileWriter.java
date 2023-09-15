package ru.gb.learn.file;

import com.fasterxml.jackson.core.util.DefaultIndenter;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import ru.gb.learn.toy.Toy;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class FileWriter {

    /**
     * @param fileName the name of file to be written
     * @apiNote writes the list of toys to json file
     */
    public static void write(String fileName, List<Toy> toyList) {
        try {
            DefaultPrettyPrinter.Indenter indenter = new DefaultIndenter("    ", DefaultIndenter.SYS_LF);
            DefaultPrettyPrinter printer = new DefaultPrettyPrinter();
            printer.indentArraysWith(indenter);
            printer.indentObjectsWith(indenter);
            new ObjectMapper().writer(printer).writeValue(new File(fileName), toyList);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
