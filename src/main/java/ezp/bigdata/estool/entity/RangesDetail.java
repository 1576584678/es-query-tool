package ezp.bigdata.estool.entity;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.Data;

/**
 * @author liyuelin
 * @Desc 范围聚合的明细
 * @Date 2019/10/28
 */
@Data
public class RangesDetail {
    private JSONArray ranges;

    public RangesDetail(){
        ranges = new JSONArray(3);
    }

    public RangesDetail withTo(int to){
        JSONObject toJson = new JSONObject(1);
        toJson.put("to",to);
        ranges.add(toJson);
        return this;
    }

    public RangesDetail withToFrom(int from,int to) {
        JSONObject toFromJson = new JSONObject(2);
        toFromJson.put("from",from);
        toFromJson.put("to", to);
        ranges.add(toFromJson);
        return this;
    }

    public RangesDetail withFrom(int from){
        JSONObject fromJson = new JSONObject(1);
        fromJson.put("from",from);
        ranges.add(fromJson);
        return this;
    }
}
