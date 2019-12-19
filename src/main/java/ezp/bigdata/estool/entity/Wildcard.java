package ezp.bigdata.estool.entity;

import com.alibaba.fastjson.JSONObject;
import lombok.Getter;

/**
 * @author liyuelin
 * @Desc TODO
 * @Date 2019/10/25
 */
@Getter
public class Wildcard {
    private JSONObject wildcard;

    public Wildcard(String fieldName,String fieldValue) {
        wildcard = new JSONObject(1);
        wildcard.put(fieldName,fieldValue);
    }
}
