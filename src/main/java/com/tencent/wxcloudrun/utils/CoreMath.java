package com.tencent.wxcloudrun.utils;

import com.tencent.wxcloudrun.model.Rating;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CoreMath {

    public List<Integer> recommend(Integer userId, List<Rating> list) {
        //找到最近邻用户id
        Map<Double, Integer> distances = computeNearestNeighbor(userId, list);
        Integer nearest = distances.values().iterator().next();

        Map<Integer, List<Rating>>  userMap = list.stream().collect(Collectors.groupingBy(Rating::getUid));

        //最近邻用户看过Item列表
        List<Integer>  neighborItemList = userMap.get(nearest).stream().map(e->e.getPid()).collect(Collectors.toList());
        //指定用户看过Item列表
        List<Integer>  userItemList  = userMap.get(userId).stream().map(e->e.getPid()).collect(Collectors.toList());;

        //找到最近邻看过，但是该用户没看过的item，计算推荐，放入推荐列表
        List<Integer> recommendList = new ArrayList<>();
        for (Integer item : neighborItemList) {
            if (!userItemList.contains(item)) {
                recommendList.add(item);
            }
        }
        Collections.sort(recommendList);
        return recommendList;
    }


    /**
     * 在给定userId的情况下，计算其他用户和它的相关系数并排序
     * @param userId
     * @param list
     * @return
     */
    private Map<Double, Integer> computeNearestNeighbor(Integer userId, List<Rating> list) {
        Map<Integer, List<Rating>>  userMap=list.stream().collect(Collectors.groupingBy(Rating::getUid));
        Map<Double, Integer> distances = new TreeMap<>();
        userMap.forEach((k,v)->{
            if(k != userId){
                double distance = pearson_dis(v,userMap.get(userId));
                distances.put(distance, k);
            }
        });
        return distances;
    }


    /**
     * 计算两个序列间的相关系数
     *
     * @param xList
     * @param yList
     * @return
     */
    private double pearson_dis(List<Rating> xList, List<Rating> yList) {
        List<Float> xs= new ArrayList<>();
        List<Float> ys= new ArrayList<>();
        xList.forEach(x->{
            yList.forEach(y->{
                if(x.getPid()==y.getPid()){
                    xs.add(x.getScore());
                    ys.add(y.getScore());
                }
            });
        });
        return getRelate(xs,ys);
    }

    /**
     * 方法描述: 皮尔森（pearson）相关系数计算
     *
     * @param xs
     * @param ys 
     * @Return {@link Double}
     * @throws 
     * @author tarzan
     * @date 2020年07月31日 17:03:20
     */
    public static Double getRelate(List<Float> xs, List<Float>  ys){
        int n=xs.size();
        double Ex= xs.stream().mapToDouble(x->x).sum();
        double Ey=ys.stream().mapToDouble(y->y).sum();
        double Ex2=xs.stream().mapToDouble(x->Math.pow(x,2)).sum();
        double Ey2=ys.stream().mapToDouble(y->Math.pow(y,2)).sum();
        double Exy= IntStream.range(0,n).mapToDouble(i->xs.get(i)*ys.get(i)).sum();
        double numerator=Exy-Ex*Ey/n;
        double denominator=Math.sqrt((Ex2-Math.pow(Ex,2)/n)*(Ey2-Math.pow(Ey,2)/n));
        if (denominator==0) return 0.0;
        return numerator/denominator;
    }

}
