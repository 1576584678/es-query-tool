package ezp.bigdata.estool.entity;

import com.alibaba.fastjson.JSONArray;
import lombok.Data;

/**
 * @author liyuelin
 * @Desc  复合过滤器
 * @Date 2019/10/24
 */
@Data
public class Bool {
    private JSONArray must;
    private JSONArray must_not;
    private JSONArray should;
}
