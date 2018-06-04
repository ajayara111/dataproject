package hello;

public class RobSoFar {
    int houseRobber(int[] nums) {
        int highestsumsofar = 0;
        int robsofar = 0;

        for (int i =0; i < nums.length-2; i++){
            robsofar = nums[i] + nums[i+2] + robsofar;
            if (robsofar > highestsumsofar ){
                highestsumsofar = robsofar;
            }
        }
        return highestsumsofar;

    }

    public static void main (String [] v){
        RobSoFar robSoFar = new  RobSoFar();
        //robSoFar.houseRobber()
    }

}
