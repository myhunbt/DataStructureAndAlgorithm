package com.LiuBoTing.data_structure.linkedlist;

import java.util.Stack;

/**
 * @author liuboting
 * @date 2020/9/13 14:13
 * 单链表
 */

public class SingleLinkedList {
    public static void main(String[] args) {
        LinkedList linkedList = new SingleLinkedList().new LinkedList();
        SingleLinkedList singleLinkedList = new SingleLinkedList();

//        HeroNode node1 = singleLinkedList.new HeroNode(1, "张三", "老大");
//        HeroNode node2 = singleLinkedList.new HeroNode(2, "李四", "老二");
//        HeroNode node3 = singleLinkedList.new HeroNode(3, "王五", "老三");
//        HeroNode node4 = singleLinkedList.new HeroNode(4, "赵六", "老四");
//        linkedList.addNode1(node1);
//        linkedList.addNode1(node2);
//        linkedList.addNode1(node3);
//        linkedList.addNode1(node4);
//        linkedList.showNode();

        HeroNode node1 = singleLinkedList.new HeroNode(1, "张三", "老大");
        HeroNode node2 = singleLinkedList.new HeroNode(2, "李四", "老二");
        HeroNode node3 = singleLinkedList.new HeroNode(3, "王五", "老三");
        HeroNode node4 = singleLinkedList.new HeroNode(4, "赵六", "老四");
        linkedList.addNode2(node1);
        linkedList.addNode2(node4);
        linkedList.addNode2(node3);
        linkedList.addNode2(node2);
        linkedList.showNode();

//        System.out.println(linkedList.findLastIndexNode(2));

        //反转
//        HeroNode node = reverseLinkedList(linkedList.head);
//        System.out.println(node);
        System.out.println(reverseLinkedList2(linkedList.head));

        //倒序打印
//        reversePrintList(linkedList.head);


//        //修改
//        HeroNode heroNode = singleLinkedList.new HeroNode(4, "小六子", "菜鸡");
//        linkedList.update(heroNode);
//        linkedList.showNode();


    }


    //链表倒序打印(先进后出思想:栈)
    public static void reversePrintList(HeroNode head){
        HeroNode cur = head.next;
        Stack<HeroNode> stack = new Stack<>();
        while (cur != null){
            stack.push(cur);
            cur = cur.next;
        }

        while (!stack.empty()){
            System.out.println(stack.pop());
        }
    }

    public static HeroNode reverseLinkedList2(HeroNode head){
        if(head.next == null){
            return head;
        }
        HeroNode node = reverseLinkedList2(head.next);
        head.next.next = head;
        head.next = null;
        return node;
    }

    // 链表倒序返回(头插法)
    public static HeroNode reverseLinkedList(HeroNode head){
        if(head.next == null || head.next.next == null){
            return head;
        }

        HeroNode cur = head.next;
        HeroNode reverseList = new SingleLinkedList().new HeroNode(0, "", "");
        HeroNode next = null;

        while (cur != null){
            next = cur.next;
            cur.next = reverseList.next;
            reverseList.next = cur;
            cur = next;
        }

        head.next = reverseList.next;
        return head;
    }


    class LinkedList{
        //先初始化一个头节点
        HeroNode head = new HeroNode(0,"","");

        public LinkedList() {

        }

        //链表尾部插入节点
        public void addNode1(HeroNode node){
            HeroNode temp = head;
            while (true){
                if(temp.next == null){
                    break;
                }
                temp = temp.next;
            }
            temp.next = node;
        }


        //无序添加，顺序返回
        public void addNode2(HeroNode node){
            HeroNode temp = head;
            while (true){
                if(temp.next == null){
                    temp.next = node;
                    break;
                }else if(temp.next.no == node.no){
                    System.out.println("添加失败,排名已存在");
                    break;
                }else if(node.no < temp.next.no){
                    node.next = temp.next;
                    temp.next = node;
                    break;
                }
                temp = temp.next;
            }
        }



        //查找链表倒数第k个节点
        public HeroNode findLastIndexNode(int k){
            HeroNode first = head;
//            HeroNode second = head.next;
            HeroNode second = head;
            boolean flag = false;
            int count = 0;
//            while (true){
//                if(second == null){
//                    break;
//                }
//                if(++count >= k){
//                    flag = true;
//                    first = first.next;
//                }
//                second = second.next;
//            }
            while (true){
                if(second.next == null){
                    break;
                }
                second = second.next;
                if(++count >= k){
                    flag = true;
                    first = first.next;
                }
            }
            if(flag){
                return first;
            }else {
                return null;

            }
        }

        public void deleteNode(int no){
            HeroNode temp = head;

            boolean flag = false;
            while (true){
                if(temp.next == null){
                    break;
                }
                if(temp.next.no == no){
                    flag = true;
                    break;
                }
                temp = temp.next;
            }
            if(flag){
                temp.next = temp.next.next;
            }else {
                System.out.println("没有找到该节点");
            }

        }

        public void update(HeroNode newHeroNode){
            HeroNode temp = head.next;
            boolean flag = false;
            while (true){
                if(temp == null){
                    break;
                }else if(temp.no == newHeroNode.no){
                    flag = true;
                    break;
                }
                temp = temp.next;
            }
            if(flag){
                temp.name = newHeroNode.name;
                temp.nickname = newHeroNode.nickname;
            }else {
                System.out.println("没有找到该节点");
            }
        }

        public void showNode(){
            HeroNode temp = head.next;
            while (true){
                if(temp == null){
                    break;
                }
                System.out.println(temp);
                temp = temp.next;
            }
        }

    }

    //定义一个HeroNode
    class HeroNode{
        public int no;
        public String name;
        public String nickname;
        public HeroNode next;
        //构造器

        public HeroNode(int no, String name, String nickname) {
            this.no = no;
            this.name = name;
            this.nickname = nickname;
        }

        @Override
        public String toString() {
            return "HeroNode{" +
                    "no=" + no +
                    ", name='" + name + '\'' +
                    ", nickname='" + nickname + '\'' +
                    ", next=" + next +
                    '}';
        }
    }
}
