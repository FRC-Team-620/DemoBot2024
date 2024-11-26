package frc.robot.controlboard;

import edu.wpi.first.wpilibj2.command.button.Trigger;

public interface ControlBoard {
    // =========Driver Controls==========
    public double moveForward();

    public double moveBackward();

    public double rotate();

    // ========Operator Controls=========
    public Trigger intake();

    public Trigger extake();

    public Trigger shoot();
}
