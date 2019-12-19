package ezp.bigdata.estool.entity;

import com.alibaba.fastjson.JSONObject;
import lombok.Getter;

/**
 * @author liyuelin
 * @Desc 按日期范围统计
 * @Date 2019/10/28
 */
@Getter
public class DateRangeAggs extends Aggs{
    /**
     *
     * @param alias     别名
     * @param fieldName 字段名
     * @param format    格式
     * @param dateRangesDetail  日期范围
     */
    public DateRangeAggs(String alias,String fieldName,String format,DateRangesDetail dateRangesDetail){
        aggs=new JSONObject(1);
        JSONObject range = new JSONObject(1);
        JSONObject field = new JSONObject(1);
        range.put("field",fieldName);
        range.put("format", format);
        range.put("ranges", dateRangesDetail.getRanges());
        field.put("date_range",range);
        aggs.put(alias,field);
    }
}
