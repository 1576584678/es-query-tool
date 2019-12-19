package ezp.bigdata.estool.core;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import ezp.bigdata.estool.client.EsJestClient;
import ezp.bigdata.estool.entity.*;
import io.searchbox.client.JestClient;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

/**
 * @author liyuelin
 * @Desc TODO
 * @Date 2019/11/18
 */
public class JunitTest {
    private static JestClient jestClient;
    private static String INDEX_NAME;
    private String TYPE;
    private static SearchResult searchResult;

    @BeforeAll
    private static void init(){
        jestClient= EsJestClient.getJestClient("http://ip:9200");
        INDEX_NAME="behavior_2019";
    }
    @Test
    public void term() throws IOException {
        JSONArray arrayMust = new JSONArray();
        Term term = new Term("userType","ZZ");
        Bool bool = new Bool();
        arrayMust.add(term);
        bool.setMust(arrayMust);
        Query query = new Query(bool);
        Search.Builder searchBuilder = SearchBuilder.builder(query).addIndex(INDEX_NAME);
        searchResult = jestClient.execute(searchBuilder.build());
    }

    @Test
    public void terms() throws IOException {
        JSONArray arrayMust = new JSONArray();
        String userTypes[] = new String [] {"ZZ","BD"};
        Terms terms = new Terms("userType",userTypes);
        Bool bool = new Bool();
        arrayMust.add(terms);
        bool.setMust(arrayMust);
        Query query = new Query(bool);
        Search.Builder searchBuilder = SearchBuilder.builder(query).addIndex(INDEX_NAME);
        searchResult = jestClient.execute(searchBuilder.build());
    }

    @Test
    public void range() throws IOException {
        JSONArray arrayMustNot = new JSONArray();
        RangeDetail rd = new RangeDetail();
        rd.setGt(675);
        rd.setLt(1024);
        Range range = new Range("firstPageId",rd);
        Bool bool = new Bool();
        arrayMustNot.add(range);
        bool.setMust_not(arrayMustNot);
        Query query = new Query(bool);
        Search.Builder searchBuilder = SearchBuilder.builder(query).addIndex(INDEX_NAME);
        searchResult = jestClient.execute(searchBuilder.build());
    }

    /**
     * 该方法只对做过分词的字段有效,在这里没起作用
     * @throws IOException
     */
    @Test
    public void wildcard() throws IOException {
        JSONArray arrayShoud = new JSONArray();
        Wildcard wd1 = new Wildcard("pageName","*会*");
        Wildcard wd2 = new Wildcard("pageName","*移*");
        arrayShoud.add(wd1);
        arrayShoud.add(wd2);
        Bool bool = new Bool();
        bool.setShould(arrayShoud);
        Query query = new Query(bool);
        Search.Builder searchBuilder = SearchBuilder.builder(query).addIndex(INDEX_NAME);
        searchResult = jestClient.execute(searchBuilder.build());
    }

    @Test
    public void prefix() throws IOException {
        JSONArray arrayShoud = new JSONArray();
        Prefix pf1 = new Prefix("pageName","益氪");
        Prefix pf2 = new Prefix("pageName","驿氪");
        arrayShoud.add(pf1);
        arrayShoud.add(pf2);
        Bool bool = new Bool();
        bool.setShould(arrayShoud);
        Query query = new Query(bool);
        Search.Builder searchBuilder = SearchBuilder.builder(query).addIndex(INDEX_NAME);
        searchResult = jestClient.execute(searchBuilder.build());
    }

    @Test
    public void fuzzy() throws IOException {
        JSONArray arrayMust = new JSONArray();
        FuzzyDetail fuzzyDetail = new FuzzyDetail();
        fuzzyDetail.setValue("益氪测试");
        Fuzzy fuzzy = new Fuzzy("pageName",fuzzyDetail);
        arrayMust.add(fuzzy);
        Bool bool = new Bool();
        bool.setMust(arrayMust);
        Query query = new Query(bool);
        Search.Builder searchBuilder = SearchBuilder.builder(query).addIndex(INDEX_NAME);
        searchResult = jestClient.execute(searchBuilder.build());
    }

    @Test
    public void missing() throws IOException {
        JSONArray arrayMustNot = new JSONArray();
        Exists exists = new Exists("pvCount");
        arrayMustNot.add(exists);
        Bool bool = new Bool();
        bool.setMust_not(arrayMustNot);
        Query query = new Query(bool);
        Search.Builder searchBuilder = SearchBuilder.builder(query).addIndex(INDEX_NAME);
        searchResult = jestClient.execute(searchBuilder.build());
    }

    @AfterAll
    public static void outputData(){
        System.out.println("数据总条数："+searchResult.getTotal());
        List<SearchResult.Hit<JSONObject, Void>> hits = searchResult.getHits(JSONObject.class);
        System.out.println("当前获取条数："+hits.size());
        for(SearchResult.Hit<JSONObject, Void> hit: hits){
            JSONObject source = hit.source;
            String ss = JSON.toJSONString(source);
            System.out.println(ss);
        }
    }

}
