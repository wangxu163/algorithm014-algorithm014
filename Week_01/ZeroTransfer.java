public class ZeroTransfer {

    public static void main(String[] args) {
        int[] arr = {0,1,0,3,12};
        moveZeroes(arr);
        int[] arr2= {1};
        moveZeroes(arr2);
        int[] arr3= {1,2};
        moveZeroes(arr3);
        int[] arr4= {0,0};
        moveZeroes(arr4);
    }


    public static void moveZeroes(int[] nums) {
        int j = 0;
        for(int i = 0;i<nums.length;i++){
            if(nums[i]!=0){
                nums[j] = nums[i];
                if (i != j) {
                    nums[i] = 0;
                }
                j++;
            }
        }
        PrintUtils.print(nums);
    }
}
