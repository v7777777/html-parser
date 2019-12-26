import parser.HTML_Parser;
import parser.PictureLinks;

import java.io.IOException;
import java.util.List;

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
