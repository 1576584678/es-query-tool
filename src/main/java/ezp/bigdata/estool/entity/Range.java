package ezp.bigdata.estool.entity;

import com.alibaba.fastjson.JSONObject;
import lombok.Getter;

/**
 * @author liyuelin
 * @Desc TODO
 * @Date 2019/10/24
 */
@Getter
public class Range {
    private JSONObject range;

    public Range(String fieldName, RangeDetail rangeDetail) {
        range = new JSONObject(1);
        range.put(fieldName,rangeDetail);
    }
}
