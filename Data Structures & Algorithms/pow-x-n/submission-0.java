class Solution {
    public double myPow(double x, int n) {
        long nn = n;

        if (nn < 1)
            return 1.0 / pow(x, -nn);
        
        return pow(x, nn);
    }

    private double pow(double x, long nn) {
        if (nn == 0)
            return 1;
        
        double half = pow(x, nn / 2);

        if (nn % 2 ==  1)
            return half * half * x;
        return half * half;
    }
}
