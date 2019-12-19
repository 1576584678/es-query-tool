package ezp.bigdata.estool.entity;

import com.alibaba.fastjson.JSONObject;
import lombok.Getter;

/**
 * @author liyuelin
 * @Desc 统计条数
 * @Date 2019/10/28
 */
@Getter
public class CountAggs extends Aggs{
    /**
     *
     * @param alias     别名
     * @param fieldName 统计字段
     */
    public CountAggs(String alias,String fieldName){
        aggs=new JSONObject(1);
        JSONObject count = new JSONObject(1);
        JSONObject field = new JSONObject(1);
        count.put("field",fieldName);
        field.put("value_count",count);
        aggs.put(alias,field);
    }
}
