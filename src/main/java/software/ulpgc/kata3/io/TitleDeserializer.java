package software.ulpgc.kata3.io;

import software.ulpgc.kata3.model.Title;

public interface TitleDeserializer {
    Title deserialize(String line);
}