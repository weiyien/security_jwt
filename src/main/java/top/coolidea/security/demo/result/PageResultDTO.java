package top.coolidea.security.demo.result;

import lombok.Data;

import java.util.List;

/**
 * @author: 魏薏恩
 * @date: 2019/2/28 15:43
 * @description: 统一返回类型, 列表返回类型.
 */
@Data
public class PageResultDTO<T> {
    /**
     * list长度
     */
    private Integer total;
    /**
     * 返回的数据
     */
    private List<T> rows;

    public PageResultDTO(Integer total, List<T> rows) {
        super();
        this.total = total;
        this.rows = rows;
    }
}
