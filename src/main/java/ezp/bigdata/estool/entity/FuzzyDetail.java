package ezp.bigdata.estool.entity;

import lombok.Data;

/**
 * @author liyuelin
 * @Desc 词/项级别的模糊匹配明细
 * @Date 2019/10/25
 */
@Data
public class FuzzyDetail {
    private String value;
    private String max_expansions;
    private String min_similarity;
}
