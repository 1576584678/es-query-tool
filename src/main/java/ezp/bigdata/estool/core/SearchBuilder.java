package ezp.bigdata.estool.core;

import com.alibaba.fastjson.JSON;
import ezp.bigdata.estool.entity.Aggs;
import ezp.bigdata.estool.entity.Query;
import ezp.bigdata.estool.entity.QueryAgg;
import io.searchbox.core.Search;

/**
 * @author liyuelin
 * @Desc 调用入口
 * @Date 2019/10/25
 */
public class SearchBuilder {
    public static Search.Builder builder(QueryAgg queryAgg) {
        if (queryAgg.getAggs()!= null){
            Aggs aggs = (Aggs) queryAgg.getAggs();
            queryAgg.setAggs(aggs.getAggs());
        }
        String queryStr = JSON.toJSONString(queryAgg);
        System.out.println(queryStr);
        Search.Builder searchBuilder = new Search.Builder(queryStr);
        return searchBuilder;
    }

    public static Search.Builder builder(Query query) {
        QueryAgg queryAgg = new QueryAgg();
        queryAgg.setQuery(query);
        return builder(queryAgg);
    }
}
