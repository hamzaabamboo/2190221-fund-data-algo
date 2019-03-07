package lab.lab_1;

public class Carrier {
    private Aircraft[] ac;

    public Carrier() {
        this(new Aircraft[5]);
    }

    public Carrier(Aircraft[] ac) {
        this.ac = ac;
        for (Aircraft plane : this.ac) {
            if (plane != null)
                plane.setCurrentSpeed(0);
        }
    }

    public Aircraft[] getCrafts() {
        return this.ac;
    }

    public boolean planeLand(Aircraft p) {
        for (int i = 0; i < ac.length; i++) {
            if (ac[i] == null) {
                ac[i] = p;
                p.setCurrentSpeed(0);
                return true;
            }
        }
        return false;
    }

    public boolean planeTakeoff(Aircraft p) {
        for (int i = 0; i < ac.length; i++) {
            if (ac[i] == p) {
                p.setCurrentSpeed(10);
                ac[i] = null;
                return true;
            }
        }
        return false;
    }

    public String toString() {
        String res = "";
        for (Aircraft a : ac) {
            res += a + "\n";
        }
        return res;
    }
}
