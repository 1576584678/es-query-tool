package ezp.bigdata.estool.entity;

import com.alibaba.fastjson.JSONObject;
import lombok.Getter;

import java.util.Iterator;
import java.util.Set;

/**
 * @author liyuelin
 * @Desc TODO
 * @Date 2019/10/25
 */
@Getter
public class Aggs {
    protected JSONObject aggs;

    /**
     *  内嵌
     * @return
     */
    public Aggs nestAggs(Aggs agg){
        Set<String> keyset = aggs.keySet();
        Iterator<String> it = keyset.iterator();
        //判断迭代器是否存在值
        while (it.hasNext()) {
            String keystr = it.next();
            JSONObject fieldDetail = aggs.getJSONObject(keystr);
            fieldDetail.put("aggs",agg.getAggs());
            break;
        }
        return this;
    }
}
