public class SynchronizedBuffer implements Buffer {
    5 private int buffer = -1; // shared by producer and consumer threads
    6 private int occupiedBufferCount = 0; // count of occupied buffers
    7
    8 // place value into buffer
    9 public synchronized void set( int value )
    10 {
    11 // for output purposes, get name of thread that called this method
    12 String name = Thread.currentThread().getName();
    13
    14 // while there are no empty locations, place thread in waiting state
    15 while ( occupiedBufferCount == 1 ) {
    16
    17 // output thread information and buffer information, then wait
    18 try {
    19 System.err.println( name + " tries to write." );
    20 displayState( "Buffer full. " + name + " waits." );
    21 wait();
    22 }
    23
    24 // if waiting thread interrupted, print stack trace
    25 catch ( InterruptedException exception ) {
    26 exception.printStackTrace();
    27 }