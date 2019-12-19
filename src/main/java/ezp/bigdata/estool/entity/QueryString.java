package ezp.bigdata.estool.entity;

import com.alibaba.fastjson.JSONObject;
import lombok.Getter;

/**
 * @author liyuelin
 * @Desc TODO
 * @Date 2019/10/25
 */
@Getter
public class QueryString {
    private JSONObject query_string;

    public QueryString(String fieldName,String queryStr){
        query_string = new JSONObject(1);
        JSONObject jsonObject = new JSONObject(2);
        jsonObject.put("default_field",fieldName);
        jsonObject.put("query",queryStr);
        query_string.put(fieldName,jsonObject);
    }
}
