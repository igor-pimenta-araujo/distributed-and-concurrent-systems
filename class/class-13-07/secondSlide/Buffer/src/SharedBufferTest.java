public class SharedBufferTest {

    public static void main(String[] args) {
        Buffer sharedLocation = new UnsynchronizedBuffer();

        // create producer and consumer objects
        Producer producer = new Producer(sharedLocation);
        Consumer consumer = new Consumer(sharedLocation);

        producer.start(); // start producer thread
        consumer.start(); // start consumer thread

    } // end main

} // end class SharedCell