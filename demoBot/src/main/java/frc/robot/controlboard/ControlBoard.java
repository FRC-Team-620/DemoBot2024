package frc.robot.controlboard;

import edu.wpi.first.wpilibj2.command.button.Trigger;

public interface ControlBoard {
    // =========Drivetrain controls==========
    public double rightTrigger();

    public double leftTrigger();

    public double leftX();

    // ========Other Subsystems==============
    public boolean rightBumper();

    public boolean leftBumper();
}
