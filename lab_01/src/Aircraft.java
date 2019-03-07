public class Aircraft {
    private int currentSpeed;
    private int maxSpeed;

    public Aircraft() {
        this(0, 100);
    }

    public Aircraft(int currentSpeed, int maxSpeed) {
        setMaxSpeed(maxSpeed);
        setCurrentSpeed(currentSpeed);
    }

    public int getCurrentSpeed() {
        return currentSpeed;
    }

    public void setCurrentSpeed(int currentSpeed) {
        if (currentSpeed < 0) {
            this.currentSpeed = 0;
        } else if (currentSpeed > maxSpeed) {
            this.currentSpeed = maxSpeed;
        } else {
            this.currentSpeed = currentSpeed;
        }
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        if (maxSpeed < 50) {
            this.maxSpeed = 50;
        } else {
            this.maxSpeed = maxSpeed;
        }
        if (this.currentSpeed > this.maxSpeed) this.currentSpeed = this.maxSpeed;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Aircraft other = (Aircraft) obj;
        if (currentSpeed != other.currentSpeed)
            return false;
        return maxSpeed == other.maxSpeed;
    }

    @Override
    public String toString() {
        return "aircraft: speed= " + currentSpeed + ", maxSpeed= " + maxSpeed;
    }
}
