package frc.robot.controlboard;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.Constants;

public class SingleControl implements ControlBoard {
    private XboxController driver;
    private Trigger xButton;
    private Trigger yButton;
    private Trigger rightBumper;
    
    public SingleControl() {
        driver = new XboxController(Constants.DRIVER_CONTROLLER_ID);
        xButton = new JoystickButton(driver, XboxController.Button.kX.value);
        yButton = new JoystickButton(driver, XboxController.Button.kY.value);
        rightBumper = new JoystickButton(driver, XboxController.Button.kRightBumper.value);
    }

    // ====Driver Controls====
    public double moveForward() {
        return driver.getRightTriggerAxis();
    }

    public double moveBackward() {
        return driver.getLeftTriggerAxis();
    }

    public double rotate() {
        return driver.getRightX();
    }

    // ====Operator Controls====
    public Trigger intake() {
        return this.xButton;
    }

    public Trigger extake() {
        return this.yButton;
    }

    public Trigger shoot() {
        return this.rightBumper;
    }
}
