package com.vesoft.onewebsite.model.products;

import lombok.Setter;
import xyz.erupt.annotation.Erupt;
import xyz.erupt.annotation.EruptField;
import xyz.erupt.annotation.sub_erupt.Power;
import xyz.erupt.annotation.sub_field.Edit;
import xyz.erupt.annotation.sub_field.EditType;
import xyz.erupt.annotation.sub_field.View;
import xyz.erupt.annotation.sub_field.ViewType;
import xyz.erupt.annotation.sub_field.sub_edit.AttachmentType;
import xyz.erupt.annotation.sub_field.sub_edit.Search;
import xyz.erupt.jpa.model.BaseModel;
import xyz.erupt.upms.model.base.HyperModel;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Erupt(name = "官网产品优势",
        power = @Power(importable = true, export = true)
)
@Entity
@Table(name = "website_product_advantage")
@Getter
@Setter
public class Advantage extends HyperModel {
    @EruptField(
            views = @View(title = "优势标题"),
            edit = @Edit(title = "优势标题", notNull = true, search = @Search(vague = true))
    )
    private String content;

    @EruptField(
            views = @View(title = "优势描述"),
            edit = @Edit(title = "优势描述", notNull = true, search = @Search(vague = true))
    )
    private String description;

    @EruptField(
            views = @View(title = "描述图片", type = ViewType.IMAGE),
            edit = @Edit(title = "描述图片", type = EditType.INPUT)
    )
    private String link;
}

