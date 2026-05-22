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
        this.driver = new XboxController(Constants.DRIVER_CONTROLLER_ID);
        this.xButton = new JoystickButton(this.driver, XboxController.Button.kX.value);
        this.yButton = new JoystickButton(this.driver, XboxController.Button.kY.value);
        this.rightBumper = new JoystickButton(this.driver, XboxController.Button.kRightBumper.value);
    }

    // ====Driver Controls====
    public double forward() {
        return this.driver.getRightTriggerAxis();
    }

    public double backward() {
        return this.driver.getLeftTriggerAxis();
    }

    public double rotate() {
        return this.driver.getRightX();
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
