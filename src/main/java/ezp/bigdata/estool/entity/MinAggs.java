package ezp.bigdata.estool.entity;

import com.alibaba.fastjson.JSONObject;
import lombok.Getter;

/**
 * @author liyuelin
 * @Desc 求最小值
 * @Date 2019/10/28
 */
@Getter
public class MinAggs extends Aggs {
    /**
     *
     * @param alias     别名
     * @param fieldName 求最小值字段
     */
    public MinAggs(String alias,String fieldName){
        aggs=new JSONObject(1);
        JSONObject min = new JSONObject(1);
        JSONObject field = new JSONObject(1);
        min.put("field",fieldName);
        field.put("min",min);
        aggs.put(alias,field);
    }
}
