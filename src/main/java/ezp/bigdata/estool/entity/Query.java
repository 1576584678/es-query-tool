package ezp.bigdata.estool.entity;

import lombok.Getter;

/**
 * @author liyuelin
 * @Desc 查询条件
 * @Date 2019/10/24
 */
@Getter
public class Query {
    private Bool bool;
    public Query(Bool b){
        this.bool= b;
    }
}
