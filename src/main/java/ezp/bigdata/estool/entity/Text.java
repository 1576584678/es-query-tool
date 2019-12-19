package ezp.bigdata.estool.entity;

import com.alibaba.fastjson.JSONObject;
import lombok.Getter;

/**
 * @author liyuelin
 * @Desc TODO
 * @Date 2019/10/25
 */
@Getter
public class Text {
    private JSONObject text;
    public Text(String fieldName,String fieldValue) {
        text = new JSONObject(1);
        text.put(fieldName,fieldValue);
    }
}
