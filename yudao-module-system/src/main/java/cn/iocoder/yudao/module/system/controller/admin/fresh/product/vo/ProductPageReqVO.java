package cn.iocoder.yudao.module.system.controller.admin.fresh.product.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Schema(description = "管理后台 - 生鲜商品分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
public class ProductPageReqVO extends PageParam {

    @Schema(description = "商品名称，模糊匹配", example = "苹果")
    private String name;

    @Schema(description = "分类id", example = "veg")
    private String catId;

}
