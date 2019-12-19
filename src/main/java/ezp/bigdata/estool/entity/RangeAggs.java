package ezp.bigdata.estool.entity;

import com.alibaba.fastjson.JSONObject;
import lombok.Getter;

/**
 * @author liyuelin
 * @Desc 范围聚合
 * @Date 2019/10/28
 */
@Getter
public class RangeAggs extends Aggs{
    /**
     *
     * @param alias     别名
     * @param fieldName 聚合字段
     */
    public RangeAggs(String alias,String fieldName,RangesDetail rangesDetail){
        aggs=new JSONObject(1);
        JSONObject range = new JSONObject(1);
        JSONObject field = new JSONObject(1);
        range.put("field",fieldName);
        range.put("ranges", rangesDetail.getRanges());
        field.put("range",range);
        aggs.put(alias,field);
    }
}
