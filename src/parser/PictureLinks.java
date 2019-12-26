package parser;

import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.stream.Collectors;

public class PictureLinks {

    public PictureLinks (Elements links, Elements notValidLinks )

    {
        this.links=links;
        this.notValidLinks = notValidLinks;
    }

    Elements links ;
    Elements notValidLinks;

    public List <String> getTextLinks () {
    List <String> textLinks = links.stream().
            filter(p -> !(notValidLinks.contains(p))).
            map(e -> e.attributes().get("src")).
            collect(Collectors.toList());
             return textLinks;
}

    public static void downloadPics(List <String> textLinks, String downloadPath) throws IOException {

        String downloadFolder= downloadPath;
        if (!Files.exists(Paths.get(downloadFolder))) {Paths.get(downloadFolder).toFile().mkdir();}



        for (int i = 0; i < textLinks.size(); i++) {

            URL url = new URL(textLinks.get(i));
            InputStream inputStream = url.openStream();
            Files.copy(inputStream, Paths.get(downloadFolder + File.separator + textLinks.get(i).substring(textLinks.get(i).lastIndexOf("/") + 1)), StandardCopyOption.REPLACE_EXISTING);
        }
    }

    public static void printLinks (List <String> textLinks) {

        textLinks.forEach(System.out::println);
    }

    public static void getLinksNumber (List <String> textLinks) {

        System.out.println(textLinks.size());
    }

}
