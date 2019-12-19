package ezp.bigdata.estool.entity;

import com.alibaba.fastjson.JSONObject;

/**
 * @author liyuelin
 * @Desc 分组统计
 * @Date 2019/10/28
 */
public class TermsAggs extends Aggs{
    /**
     *
     * @param alias     别名
     * @param fieldName 分组字段
     */
    public TermsAggs(String alias,String fieldName){
        aggs=new JSONObject(1);
        JSONObject terms = new JSONObject(1);
        JSONObject field = new JSONObject(1);
        terms.put("field",fieldName);
        field.put("terms",terms);
        aggs.put(alias,field);
    }
}
