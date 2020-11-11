import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
	    Parser parser = new Parser();
        EmptyStackExtractor extractor = new EmptyStackExtractor(parser.parse());
//        extractor.extract();
        System.out.println(extractor.extract());
    }
}



