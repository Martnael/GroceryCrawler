package crawler;

import javassist.expr.NewArray;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CrawlerTestingUnit {

    @Autowired
    private Prisma prismaCrawler;

    public static void main(String[] args) throws IOException {
        List<ShopCategory> prismaCategories = new ArrayList<>();
        String url ="https://www.prismamarket.ee/products/selection";
        String userAgent = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/88.0.4324.104 Safari/537.36";
        Pattern p = Pattern.compile("\\d+");
        Document pagePrisma = Jsoup.connect(url).userAgent(userAgent).get();
        Elements categories = pagePrisma.select("div.transparent");
        for (Element elementA : categories.select("a")) {
            ShopCategory shopCategory = new ShopCategory();
            shopCategory.setShopId(1);
            shopCategory.setShopCategoryName(elementA.text());
            shopCategory.setCategoryURL("https://www.prismamarket.ee" + elementA.attr("href"));
            Matcher m = p.matcher(elementA.attr("href"));
            if(m.find()) {
                shopCategory.setShopCategoryId(m.group());
            }
            prismaCategories.add(shopCategory);
        }
        // return prismaCategories;
    }

}
