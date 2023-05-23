import java.util.Scanner;
import java.util.concurrent.Semaphore;

public class NumberPrinterSemaphore {
    private final int from, to;
    private final int numThreads;
    private Semaphore[] semaphores;

    public NumberPrinterSemaphore(int from, int to, int numThreads) {
        this.from = from;
        this.to = to;
        this.numThreads = numThreads;
        semaphores = new Semaphore[numThreads];
        for (int i = 0; i < numThreads; ++i) {
            semaphores[i] = new Semaphore(1);
            if (i != 0) {
                try {
                    semaphores[i].acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void printNumbers(int threadId) {
        for (int i = from + threadId; i <= to; i += numThreads) {
            try {
                semaphores[threadId].acquire();
                System.out.println("thread " + threadId + " prints " + i);
                int nextThreadId = (threadId + 1) % numThreads;
                semaphores[nextThreadId].release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please input the range of numbers [from, to]: ");
        int from = sc.nextInt(), to = sc.nextInt();
        System.out.println("Please input the number of threads: ");
        int numThreads = sc.nextInt();
        sc.close();

        NumberPrinterSemaphore nps = 
                new NumberPrinterSemaphore(from, to, numThreads);
        for (int i = 0; i < numThreads; ++i) {
            final int threadId = i;
            Thread thread = new Thread(() -> nps.printNumbers(threadId));
            thread.start();
        }
    }
}
