package cn.iocoder.yudao.module.product.dal.dataobject.delivery;

import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;
import com.baomidou.mybatisplus.annotation.KeySequence;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

// TODO @Jason：要不就叫 DeliveryExpressTemplateChargeDO；detail 主要用来作为明细，不适合作为条目
/**
 * 配送费用详情 DO
 *
 * @author jason
 */
@TableName(value ="delivery_charge_detail")
@KeySequence("delivery_charge_detail_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
public class DeliveryChargeDetailDO extends BaseDO {

    /**
     * 编号，自增
     */
    @TableId
    private Long id;

    /**
     * 配送模板编号, 对应delivery_template表id
     *
     * // TODO @Jason：如果关联，写法如下
     *
     * 关联 {@link DeliveryTemplateDO#getId()}
     */
    private Long templateId;

    // TODO @Jason：全国最好使用 0
    /**
     * 配送区域id 1:适用于全国
     */
    private Integer areaId;

    /**
     * 配送计费方式 1:按件 2:按重量 3:按体积
     *
     * 冗余 {@link DeliveryTemplateDO#getChargeMode()}
     */
    private Integer chargeMode;

    // TODO @Jason：startCount；一般 count 作为数量哈
    /**
     * 首件数量(件数,重量，或体积)
     */
    private Double startQuantity;
    /**
     * 起步价，单位：分
     */
    private Integer startPrice;

    // TODO @Jason：startCount；一般 count 作为数量哈
    /**
     * 续件数量(件,重量，或体积)
     */
    private Double extraQuantity;
    /**
     * 额外价，单位：分
     */
    private Integer extraPrice;

}
