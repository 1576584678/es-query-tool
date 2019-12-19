package ezp.bigdata.estool.entity;


import lombok.Data;

/**
 * @author liyuelin
 * @Desc TODO
 * @Date 2019/10/24
 */
@Data
public class RangeDetail {
    private Object lt;
    private Object gt;
    private Object lte;
    private Object gte;
    private Float boost;
    private String format;
}
