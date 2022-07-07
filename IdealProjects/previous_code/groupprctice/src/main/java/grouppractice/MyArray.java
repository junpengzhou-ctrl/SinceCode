package grouppractice;

public class MyArray {
    private  Object [] arr ={};
    private  int  size;
    public  void  add (Object o){
        calcCapy(size+1);
        arr[size++]=0;

    }
    public void  calcCapy(int cap){
        if (arr.length<cap){
            //计算新容量
            int oldcap = arr.length;
            int newcap = oldcap+oldcap>>1;  //在原来的基础上追加50%
            if (newcap==oldcap){
                newcap = cap;
            }
            Object [] newArr =new  Object[newcap];
            System.arraycopy(arr,0,newArr,0,oldcap);
//            Object [] newArr =new  Object[];
//           arr= Arrays.copyOf(arr,newcap);
            arr= newArr;
        }
    }
    public  String toString(){
        System.out.print("[");
        for (Object o: arr) {
            System.out.print(o + ",");
        }
        System.out.print("]");
        return " ";
    }
    public static void main(String[] args) {
     MyArray ma= new MyArray() ;
     ma.add(123);
     ma.add("ffff");
     ma.add(new MyArray());
        System.out.println(ma);
    }
}
