package ezp.bigdata.estool.entity;

import lombok.Data;

/**
 * @author liyuelin
 * @Desc 查询 - 聚合
 * @Date 2019/10/25
 */
@Data
public class QueryAgg {
    private Query query;
    private String[] sort;
    private Object aggs;
}
