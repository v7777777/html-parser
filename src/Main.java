import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import parser.DownloadResult;
import parser.HTML_Parser;
import parser.PictureLinks;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {


        try {

            String page = "https://lenta.ru/";
            String downloadFolder = "C:\\Users\\v.lesina\\Downloads\\pics";
            List<String> picsLinks = HTML_Parser.parse(page).getTextLinks();
            DownloadResult downloadResult =  PictureLinks.downloadPics(picsLinks, downloadFolder);
            downloadResult.printDownloadedLinks();
            downloadResult.countDownloadErrors();
            downloadResult.countDownloadedLinks();



        } catch (IOException e) {
            e.printStackTrace();
        }





}}
