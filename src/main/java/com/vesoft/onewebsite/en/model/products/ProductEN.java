package com.vesoft.onewebsite.en.model.products;

import com.vesoft.onewebsite.en.model.base.HyperModel;
import lombok.Getter;
import lombok.Setter;
import xyz.erupt.annotation.Erupt;
import xyz.erupt.annotation.EruptField;
import xyz.erupt.annotation.sub_erupt.LinkTree;
import xyz.erupt.annotation.sub_erupt.Power;
import xyz.erupt.annotation.sub_field.Edit;
import xyz.erupt.annotation.sub_field.EditType;
import xyz.erupt.annotation.sub_field.View;
import xyz.erupt.annotation.sub_field.ViewType;
import xyz.erupt.annotation.sub_field.sub_edit.Search;
import xyz.erupt.core.annotation.EruptDataSource;

import javax.persistence.*;
import java.util.Set;

@EruptDataSource("english_datasource")
@Erupt(name = "Website Product Info",
        power = @Power(importable = true, export = true),
        linkTree = @LinkTree(field = "product_category")
)
@Entity
@Table(name = "website_product")
@Getter
@Setter
public class ProductEN extends HyperModel {
    @EruptField(
            views = @View(title = "Main Title"),
            edit = @Edit(title = "Main Title", notNull = true, search = @Search(vague = true))
    )
    private String name;

    @EruptField(
            views = @View(title = "Description"),
            edit = @Edit(title = "Description", notNull = true, search = @Search(vague = true))
    )
    private String description;

    @EruptField(
            views = @View(title = "Main Pic Link", type= ViewType.IMAGE),
            edit = @Edit(title = "Main Pic Link", notNull = true, type = EditType.INPUT)
    )
    private String main_pic;

//    @EruptField(
//        views = @View(title = "产品类型"),
//        edit = @Edit(title = "产品类型", type = EditType.CHOICE,
//        choiceType = @ChoiceType(
//                vl = {
//                    @VL(label = "Nebula Graph", value = "nebulagraph"),
//                    @VL(label = "Explorer", value = "explorer"),
//                    @VL(label = "Dashboard", value = "dashboard"),
//                    @VL(label = "Studio", value = "studio"),
//                    @VL(label = "Cloud", value = "cloud"),
//                }
//        ))
//    )
//    private String type;

    @ManyToOne
    @EruptField(
            views = @View(title = "category", column = "name"),
            edit = @Edit(title = "category", notNull = true, type = EditType.REFERENCE_TREE)
    )
    private ProductCategoryEN product_category;

    @EruptField(
            views = @View(title = "Summary"),
            edit = @Edit(title = "Summary", notNull = true, search = @Search(vague = true))
    )
    private String summary;

    @EruptField(
            views = @View(title = "Summary Detail", type=ViewType.TEXT),
            edit = @Edit(title = "Summary Detail", search = @Search(vague = true), type = EditType.TEXTAREA)
    )
    @Column(columnDefinition = "LONGTEXT NOT NULL")
    private String summary_feature;

    @EruptField(
            views = @View(title = "Summary Pic Link", type=ViewType.IMAGE),
            edit = @Edit(title = "Summary Pic Link", type = EditType.INPUT)
    )
    private String summary_feature_pic;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name="product_id")
    @EruptField(
            views = @View(title = "features"),
            edit = @Edit(title = "features", search = @Search(vague = true), type = EditType.TAB_TABLE_ADD)
    )
    private Set<FeatureEN> features;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name="product_id")
    @EruptField(
            views = @View(title = "Advantage"),
            edit = @Edit(title = "Advantage", search = @Search(vague = true), type = EditType.TAB_TABLE_ADD)
    )
    private Set<AdvantageEN> advantages;

    @EruptField(
            views = @View(title = "Reason Subtitle"),
            edit = @Edit(title = "Reason Subtitle", notNull = true)
    )
    private String reason_subtitle;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name="product_id")
    @EruptField(
            views = @View(title = "Reasons"),
            edit = @Edit(title = "Reasons", search = @Search(vague = true), type = EditType.TAB_TABLE_ADD)
    )
    private Set<ReasonEN> reasons;

    @EruptField(
            views = @View(title = "Video Link", type = ViewType.LINK),
            edit = @Edit(title = "Video Link")
    )
    private String video_url;

    @EruptField(
            views= @View(title = "Other", type = ViewType.CODE),
            edit = @Edit(title = "Other", type = EditType.CODE_EDITOR)
    )
    @Column(columnDefinition = "LONGTEXT NOT NULL")
    private String other;
}
