package ezp.bigdata.estool.core;

import com.alibaba.fastjson.JSON;
import ezp.bigdata.estool.client.EsJestClient;
import ezp.bigdata.estool.entity.*;
import io.searchbox.client.JestClient;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;
import io.searchbox.core.search.aggregation.Range;
import io.searchbox.core.search.aggregation.TermsAggregation;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

/**
 * @author liyuelin
 * @Desc TODO
 * @Date 2019/11/19
 */
public class AggJunitTest {
    private static JestClient jestClient;
    private static String INDEX_NAME;
    private String TYPE;
    private static SearchResult searchResult;
    private QueryAgg queryAgg = new QueryAgg();

    @BeforeAll
    private static void init(){
        jestClient= EsJestClient.getJestClient("http://ip:9200");
        INDEX_NAME="behavior_2019";
    }

    @Test
    public void termsAggg() throws IOException {
        TermsAggs termsAggs = new TermsAggs("userTypeTerms","userType");
        queryAgg.setAggs(termsAggs);
        Search.Builder searchBuilder = SearchBuilder.builder(queryAgg).addIndex(INDEX_NAME);
        searchResult = jestClient.execute(searchBuilder.build());
        List<TermsAggregation.Entry> tes = searchResult.getAggregations().getTermsAggregation("userTypeTerms").getBuckets();
        System.out.println(JSON.toJSONString(tes));
        for (TermsAggregation.Entry te:tes){
            System.out.println(te.getKey()+"\t"+te.getCount());
        }
    }

    /**
     * select userType,count(1) as userTypeCount from table group by userType;
     * @throws IOException
     */
    @Test
    public void countAgg() throws IOException {
        Aggs aggs = new TermsAggs("userTypeTerms","userType").nestAggs(new CountAggs("userTypeCount","userType"));
        queryAgg.setAggs(aggs);
        Search.Builder searchBuilder = SearchBuilder.builder(queryAgg).addIndex(INDEX_NAME);
        searchResult = jestClient.execute(searchBuilder.build());
        List<TermsAggregation.Entry> tes = searchResult.getAggregations().getTermsAggregation("userTypeTerms").getBuckets();
        System.out.println(JSON.toJSONString(tes));
        for (TermsAggregation.Entry te:tes){
            System.out.println(te.getKey()+"\t"+te.getCount()+"\t"+te.getValueCountAggregation("userTypeCount").getValueCount());
        }
    }

    /**
     * select userType,min(pvCount) as pvCountMin from table group by userType;
     * @throws IOException
     */
    @Test
    public void minAgg() throws IOException {
        Aggs aggs = new TermsAggs("userTypeTerms","userType").nestAggs(new MinAggs("pvCountMin","pvCount"));
        queryAgg.setAggs(aggs);
        Search.Builder searchBuilder = SearchBuilder.builder(queryAgg).addIndex(INDEX_NAME);
        searchResult = jestClient.execute(searchBuilder.build());
        List<TermsAggregation.Entry> tes = searchResult.getAggregations().getTermsAggregation("userTypeTerms").getBuckets();
        System.out.println(JSON.toJSONString(tes));
        for (TermsAggregation.Entry te:tes){
            System.out.println(te.getKey()+"\t"+te.getCount()+"\t"+te.getMinAggregation("pvCountMin").getMin());
        }

    }

    /**
     *  select userType,max(secondPageId) as secondPageIdMax from table group by userType;
     * @throws IOException
     */
    @Test
    public void maxAgg() throws IOException {
        Aggs aggs = new TermsAggs("userTypeTerms","userType").nestAggs(new MaxAggs("secondPageIdMax","secondPageId"));
        queryAgg.setAggs(aggs);
        Search.Builder searchBuilder = SearchBuilder.builder(queryAgg).addIndex(INDEX_NAME);
        searchResult = jestClient.execute(searchBuilder.build());
        List<TermsAggregation.Entry> tes = searchResult.getAggregations().getTermsAggregation("userTypeTerms").getBuckets();
        System.out.println(JSON.toJSONString(tes));
        for (TermsAggregation.Entry te:tes){
            System.out.println(te.getKey()+"\t"+te.getCount()+"\t"+te.getMaxAggregation("secondPageIdMax").getMax());
        }

    }

