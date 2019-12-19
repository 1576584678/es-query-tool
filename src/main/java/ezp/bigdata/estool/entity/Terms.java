package ezp.bigdata.estool.entity;

import com.alibaba.fastjson.JSONObject;
import lombok.Getter;

/**
 * @author liyuelin
 * @Desc TODO
 * @Date 2019/10/25
 */
@Getter
public class Terms {
    private JSONObject terms;

    public Terms(String fieldName, Object[] fieldValues) {
        terms = new JSONObject(1);
        terms.put(fieldName, fieldValues);
    }
}
