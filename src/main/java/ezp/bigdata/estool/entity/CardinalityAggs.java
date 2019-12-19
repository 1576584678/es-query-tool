package ezp.bigdata.estool.entity;

import com.alibaba.fastjson.JSONObject;
import lombok.Getter;

/**
 * @author liyuelin
 * @Desc 去重统计个数
 * 相当于 COUNT(DISTINCT w)
 * @Date 2019/10/28
 */
@Getter
public class CardinalityAggs extends Aggs{
    /**
     *
     * @param alias     别名
     * @param fieldName 统计字段
     */
    public CardinalityAggs(String alias,String fieldName){
        aggs=new JSONObject(1);
        JSONObject cardinality = new JSONObject(1);
        JSONObject field = new JSONObject(1);
        cardinality.put("field",fieldName);
        field.put("cardinality",cardinality);
        aggs.put(alias,field);
    }
}
