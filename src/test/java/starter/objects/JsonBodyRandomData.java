package starter.objects;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.andreinc.mockneat.MockNeat;
import static net.andreinc.mockneat.unit.text.Strings.strings;
import static net.andreinc.mockneat.unit.types.Ints.ints;

public class JsonBodyRandomData {

    public static class TITLE_PUT {
        String title;
    }

    public static String randomString = strings()
            .size(ints().range(1, 100))
            .get();

    public static String TITLE_PUT_BODY() {

        MockNeat mockNeat = MockNeat.threadLocal();
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        return mockNeat
                .reflect(TITLE_PUT.class)
                .field("title", randomString)
                .map(gson::toJson)
                .val();
    }

}
