package parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

public class HTML_Parser {

   public static PictureLinks parse (String url) throws IOException {

    Document doc = Jsoup.connect(url).get();

    Elements links = doc.getElementsByTag("img");

    Elements notValidLinks = doc.select("noscript img");

    PictureLinks pictureLinks = new PictureLinks (links, notValidLinks);

    return pictureLinks;

   }

}
