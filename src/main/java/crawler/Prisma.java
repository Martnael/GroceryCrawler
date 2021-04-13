package crawler;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class Prisma {

    public void prismaCrawler() throws IOException {
        int prismaId = 1;
        String url ="https://www.prismamarket.ee/products/17696";
        String userAgent = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/88.0.4324.104 Safari/537.36";
        Document pagePrisma = Jsoup.connect(url).userAgent(userAgent).get();

        System.out.println(pagePrisma.outerHtml());
    }

}
