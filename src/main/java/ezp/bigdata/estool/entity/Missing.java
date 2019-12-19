package ezp.bigdata.estool.entity;

import com.alibaba.fastjson.JSONObject;
import lombok.Getter;

/**
 * @author liyuelin
 * @Desc  Missing 已经从 ES 5 版本移除
 * 查询是查那些不存在的字段的数据
 * @Date 2019/10/25
 */
@Getter
public class Missing {
    private JSONObject constant_score;
    public Missing(String fieldName){
        constant_score = new JSONObject(1);
        JSONObject filter = new JSONObject(1);
        JSONObject missing= new JSONObject(1);
        missing.put("field",fieldName);
        filter.put("missing",missing);
        constant_score.put("filter",filter);
    }
}
