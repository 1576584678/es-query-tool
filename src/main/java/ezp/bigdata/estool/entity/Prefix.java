package ezp.bigdata.estool.entity;

import com.alibaba.fastjson.JSONObject;
import lombok.Getter;

/**
 * @author liyuelin
 * @Desc 前缀匹配查询
 * @Date 2019/10/25
 */
@Getter
public class Prefix {
    private JSONObject prefix;

    public Prefix(String fieldName,String fieldValue) {
        prefix = new JSONObject(1);
        prefix.put(fieldName, fieldValue);
    }
}