    /**
     * select userType,avg(pvCount) as pvCountAvg from table group by userType;
     * @throws IOException
     */
    @Test
    public void avgAgg() throws IOException {
        Aggs aggs = new TermsAggs("userTypeTerms","userType").nestAggs(new AvgAggs("pvCountAvg","pvCount"));
        queryAgg.setAggs(aggs);
        Search.Builder searchBuilder = SearchBuilder.builder(queryAgg).addIndex(INDEX_NAME);
        searchResult = jestClient.execute(searchBuilder.build());
        List<TermsAggregation.Entry> tes = searchResult.getAggregations().getTermsAggregation("userTypeTerms").getBuckets();
        System.out.println(JSON.toJSONString(tes));
        for (TermsAggregation.Entry te:tes){
            System.out.println(te.getKey()+"\t"+te.getAvgAggregation("pvCountAvg").getAvg());
        }
    }

    @Test
    public void RangeAgg() throws IOException {
        RangesDetail rangesDetail = new RangesDetail();
        rangesDetail.withTo(700);
        rangesDetail.withToFrom(700,1000);
        rangesDetail.withFrom(1000);
        Aggs aggs = new RangeAggs("pvCountRange","pvCount",rangesDetail);
        queryAgg.setAggs(aggs);
        Search.Builder searchBuilder = SearchBuilder.builder(queryAgg).addIndex(INDEX_NAME);
        searchResult = jestClient.execute(searchBuilder.build());
        List<Range> tes = searchResult.getAggregations().getRangeAggregation("pvCountRange").getBuckets();
        System.out.println(JSON.toJSONString(searchResult.getAggregations().getRangeAggregation("pvCountRange")));
        for (io.searchbox.core.search.aggregation.Range te:tes){
            System.out.println(te.getFrom()+"-->"+te.getTo()+":\t"+te.getCount());
        }
    }

    @Test
    public void sunAgg() throws IOException {
        Aggs aggs = new TermsAggs("userTypeTerms","userType").nestAggs(new SumAggs("pvCountSum","pvCount"));
        queryAgg.setAggs(aggs);
        Search.Builder searchBuilder = SearchBuilder.builder(queryAgg).addIndex(INDEX_NAME);
        searchResult = jestClient.execute(searchBuilder.build());
        List<TermsAggregation.Entry> tes = searchResult.getAggregations().getTermsAggregation("userTypeTerms").getBuckets();
        System.out.println(JSON.toJSONString(tes));
        for (TermsAggregation.Entry te:tes){
            System.out.println(te.getKey()+"\t"+te.getSumAggregation("pvCountSum").getSum());
        }
    }


    @Test
    public void statsAgg() throws IOException {
        Aggs aggs = new TermsAggs("userTypeTerms","userType").nestAggs(new StatsAggs("pvCountStats","pvCount"));
        queryAgg.setAggs(aggs);
        Search.Builder searchBuilder = SearchBuilder.builder(queryAgg).addIndex(INDEX_NAME);
        searchResult = jestClient.execute(searchBuilder.build());
        List<TermsAggregation.Entry> tes = searchResult.getAggregations().getTermsAggregation("userTypeTerms").getBuckets();
        System.out.println(JSON.toJSONString(tes));
        for (TermsAggregation.Entry te:tes){
            System.out.println(te.getKey()+"\t"+te.getStatsAggregation("pvCountStats").getSum()+"\t"+te.getStatsAggregation("pvCountStats").getCount()+"\t"+te.getStatsAggregation("pvCountStats").getMin()+"\t"+te.getStatsAggregation("pvCountStats").getMax()+"\t"+te.getStatsAggregation("pvCountStats").getAvg());
        }
    }

}
