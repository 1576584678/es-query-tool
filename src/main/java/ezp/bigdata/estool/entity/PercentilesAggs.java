package ezp.bigdata.estool.entity;

import com.alibaba.fastjson.JSONObject;
import lombok.Getter;

/**
 * @author liyuelin
 * @Desc 百分位统计
 * @Date 2019/10/28
 */
@Getter
public class PercentilesAggs extends Aggs{
    /**
     *
     * @param alias     别名
     * @param fieldName 统计字段
     */
    public PercentilesAggs(String alias,String fieldName){
        aggs=new JSONObject(1);
        JSONObject percentiles = new JSONObject(1);
        JSONObject field = new JSONObject(1);
        percentiles.put("field",fieldName);
        field.put("percentiles",percentiles);
        aggs.put(alias,field);
    }
}
