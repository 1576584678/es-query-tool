package ezp.bigdata.estool.entity;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.Data;

/**
 * @author liyuelin
 * @Desc TODO
 * @Date 2019/10/28
 */
@Data
public class DateRangesDetail {
    private JSONArray ranges;

    public DateRangesDetail(){
        ranges = new JSONArray(2);
    }

    private DateRangesDetail withTo(String to){
        JSONObject toJson = new JSONObject(1);
        toJson.put("to",to);
        ranges.add(toJson);
        return this;
    }

    private DateRangesDetail withFrom(String from){
        JSONObject fromJson = new JSONObject(1);
        fromJson.put("from",from);
        ranges.add(fromJson);
        return this;
    }

}
