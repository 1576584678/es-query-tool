package ezp.bigdata.estool.entity;

import com.alibaba.fastjson.JSONObject;
import lombok.Getter;

/**
 * @author liyuelin
 * @Desc TODO
 * @Date 2019/11/19
 */

@Getter
public class Exists {
    private JSONObject exists;
    public Exists(String fieldName){
        exists = new JSONObject(1);
        exists.put("field",fieldName);
    }
}
