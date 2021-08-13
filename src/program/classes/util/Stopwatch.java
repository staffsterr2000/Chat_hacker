package program.classes.util;

import program.interfaces.Display;

import java.util.Date;

public class Stopwatch implements Display {
    private Date startTime = null;
    private Date finishTime = null;
    private long differenceBetweenStartAndFinish = 0;
    private boolean isWorking = false;

    @Override
    public void start() {
        if (startTime == null && finishTime == null) differenceBetweenStartAndFinish = 0;
        if (!isWorking) {
            startTime = new Date();
            isWorking = true;
        }
        else pause();
    }

    @Override
    public void pause() {
        if (isWorking) {
            finishTime = new Date();
            differenceBetweenStartAndFinish +=
                    finishTime.getTime() - startTime.getTime();
            isWorking = false;
        }
        else start();
    }

    @Override
    public void stop() {
        if (isWorking) {
            pause();
        }
        startTime = null;
        finishTime = null;
    }

    @Override
    public long display() {
        stop();
        return differenceBetweenStartAndFinish;
    }

    // constructors
    public Stopwatch() {}
}
