package ezp.bigdata.estool.entity;

import com.alibaba.fastjson.JSONObject;
import lombok.Getter;

/**
 * @author liyuelin
 * @Desc 缺失值统计
 * @Date 2019/10/28
 */
@Getter
public class MissingAggs extends Aggs{
    /**
     *
     * @param alias     别名
     * @param fieldName 缺失值字段
     */
    public MissingAggs(String alias,String fieldName){
        aggs=new JSONObject(1);
        JSONObject missing = new JSONObject(1);
        JSONObject field = new JSONObject(1);
        missing.put("field",fieldName);
        field.put("missing",missing);
        aggs.put(alias,field);
    }
}
