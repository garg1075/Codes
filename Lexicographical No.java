//leet code- ques 386
class Solution {

    public List<Integer> lexicalOrder(int n) {
        List<Integer> result = new ArrayList<>();
        int curNum = 1;
        while (true){
            // add current
            result.add(curNum);
            // try to add 1 digit after
            if (curNum * 10 <= n){
                curNum *= 10;
            } else { // if cannot, try increment current, see if exceed?
                if (curNum % 10 != 9 && curNum + 1 <= n) {
                    curNum += 1;
                } else { // if cannot, pop last digit & increment prev digit
                    while (curNum > 0 && (curNum % 10 == 9 || curNum + 1 > n)){
                        curNum = curNum / 10;
                    }
                    if (curNum == 0) break;
                    curNum += 1;
                }
            }
        }
        return result;
    }

}
