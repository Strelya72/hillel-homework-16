public class ThreadSleep implements Runnable {
    final long time;

    public ThreadSleep(Long timeToSleep) {
        time = timeToSleep;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
