public class Producer extends Thread {
    private Buffer sharedLocation; // reference to shared object

    // constructor
    public Producer(Buffer shared) {
        super("Producer");
        sharedLocation = shared;
    }

    // store values from 1 to 4 in sharedLocation
    public void run() {
        for (int count = 1; count <= 4; count++) {

            // sleep 0 to 3 seconds, then place value in Buffer
            try {
                Thread.sleep((int) (Math.random() * 3001));
                sharedLocation.set(count);
            } // if sleeping thread interrupted, print stack trace
            catch (InterruptedException exception) {
                exception.printStackTrace();
            }

        } // end for

        System.err.println(getName() + " done producing." +
                "\nTerminating " + getName() + ".");

    } // end method run

} // end class Producer