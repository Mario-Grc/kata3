package software.ulpgc.kata3.io;

import software.ulpgc.kata3.model.Barchart;

import java.io.IOException;

public interface BarchartLoader {
    Barchart load(int id) throws IOException;
}