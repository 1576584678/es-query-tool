package ezp.bigdata.estool.entity;

import com.alibaba.fastjson.JSONObject;
import lombok.Getter;

/**
 * @author liyuelin
 * @Desc 求和
 * @Date 2019/10/25
 */
@Getter
public class SumAggs extends Aggs{
    /**
     *
     * @param alias     别名
     * @param fieldName 求和字段
     */
    public SumAggs(String alias,String fieldName){
        aggs=new JSONObject(1);
        JSONObject sum = new JSONObject(1);
        JSONObject field = new JSONObject(1);
        sum.put("field",fieldName);
        field.put("sum",sum);
        aggs.put(alias,field);
    }


}
