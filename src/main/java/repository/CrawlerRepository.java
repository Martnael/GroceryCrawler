package repository;


import crawler.ShopCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class CrawlerRepository {

    @Autowired
    private NamedParameterJdbcTemplate template;

    public void addPrismaCategory(ShopCategory shopCategory) {
        String sql = "INSERT INTO prisma_category (shop_category_id, shop_category_name, shop_category_url, category_id, status) " + "VALUES (:shop_category_id, :shop_category_name, :shop_category_url, :category_id, :status)";
        Map<String, Object> paraMap = new HashMap<>();
        paraMap.put("shop_category_id", shopCategory.getShopCategoryId());
        paraMap.put("shop_category_name", shopCategory.getShopCategoryName());
        paraMap.put("shop_category_url", shopCategory.getCategoryURL());
        paraMap.put("category_id", shopCategory.getCategoryId());
        paraMap.put("status", shopCategory.getStatus());
        template.update(sql, paraMap);
    }

    public Integer getCategoryCount (String value, String tableName) {
        return 6;
    }
}
