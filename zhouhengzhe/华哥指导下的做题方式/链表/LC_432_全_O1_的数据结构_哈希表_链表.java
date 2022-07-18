package com.zhz.hua.week2;

public class LC_432_全_O1_的数据结构_哈希表_链表 {
    //==== 不限制O(1)的情况下 before======
    // private Map<String, Integer> map;

    // public LC_432_全_O1_的数据结构_哈希表_链表() {
    //     map = new HashMap<>();
    // }

    // public void inc(String key) {
    //     if (map.containsKey(key)) {
    //         map.put(key, map.get(key) + 1);
    //     } else {
    //         map.put(key, 1);
    //     }
    // }

    // public void dec(String key) {
    //     if (map.containsKey(key)) {
    //         if (map.get(key) == 1) {
    //             map.remove(key);
    //         } else {
    //             map.put(key, map.get(key) - 1);
    //         }
    //     }
    // }

    // public String getMaxKey() {
    //     List<Map.Entry<String, Integer>> list = new LinkedList<>(map.entrySet());
    //     if (list.size() == 0) {
    //         return "";
    //     }
    //     list.sort(Comparator.comparingInt(Map.Entry::getValue));
    //     return list.get(0).getKey();
    // }

    // public String getMinKey() {
    //     List<Map.Entry<String, Integer>> list = new LinkedList<>(map.entrySet());
    //     if (list.size() == 0) {
    //         return "";
    //     }
    //     list.sort(Comparator.comparingInt(Map.Entry::getValue));
    //     return list.get(list.size() - 1).getKey();
    // }
//==== 不限制O(1)的情况下 after======
}
