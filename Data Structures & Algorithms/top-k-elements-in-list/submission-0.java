class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map=new HashMap<>();
        int ans[]=new int[k];
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i])+1);
            }else{ map.put(nums[i],1);}
           
        }
       //min heap.freq ke hisab se chhota upar
       PriorityQueue<Integer> heap=new PriorityQueue<>((a,b)->map.get(a)-map.get(b));
       for( int num : map.keySet()){
        heap.add(num);
        if(heap.size()>k){
            heap.poll();
        }
       }

       for(int i=0;i<k;i++){
        ans[i]=heap.poll();
       }
       return ans;

    }
}
