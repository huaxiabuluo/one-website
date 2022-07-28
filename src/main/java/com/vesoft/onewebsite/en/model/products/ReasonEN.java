package com.vesoft.onewebsite.en.model.products;

import com.vesoft.onewebsite.en.model.base.HyperModel;
import lombok.Getter;
import lombok.Setter;
import xyz.erupt.annotation.Erupt;
import xyz.erupt.annotation.EruptField;
import xyz.erupt.annotation.sub_erupt.Power;
import xyz.erupt.annotation.sub_field.Edit;
import xyz.erupt.annotation.sub_field.EditType;
import xyz.erupt.annotation.sub_field.View;
import xyz.erupt.annotation.sub_field.ViewType;
import xyz.erupt.annotation.sub_field.sub_edit.Search;
import xyz.erupt.core.annotation.EruptDataSource;

import javax.persistence.Entity;
import javax.persistence.Table;

@EruptDataSource("english_datasource")
@Erupt(name = "官网产品使用原因",
        power = @Power(importable = true, export = true)
)
@Entity
@Table(name = "website_product_reason")
@Getter
@Setter
public class ReasonEN extends HyperModel {
    @EruptField(
            views = @View(title = "简要原因"),
            edit = @Edit(title = "简要原因", notNull = true, search = @Search(vague = true))
    )
    private String content;


    @EruptField(
            views = @View(title = "描述图片", type = ViewType.IMAGE),
            edit = @Edit(title = "描述图片", type = EditType.INPUT)
    )
    private String icon;
}