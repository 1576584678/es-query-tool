package ezp.bigdata.estool.entity;
import com.alibaba.fastjson.JSONObject;
import lombok.Getter;

/**
 * @author liyuelin
 * @Desc TODO
 * @Date 2019/10/24
 */
@Getter
public class Term {
    private JSONObject term;

    public Term(String fieldName, Object fieldValue){
        term= new JSONObject(1);
        term.put(fieldName,fieldValue);
    }
}
