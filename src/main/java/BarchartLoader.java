import java.io.IOException;

public interface BarchartLoader {
    Barchart load(int id) throws IOException;
}