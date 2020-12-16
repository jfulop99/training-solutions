package iostringwriter;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.List;

public class LongWordService {


    public String writeWithStringWriter(Writer sw, List<String> words) {
        try(sw) {
            for (String s:words) {
                sw.write(s);
                sw.write(Integer.toString(s.length()));
                sw.write("\n");
            }
        } catch (IOException e) {
            throw new IllegalStateException("Cannot write", e);
        }
        return sw.toString();
    }

    public String writeWithStringWriter(List<String> words) {
        StringWriter sw = new StringWriter();
        return writeWithStringWriter(sw, words);
    }
}
