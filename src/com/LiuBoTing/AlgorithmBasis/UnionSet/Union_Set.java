package com.LiuBoTing.AlgorithmBasis.UnionSet;

import java.util.HashMap;
import java.util.List;

/**
 * @author liuboting
 * @date 2022/9/1 22:42
 * 并查集
 */

public class Union_Set {
    public static class Node<V>{
        V value;
        public Node(V v){
            this.value = v;
        }
    }

    public static class UnionSet<V>{
        public HashMap<V,Node<V>> nodes;
        public HashMap<Node<V>,Node<V>> parents;
        public HashMap<Node<V>,Integer> sizeMap;
        public UnionSet(List<V> list){
            nodes = new HashMap<>();
            parents = new HashMap<>();
            sizeMap = new HashMap<>();
            for (V cur: list) {
                Node<V> node = new Node<>(cur);
                nodes.put(cur,node);
                parents.put(node,node);
                sizeMap.put(node,1);
            }
        }
        public Node<V> findFather(Node<V> cur){
            while (cur != parents.get(cur)){
                cur = parents.get(cur);
            }
            return cur;
        }
        public boolean isSameUnion(V a,V b){
            return findFather(nodes.get(a)) == findFather(nodes.get(b));
        }
        public void union(V a ,V b){
            Node<V> aHead = findFather(nodes.get(a));
            Node<V> bHead = findFather(nodes.get(b));
            if(aHead == bHead) return;
            Integer aSize = sizeMap.get(aHead);
            Integer bSize = sizeMap.get(bHead);
            if(aSize > bSize){
                parents.put(bHead,aHead);
                sizeMap.remove(bHead);
            }else {
                parents.put(aHead,bHead);
                sizeMap.remove(aHead);
            }

        }
    }


}
