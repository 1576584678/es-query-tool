package ezp.bigdata.estool.entity;

import com.alibaba.fastjson.JSONObject;
import lombok.Getter;

/**
 * @author liyuelin
 * @Desc 词/项级别的模糊匹配
 * @Date 2019/10/24
 */
@Getter
public class Fuzzy {

    private JSONObject fuzzy;

    public Fuzzy(String fieldName, FuzzyDetail fuzzyDetail){
        fuzzy = new JSONObject(1);
        fuzzy.put(fieldName,fuzzyDetail);
    }

}
