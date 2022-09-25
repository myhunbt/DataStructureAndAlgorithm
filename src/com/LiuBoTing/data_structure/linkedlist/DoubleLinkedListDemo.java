package com.LiuBoTing.data_structure.linkedlist;

/**
 * @author liuboting
 * @date 2020/9/14 18:45
 */

public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        HeroNode node1 = new HeroNode(1, "张三", "老大");
        HeroNode node2 = new HeroNode(2, "李四", "老二");
        HeroNode node3 = new HeroNode(3, "王五", "老三");
        HeroNode node4 = new HeroNode(4, "赵六", "老四");

        DoubleLinkedList list = new DoubleLinkedList();
//        list.addNode(node1);
//        list.addNode(node3);
//        list.addNode(node2);
//        list.addNode(node4);
//        list.updateNode(new HeroNode(2,"四~~","二哥"));
//        list.deleteNode(2);

        list.addOrder(node1);
        list.addOrder(node3);
        list.addOrder(node2);
        list.addOrder(node4);
        list.deleteNode(4);
        list.showDoubleLinkedList();

    }
}

class DoubleLinkedList{
    private HeroNode head = new HeroNode(0,"","");

    public HeroNode getHead(){
        return head;
    }

    public void addOrder(HeroNode node){
        if(head.next == null){
            head.next = node;
            node.pre = head;
            return;
        }

        HeroNode temp = head;
        boolean flag = false;
        while (true){
            if(temp.next == null){
                break;
            }
            if(temp.next.no > node.no){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if(flag){
            temp.next.pre = node;
            node.next = temp.next;
            temp.next = node;
            node.pre = temp;
        }else {
            node.pre = temp;
            temp.next = node;
        }
    }


    //删除
    public void deleteNode(int no){
        HeroNode temp = head.next;
        if(temp == null){
            System.out.println("链表为空");
            return;
        }
        boolean flag = false;
        while (true){
            if(temp == null){
                break;
            }
            if(temp.no == no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if(flag){
            temp.pre.next = temp.next;
            if(temp.next != null){
                temp.next.pre = temp.pre;
            }
        }else {
            System.out.println("没有找到该节点");
        }

    }

    //修改
    public void updateNode(HeroNode heroNode){
        HeroNode temp = head.next;
        boolean flag = false;
        while (true){
            if(temp == null){
                break;
            }else if(temp.no == heroNode.no){
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if(flag){
            temp.name = heroNode.name;
            temp.nickname = heroNode.nickname;
        }else {
            System.out.println("没有该节点");
        }
    }

    // 添加节点
    public void addNode(HeroNode node){
        HeroNode temp = head;
        while (true){
            if(temp.next == null){
                break;
            }
            temp = temp.next;
        }
        temp.next = node;
        node.pre = temp;
    }

    //遍历双向链表
    public void showDoubleLinkedList(){
        if(head.next == null){
            System.out.println("链表为空");
        }

        HeroNode heroNode = head.next;
        while (heroNode != null){
            System.out.println(heroNode);
            heroNode = heroNode.next;
        }
    }
}

class HeroNode{
    public int no;
    public String name;
    public String nickname;
    public HeroNode pre;
    public HeroNode next;

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
                '}';
    }
}