package frc.robot;

import edu.wpi.first.wpilibj.Timer;

public class Time {
    private Timer timer;

    public Time() {
        timer = new Timer();
        timer.start();
    }

    public double getTime() {
        return timer.get();
    }

    public void resetTimer() {
        timer.reset();
    }
}
