package com.LiuBoTing.data_structure.heap;



import java.util.*;

/**
 * @author liuboting
 * @date 2022/3/12 18:03
 * 客户购买商品
 * 给定一个客户id数组和一个每时刻客户商品操作（购买/退货）数组
 * 找到每时刻购买数量的前k个用户（作为中奖用户），其他用户放在候选区
 * [1,1,2,5,7,9,3] 客户编号
 * [T,T,F,T,T,F,T] T为购买一件商品 ，F为退货一件
 */

public class EveryStepShowBoss {
    public static class Customer{
        private int customerId; //客户编号
        private int buyNums; //购买数量
        private int enterTime; //进入候选区或者获奖区的时间
        public Customer(int id,int num,int time){
            this.customerId = id;
            this.buyNums = num;
            this.enterTime = time;
        }

        public int getCustomerId() {
            return customerId;
        }

        public void setCustomerId(int customerId) {
            this.customerId = customerId;
        }

        public int getBuyNums() {
            return buyNums;
        }

        public void setBuyNums(int buyNums) {
            this.buyNums = buyNums;
        }

        public int getEnterTime() {
            return enterTime;
        }

        public void setEnterTime(int enterTime) {
            this.enterTime = enterTime;
        }
    }

    public static void main(String[] args) {
        Customer c1 = new Customer(1, 2, 4);
        Customer c2 = new Customer(2, 2, 2);
        Customer[] customers = new Customer[]{c1,c2};
        ArrayList<Customer> list = new ArrayList<>();
        list.add(c1);
        list.add(c2);



    }
    public static class CandidateComparator implements Comparator<Customer> {

        @Override
        public int compare(Customer t1, Customer t2) {
            return t1.buyNums == t2.buyNums? (t1.enterTime - t2.enterTime) : (t2.buyNums - t1.buyNums);
        }
    }

    public static class DaddyComparator implements Comparator<Customer>{

        @Override
        public int compare(Customer t1, Customer t2) {
            return t1 == t2 ? (t1.enterTime - t2.enterTime) : (t1.buyNums - t2.buyNums);
        }
    }

    //干完所有的事情，不优化（暴力方法）
    public static List<List<Integer>> compare(int[] arr,boolean[] op,int k){
        HashMap<Integer, Customer> map = new HashMap<>(); //id对应的实例表
        ArrayList<Customer> cands = new ArrayList<>(); //候选区
        ArrayList<Customer> daddy = new ArrayList<>(); //得奖区
        List<List<Integer>> ans = new ArrayList<>(); //没时间点记录的得奖人id
        for (int i = 0; i < arr.length; i++) {
            int id = arr[i];
            boolean buyOrRefund = op[i];
            // 当前退货行为 且 实例表中没有当前客户id
            if(!buyOrRefund && !map.containsKey(id)){
                ans.add(getCurAns(daddy));
                continue;
            }
            // 购买0 且 买货事件
            if(!map.containsKey(id)){
                map.put(id,new Customer(id,0,0));
            }
            Customer c = map.get(id);
            // 购买>0 买货/退货
            if(buyOrRefund){
                c.buyNums++;
            }else{
                c.buyNums--;
            }
            //购买数为0，删掉
            if(c.buyNums == 0){
                map.remove(id);
            }
            if(!cands.contains(c) && !daddy.contains(c)){
                c.enterTime = i;
                if(daddy.size() < k){
                    daddy.add(c);
                }else {
                    cands.add(c);
                }
            }
            cleanZeroBuy(cands);
            cleanZeroBuy(daddy);
            cands.sort(new CandidateComparator());
            daddy.sort(new DaddyComparator());
            move(cands,daddy,k,i);
            ans.add(getCurAns(daddy));
        }


        return ans;
    }

    private static void move(ArrayList<Customer> cands, ArrayList<Customer> daddy, int k, int time) {
        if(cands.isEmpty()) return;
        Customer cand = cands.get(0);
        Customer dad = daddy.get(0);

        if(daddy.size() < k){
            cand.enterTime = time;
            daddy.add(cand);
            cands.remove(0);
        }else {
            if(cand.buyNums > dad.buyNums){
                dad.enterTime = time;
                cand.enterTime = time;
                cands.set(0,dad);
                daddy.set(0,cand);

            }
        }
    }

    private static void cleanZeroBuy(ArrayList<Customer> arr) {
        Customer rem = null;
        for (int i = 0; i < arr.size(); i++) {
            Customer c = arr.get(i);
            if(c.buyNums == 0){
               rem = c;
            }
        }
        arr.remove(rem);
    }

    private static List<Integer> getCurAns(ArrayList<Customer> daddy) {
        List<Integer> list = new ArrayList<>();
        for (Customer customer : daddy) {
            list.add(customer.getCustomerId());
        }
        return list;
    }


    // 加强堆实现
    public static class WhoIsYourDaddy{
        private HashMap<Integer,Customer> map;
        private HeapGreater<Customer> candHeap;
        private HeapGreater<Customer> daddyHeap;
        private final int daddyLimit;
        public WhoIsYourDaddy(int limit){
            this.daddyLimit = limit;
            this.candHeap = new HeapGreater<Customer>(new CandidateComparator());
            this.daddyHeap = new HeapGreater<Customer>(new DaddyComparator());
            this.map = new HashMap<Integer, Customer>();
        }

        public List<Integer> getDaddies(){
            List<Customer> customers = daddyHeap.getAllElements();
            List<Integer> ans = new ArrayList<>();
            for (Customer c: customers) {
                ans.add(c.customerId);
            }
            return ans;
        }

        public void operate(int time,int id,boolean op){
            if(!op && !map.containsKey(id)){
                return;
            }
            if(!map.containsKey(id)){
                map.put(id,new Customer(id,0,0));
            }
            Customer customer = map.get(id);
            if(op){
                customer.buyNums++;
            }else {
                customer.buyNums--;
            }
            if(customer.buyNums == 0){
                map.remove(id);
            }
            if(!candHeap.contain(customer) && !daddyHeap.contain(customer)){
                customer.enterTime = time;
                if(daddyHeap.size()<daddyLimit){
                    daddyHeap.push(customer);
                }else {
                    candHeap.push(customer);
                }
            }else if(candHeap.contain(customer)){
                if(customer.buyNums == 0){
                    candHeap.remove(customer);
                }else {
                    candHeap.resign(customer);
                }
            }else {
                if(customer.buyNums == 0){
                    daddyHeap.remove(customer);
                }else {
                    daddyHeap.resign(customer);
                }
            }

            daddyMove(time);

        }

        private void daddyMove(int time) {
            if(candHeap.isEmpty()) return;
            if(daddyHeap.size() < daddyLimit){
                Customer pop = candHeap.pop();
                pop.enterTime = time;
                daddyHeap.push(pop);
            }else {
                if(candHeap.peek().buyNums > daddyHeap.peek().buyNums){
                    Customer c1 = daddyHeap.pop();
                    Customer c2 = candHeap.pop();
                    c1.enterTime = time;
                    c2.enterTime = time;
                    daddyHeap.push(c2);
                    candHeap.push(c1);
                }
            }
        }

        public static List<List<Integer>> topk(int[] arr,boolean[] op,int k){
            List<List<Integer>> ans = new ArrayList<>();
            WhoIsYourDaddy whoIsYourDaddy = new WhoIsYourDaddy(k);
            for (int i = 0; i < arr.length; i++) {
                whoIsYourDaddy.operate(i,arr[i],op[i]);
                List<Integer> daddies = whoIsYourDaddy.getDaddies();
                ans.add(daddies);
            }

            return ans;
        }

    }

}
