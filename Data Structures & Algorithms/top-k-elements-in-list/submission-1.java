class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        //freqMap
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num , freqMap.getOrDefault(num, 0) + 1);
        }
        
        //bucket
        List<List<Integer>> buckets = new ArrayList<>();
        for (int i = 0; i <= nums.length; i++) {
            buckets.add(new ArrayList<>());
        }

        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            int frequency = entry.getValue();
            int number = entry.getKey();
            buckets.get(frequency).add(number);
        }

        int[] otherArray = new int[k]; 
        int count = 0;
        for (int i = buckets.size() - 1; i >= 0; i--) {
            if (!buckets.get(i).isEmpty()) {
                for (int num : buckets.get(i)) {
                    otherArray[count++] = num;
                    if (count == k) {
                        return otherArray;
                    }
                }
            }
        }
        return otherArray;
    }
}
