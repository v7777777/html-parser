import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {


        try {

            String page = "https://lenta.ru/";
            String downloadFolder = "C:\\Users\\v.lesina\\Downloads\\pics";
            List<String> picsLinks = PictureLinks.getTextLinks(HTML_Parser.parse(page));
            PictureLinks.downloadPics(picsLinks, downloadFolder);
            PictureLinks.printLinks(picsLinks);
            PictureLinks.getLinksNumber(picsLinks);



        } catch (IOException e) {
            e.printStackTrace();
        }

    }}
