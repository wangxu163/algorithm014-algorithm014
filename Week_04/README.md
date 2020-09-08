学习笔记

二分查找模版
left，right = 0，len(array)-1
while(left<=right){
    mid = (left+right)/2
    if(array[mid]==target){
        return or break
    }
    elif(array[mid]<target){
        left = mid+1;
    }
    else{
        right = mid-1
    }
}