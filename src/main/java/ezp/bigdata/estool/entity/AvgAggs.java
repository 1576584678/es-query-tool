package ezp.bigdata.estool.entity;

import com.alibaba.fastjson.JSONObject;
import lombok.Getter;

/**
 * @author liyuelin
 * @Desc 平均数
 * @Date 2019/10/28
 */
@Getter
public class AvgAggs extends Aggs{
    /**
     *
     * @param alias     别名
     * @param fieldName 求平均字段
     */
    public AvgAggs(String alias,String fieldName){
        aggs=new JSONObject(1);
        JSONObject avg = new JSONObject(1);
        JSONObject field = new JSONObject(1);
        avg.put("field",fieldName);
        field.put("avg",avg);
        aggs.put(alias,field);
    }
}
