package ezp.bigdata.estool.entity;

import com.alibaba.fastjson.JSONObject;
import lombok.Getter;

/**
 * @author liyuelin
 * @Desc 统计多个聚合值（包括count,min,max,avg,sum）
 * @Date 2019/10/28
 */
@Getter
public class StatsAggs extends  Aggs{
    /**
     *
     * @param alias     别名
     * @param fieldName 聚合字段
     */
    public StatsAggs(String alias,String fieldName){
        aggs=new JSONObject(1);
        JSONObject stats = new JSONObject(1);
        JSONObject field = new JSONObject(1);
        stats.put("field",fieldName);
        field.put("stats",stats);
        aggs.put(alias,field);
    }
}
