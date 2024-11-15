package frc.robot.controlboard;

import edu.wpi.first.wpilibj.XboxController;

public class SingleControl implements ControlBoard{
    private XboxController driver = new XboxController(0);

    //====Driver Controls====
    public double rightTrigger() {
        return driver.getRightTriggerAxis();
    }

    public double leftTrigger() {
        return driver.getLeftTriggerAxis();
    }

    public double rightX() {
        return driver.getRightX();
    }

    //====Operator Controls====
    public boolean leftBumper() {
        return driver.getLeftBumper();
    }

    public boolean rightBumper() {
        return driver.getRightBumper();
    }
}
