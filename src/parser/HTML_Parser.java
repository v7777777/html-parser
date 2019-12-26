package parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

public class HTML_Parser {

   public static Elements parse (String url) throws IOException {

    Document doc = Jsoup.connect(url).get();

    Elements links = doc.getElementsByTag("img");

    return links;

   }

}
