import java.util.Scanner;

public class NumberPrinterSynchronized {
    private final int maxNum;
    private final int numThreads;
    private int counter;

    public NumberPrinterSynchronized(int from, int to, int numThreads) {
        this.counter = from;
        this.maxNum = to;
        this.numThreads = numThreads;
    }

    public synchronized void printNumbers(int threadId) {
        while (true) {
            if (counter > maxNum) {
                break;
            }

            if (counter % numThreads != threadId) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                continue;
            }

            System.out.println("thread " + threadId + " prints " + counter);
            ++counter;
            notifyAll();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please input the range of numbers [from, to]: ");
        int from = sc.nextInt(), to = sc.nextInt();
        System.out.println("Please input the number of threads: ");
        int numThreads = sc.nextInt();
        sc.close();

        NumberPrinterSynchronized nps = 
                new NumberPrinterSynchronized(from, to, numThreads);
        for (int i = 0; i < numThreads; ++i) {
            final int threadId = i;
            Thread thread = new Thread(() -> nps.printNumbers(threadId));
            thread.start();
        }
    }
}
