public class sort {
    public static void main(String[] args) {
        int[] data = new int[]{4, 5, 6, 3, 2, 1};
//        insert(data);
        bubble(data);
        print(data);
    }

    public static void bubble(int[] data) {
        int n = data.length;
        if (n <= 1) {
            return;
        } else {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n - i - 1; j++) {
                    if (data[j]>data[j+1]) {
                        int temp = data[j];
                        data[j] = data[j + 1];
                        data[j + 1] = temp;
                    }
                }
            }
        }
    }

    public static void insert(int[] data){
        int n=data.length;
        if(n<=1){
            return;
        }else{
            for(int i=1;i<n;i++){
                int temp=data[i];
                int j=i-1;
                for(;j>=0;j--){
                    if(data[j]>temp){
                        data[j+1]=data[j];
                    }else{
                        break;
                    }
                }
                data[j+1]=temp;
            }
        }
    }



    public static void print(int[] data) {
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + "、");
        }
    }

}