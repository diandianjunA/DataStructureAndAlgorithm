package GreedyAlgorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class GreedyDemo {
    public static void main(String[] args) {
        //创建广播电台，放入map
        HashMap<String, HashSet<String>> broadcasts = new HashMap<>();
        //将各个电台放入broadcast
        //hashset表示每个电台可广播的地区
        HashSet<String> hashSet1 = new HashSet<>();
        hashSet1.add("北京");
        hashSet1.add("上海");
        hashSet1.add("天津");
        HashSet<String> hashSet2 = new HashSet<>();
        hashSet2.add("广州");
        hashSet2.add("北京");
        hashSet2.add("深圳");
        HashSet<String> hashSet3 = new HashSet<>();
        hashSet3.add("成都");
        hashSet3.add("上海");
        hashSet3.add("杭州");
        HashSet<String> hashSet4 = new HashSet<>();
        hashSet4.add("上海");
        hashSet4.add("天津");
        HashSet<String> hashSet5 = new HashSet<>();
        hashSet5.add("杭州");
        hashSet5.add("大连");
        broadcasts.put("K1",hashSet1);
        broadcasts.put("K2",hashSet2);
        broadcasts.put("K3",hashSet3);
        broadcasts.put("K4",hashSet4);
        broadcasts.put("K5",hashSet5);
        //存放所有地区
        HashSet<String> allAreas = new HashSet<>();
        allAreas.add("北京");
        allAreas.add("上海");
        allAreas.add("天津");
        allAreas.add("广州");
        allAreas.add("成都");
        allAreas.add("杭州");
        allAreas.add("大连");
        allAreas.add("深圳");
        //存放选择的电台
        ArrayList<String> selects = new ArrayList<>();
        HashSet<String> tempSet = new HashSet<>();
        //保存每次遍历过程中能覆盖最多地区的电台
        String maxKey = null;
        HashSet<String> maxSize = new HashSet<>();
        while(!allAreas.isEmpty()){
            //遍历broadcast，取出key
            for (String key:broadcasts.keySet()) {
                //当前电台覆盖的地区
                HashSet<String> area = broadcasts.get(key);
                //存入temp中
                tempSet.addAll(area);
                //与目前为覆盖的地区做交集
                tempSet.retainAll(allAreas);
                if (tempSet.size()>0&&(maxKey==null||tempSet.size()>maxSize.size())){
                    maxKey=key;
                    maxSize.addAll(tempSet);
                }
                tempSet.clear();
            }
            if(maxKey!=null){
                selects.add(maxKey);
                allAreas.removeAll(maxSize);
            }
            maxKey=null;
            maxSize.clear();
        }
        System.out.println(selects);
    }
}
