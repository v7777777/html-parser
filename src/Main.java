import parser.DownloadResult;
import parser.HtmlParser;
import parser.PictureLinks;

import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {


        try {

            String page = "https://lenta.ru/";
            String downloadFolder = "C:\\Users\\v.lesina\\Downloads\\pics";
            List<String> picsLinks = HtmlParser.parse(page).getTextLinks();
            DownloadResult downloadResult =  PictureLinks.downloadPics(picsLinks, downloadFolder);
            downloadResult.printDownloadedLinks();
            downloadResult.countDownloadErrors();
            downloadResult.countDownloadedLinks();



        } catch (IOException e) {
            e.printStackTrace();
        }





}}
