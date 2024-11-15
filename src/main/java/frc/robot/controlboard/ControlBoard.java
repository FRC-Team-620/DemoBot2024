package frc.robot.controlboard;

public interface ControlBoard {
    // =========Driver Controls==========
    public double rightTrigger(); // Forward

    public double leftTrigger(); // Backward

    public double rightX(); // Rotation

    // ========Operator Controls==============
    public boolean leftBumper(); // Intake

    public boolean rightBumper(); // Shooter
}
