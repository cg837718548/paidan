package com.cgsj.engineer.enums;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public enum EngineerAreaEnums {
    GUO_JING("郭静", Lists.newArrayList("白杨街道", "下沙街道", "长庆街道", "武林街道", "天水街道", "潮鸣街道", "凯旋街道", "采荷街道", "闸弄口街道", "四季青街道", "彭埠街道", "九堡街道")),
    XIE_ZHUANGZHUANG("谢壮壮", Lists.newArrayList("临平街道", "南苑街道", "东湖街道", "星桥街道", "乔司街道", "运河街道", "崇贤街道", "塘栖镇", "东新街道", "石桥街道", "康桥街道", "半山街道", "笕桥街道", "丁兰街道")),
    LI_WANZHONG("李万忠", Lists.newArrayList("五常街道", "闲林街道", "仓前街道", "余杭街道", "中泰街道", "留下街道", "蒋村街道")),
    LI_WEIPING("李为平", Lists.newArrayList("仁和街道", "良渚街道", "瓶窑镇", "三墩镇", "上塘街道")),
    ZHAO_SHUIPING("赵水平", Lists.newArrayList("径山镇", "鸬鸟镇", "百丈镇", "黄湖镇")),
    LONG_SHUWEN("龙树文", Lists.newArrayList("双浦镇", "转塘街道")),
    WANG_TIE("汪铁", Lists.newArrayList("北山街道", "西溪街道", "翠苑街道", "文新街道", "古荡街道", "西湖街道", "灵隐街道", "朝晖街道", "文晖街道", "米市巷街道", "湖墅街道", "小河街道", "和睦街道", "拱宸桥街道", "大关街道", "祥符街道"));

    private final String chName;
    private final List<String> streets;

    EngineerAreaEnums(String chName, List<String> streets) {
        this.chName = chName;
        this.streets = streets;
    }

    public String getChName() {
        return chName;
    }

    public List<String> getStreets() {
        return streets;
    }

    public static Optional<EngineerAreaEnums> getEngineerByStreet(String street) {
        return Stream.of(EngineerAreaEnums.values())
                .filter(f -> f.getStreets().stream().anyMatch(street::contains))
                .findFirst();
    }


}
