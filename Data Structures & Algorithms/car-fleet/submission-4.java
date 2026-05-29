class Solution {
    
    class Fleet {
        int spd;
        int pos;

        Fleet(int s, int p) {this.spd=s; this.pos=p;}
    }
    
    public int carFleet(int target, int[] position, int[] speed) {
        // 뒤에 있는 빠른 것 부터 stack에 넣기 

        Deque<Fleet> stk = new ArrayDeque<>();

        Fleet[] array = new Fleet[speed.length];
        for(int i = 0 ; i < position.length ; i++) {
            array[i] = new Fleet(speed[i], position[i]);
        }
        Arrays.sort(array, (f1,f2)->{
            int comp = Integer.compare(f1.pos,f2.pos);
            if(comp != 0) return comp;
            return Integer.compare(f2.spd, f1.spd);
        });

        for(Fleet f : array) {
            stk.push(f);
        }

        int sum = 0;
        while(!stk.isEmpty()) {
            Fleet pop = stk.pop();
            double popFinish = finishTime(target, pop.spd, pop.pos);

            while(!stk.isEmpty()) {
                Fleet pek = stk.peek();
                double pekFinish = finishTime(target, pek.spd, pek.pos);

                // is peek faster than pop 
                if(pekFinish <= popFinish) {  
                    // then peek is merged to front fleet
                    stk.pop();
                } else {
                    break;
                }
            }

            sum++;
        }
        
        return sum;   
    }

    private double finishTime(int target, int spd, int pos) {
        return (target-pos)/(double)spd;
    }
}
