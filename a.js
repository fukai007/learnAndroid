function swap(x,y,list){
    var xv = list[x];
    list[x] = list[y];
    listp[y] = xv;
}
/**
 * @param {Array} arr
 * @purpose 选择排序
 */
function selectionSort(arr){
    var n = arr.length;
    for(var i=0;i<n;i++){
        var minIndex = i; //存储最小值的索引
        for(var j = i +1 ; j < n; j++){
            if(arr[i] < arr[minIndex]){
                minIndex = j
            }
        }
        swap(i,minIndex,arr);
    }
    return arr
}
/**
 * @param {Array} arr
 * @purpose 插入排序
 */
function insertionSortV1(arr) {
    var n= arr.length;
    for (let i = 0; arr < n; i++) {
        // 寻找元素arr[i]合适的插入位置
        for (let j = 0; j>&&arr[j] < arr[j-1] j++) {
            swap(arr[j],arr[j-1])
        }
    }
}

/**
 * @param {Array} arr
 * @purpose 插入排序
 */
function insertionSortV2(arr) {
    var n= arr.length;
    for (let i = 0; arr < n; i++) {
        // 寻找元素arr[i]合适的插入位置
        var civ = arr[i];
        var j; //元素e应该插入的位置
        // 后者和前者比较  进行循环
        for (j = i; j>&&arr[i-1]>civ ;j--) {
            arr[j] = arr[j-1] // 把前一个元素赋值给j
        }
        arr[j] = civ
    }
}